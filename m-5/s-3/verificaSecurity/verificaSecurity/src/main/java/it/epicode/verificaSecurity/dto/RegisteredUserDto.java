package it.epicode.verificaSecurity.dto;


import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
public class RegisteredUserDto {

    private long id;
    private String username;
    private String friendlyName;
    private final List<String> roles;

    @Builder(setterPrefix = "with")
    public RegisteredUserDto(long id, String username, String friendlyName, String token, List<String> roles) {
        this.id = id;
        this.username = username;
        this.friendlyName = friendlyName;
        this.roles = roles;
    }
}
