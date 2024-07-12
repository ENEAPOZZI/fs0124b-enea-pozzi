package it.epicode.verificaSecurity.dto;


import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
@Builder(setterPrefix = "with")
public class RegisterUserDto extends DtoBase {
    private String username;
    private String password;
    private String friendlyName;
    private String roles;
}
