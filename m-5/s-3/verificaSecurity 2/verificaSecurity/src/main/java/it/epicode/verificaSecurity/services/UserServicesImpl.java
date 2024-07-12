package it.epicode.verificaSecurity.services;


import it.epicode.verificaSecurity.configsecurity.JwtUtils;
import it.epicode.verificaSecurity.data.Role;
import it.epicode.verificaSecurity.data.User;
import it.epicode.verificaSecurity.data.Event;
import it.epicode.verificaSecurity.dto.LoginResponseDto;
import it.epicode.verificaSecurity.dto.RegisterUserDto;
import it.epicode.verificaSecurity.dto.RegisteredUserDto;
import it.epicode.verificaSecurity.mapper.Mapper;

import it.epicode.verificaSecurity.repository.EventRepository;
import it.epicode.verificaSecurity.repository.RoleRepository;
import it.epicode.verificaSecurity.repository.UserRepository;
import it.epicode.verificaSecurity.services.exceptionservice.*;
import it.epicode.verificaSecurity.services.serinterface.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Stream;

@Service
@Slf4j
public class UserServicesImpl  implements UserService {

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    EventRepository eventRepository;

    @Autowired
    UserRepository users;


    @Autowired
    private RoleRepository roles;

    @Autowired
    private AuthenticationManager auth;

    @Autowired
    private JwtUtils jwt;

    @Autowired
    Mapper<RegisterUserDto, User> mapEntity;
    @Autowired
    Mapper<User, RegisteredUserDto> mapRegisteredUser;
    @Autowired
    Mapper<User, LoginResponseDto> mapLogin;

    @Override
    public RegisteredUserDto register(RegisterUserDto user) {
        try {
            var u = mapEntity.map(user);
            var p = encoder.encode(user.getPassword());
            log.info("Password encrypted: {}", p);
            u.setPassword(p);
            if (user.getRoles() != null)
                Stream.of(user.getRoles().split(",")).forEach(r -> u.getRoles().add(roles.findOneByName(r) //
                        .orElse(roles.save(Role.builder().withName(r).build()))));
            return mapRegisteredUser.map(users.save(u));
        } catch (Exception e) {
            log.error(String.format("Exception saving user %s", user), e);
            throw new PersistEntityException(user);
        }
    }

    @Override
    public Optional<LoginResponseDto> login(String username, String password) {
        try {
            var a = auth.authenticate(new UsernamePasswordAuthenticationToken(username, password));
            a.getAuthorities();
            SecurityContextHolder.getContext().setAuthentication(a);

            var dto = mapLogin.map(users.findOneByUsername(username).orElseThrow());
            dto.setToken(jwt.generateToken(a));
            return Optional.of(dto);
        } catch (NoSuchElementException e) {
            log.error("User not found", e);
            throw new InvalidLoginException(username, password);
        } catch (AuthenticationException e) {
            log.error("Authentication failed", e);
            throw new InvalidLoginException(username, password);
        }
    }



    public void bookEvent(long userId, String eventName) {
        // Verifica se l'evento esiste
        Optional<Event> optionalEvent = eventRepository.findByEventName(eventName);
        if (optionalEvent.isEmpty()) {
            throw new EventNotFoundException("Evento non trovato.");
        }

       Event event = eventRepository.findByEventName(eventName)
               .orElseThrow(() -> new EventNotFoundException("Evento non trovato."));

        // Verifica se l'utente esiste
        Optional<User> optionalUser = users.findById(userId);
        if (optionalUser.isEmpty()) {
            throw new UserNotFoundException("Utente non trovato.");
        }

        User user = users.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("Utente non trovato."));


        // Verifica se l'utente ha già prenotato questo evento
        if (user.getEvents().contains(event)) {
            throw new EventAlreadyBookedException("Hai già prenotato un posto per questo evento.");
        }

        // Controlla se il numero di posti occupati è uguale al massimo numero di partecipanti
        if (event.getPlacesOccupied() >= event.getMaxParticipants()) {
            throw new EventFullException("L'evento è già al completo.");
        }

        // Aggiorna il numero di posti occupati e salva l'evento
        event.setPlacesOccupied(event.getPlacesOccupied() + 1);
        eventRepository.save(event);



        // Aggiungi l'evento alla lista degli eventi prenotati dall'utente e salva l'utente
        user.getEvents().add(event);
        users.save(user);
    }


    public Event createEvent(String eventName, String location, String description, int maxParticipants, Date eventDate) {

        Optional<Event> existingEvent = eventRepository.findByEventName(eventName);
        if (existingEvent.isPresent()) {
            throw new EventAlreadyExistsException("Un evento con lo stesso nome esiste già.");
        }

        Event event = new Event();
        event.setEventName(eventName);
        event.setLocation(location);
        event.setDescription(description);
        event.setPlacesOccupied(0);
        event.setMaxParticipants(maxParticipants);
        event.setEventDate(eventDate);

        return eventRepository.save(event);

    }

    public List<jdk.jfr.Event> getAllEvents() {
        return eventRepository.findAll();
    }

}
