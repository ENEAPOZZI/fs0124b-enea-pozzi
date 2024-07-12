package it.epicode.verificaSecurity.services.serinterface;

import it.epicode.verificaSecurity.data.Event;
import it.epicode.verificaSecurity.data.User;
import it.epicode.verificaSecurity.dto.LoginResponseDto;
import it.epicode.verificaSecurity.dto.RegisterUserDto;
import it.epicode.verificaSecurity.dto.RegisteredUserDto;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface UserService {
    RegisteredUserDto register(RegisterUserDto user);

    Optional<LoginResponseDto> login(String username, String password);

    void bookEvent(long userId, String eventName);

    Event createEvent(String eventName, String location, String description, int maxParticipants, Date eventDate);

    List<jdk.jfr.Event> getAllEvents();

}
