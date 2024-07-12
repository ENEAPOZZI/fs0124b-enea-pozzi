package it.epicode.verificaSecurity.configsecurity;


import it.epicode.verificaSecurity.data.User;
import it.epicode.verificaSecurity.dto.LoginResponseDto;
import it.epicode.verificaSecurity.dto.RegisterUserDto;
import it.epicode.verificaSecurity.dto.RegisteredUserDto;
import it.epicode.verificaSecurity.mapper.Mapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration

public class BeansConfiguration {

    @Bean
    @Scope("singleton")
    Mapper<RegisterUserDto, User> mapRegisterUser2UserEntity() {
        return (input) -> User.builder() //
                .withFriendlyName(input.getFriendlyName()) //
                .withPassword(input.getPassword()) //
                .withUsername(input.getUsername()) //
                .build();
    }

    @Bean
    @Scope("singleton")
    Mapper<User, RegisteredUserDto> mapUserEntity2RegisteredUser() {
        return (input) -> RegisteredUserDto.builder() //
                .withFriendlyName(input.getFriendlyName()) //
                .withId(input.getId()) //
                .withUsername(input.getUsername()) //
                .withRoles(input.getRoles().stream().map(r -> r.getName()).toList()) //
                .build();
    }

    @Bean
    @Scope("singleton")
    Mapper<User, LoginResponseDto> mapUserEntity2LoginResponse() {
        return (input) -> LoginResponseDto.builder() //
                .withFriendlyName(input.getFriendlyName()) //
                .withId(input.getId()) //
                .withUsername(input.getUsername()) //
                .withRoles(input.getRoles().stream().map(r -> r.getName()).toList()) //
                .build();
    }
}
