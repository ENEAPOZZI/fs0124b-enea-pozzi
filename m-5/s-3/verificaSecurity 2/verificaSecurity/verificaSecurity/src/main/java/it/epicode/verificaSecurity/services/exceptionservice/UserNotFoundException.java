package it.epicode.verificaSecurity.services.exceptionservice;

public class UserNotFoundException extends ServiceException {

    public UserNotFoundException(String message) {
        super(message);
    }
}
