package it.epicode.verificaSecurity;


import it.epicode.verificaSecurity.configsecurity.exceptionshttp.FieldValidationException;
import it.epicode.verificaSecurity.data.Event;
import it.epicode.verificaSecurity.dto.RegisterUserDto;
import it.epicode.verificaSecurity.model.LoginModel;
import it.epicode.verificaSecurity.model.RegisterUserModel;
import it.epicode.verificaSecurity.services.exceptionservice.EventAlreadyBookedException;
import it.epicode.verificaSecurity.services.exceptionservice.EventFullException;
import it.epicode.verificaSecurity.services.exceptionservice.EventNotFoundException;
import it.epicode.verificaSecurity.services.exceptionservice.UserNotFoundException;
import it.epicode.verificaSecurity.services.serinterface.UserService;
import it.epicode.verificaSecurity.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class Usercontroller {


    @Autowired
    private UserService users;



    @PostMapping
    public ResponseEntity<?> register(@RequestBody @Validated RegisterUserModel model, //
                                      BindingResult validation, UriComponentsBuilder uri) {
        if (validation.hasErrors()) {
            throw new FieldValidationException(validation.getAllErrors());
        }
        var r = users.register(RegisterUserDto.builder() //
                .withFriendlyName(model.friendlyName()) //
                .withPassword(model.password()) //
                .withUsername(model.username()).withRoles(model.roles()).build());
        var headers = new HttpHeaders();
        headers.add("Location", uri.path("/api/users/{id}").buildAndExpand(r.getId()).toString());
        return new ResponseEntity<>(r, headers, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Validated LoginModel model, //
                                   BindingResult validation) {
        if (validation.hasErrors()) {
            throw new FieldValidationException(validation.getAllErrors());
        }

        return new ResponseEntity<>(users.login(model.username(), model.password()).orElseThrow(), //
                HttpStatus.OK);
    }


    @PostMapping("/bookEvent/{userId}/{eventName}")
    public ResponseEntity<String> bookEvent(@PathVariable long userId, @PathVariable String eventName) {
        try {
            users.bookEvent(userId, eventName);
            return ResponseEntity.ok("Prenotazione effettuata con successo!");
        } catch (EventNotFoundException | UserNotFoundException | EventAlreadyBookedException | EventFullException e) {
            return ResponseEntity.badRequest().body("Errore durante la prenotazione: " + e.getMessage());
        }
    }

    @PostMapping("/create")
    public ResponseEntity<Event> createEvent(
            @RequestParam String eventName,
            @RequestParam String location,
            @RequestParam String description,
            @RequestParam int maxParticipants,
            @RequestParam Date eventDate
            ) {


        Event event = users.createEvent(
                eventName,
                location,
                description,
                maxParticipants,
                eventDate
        );

        return new ResponseEntity<>(event, HttpStatus.CREATED);
    }


    @GetMapping("/all")
    public ResponseEntity<List<jdk.jfr.Event>> getAllEvents() {
        List<jdk.jfr.Event> events = users.getAllEvents();
        return new ResponseEntity<java.util.List<jdk.jfr.Event>>(events, HttpStatus.OK);
    }

}
