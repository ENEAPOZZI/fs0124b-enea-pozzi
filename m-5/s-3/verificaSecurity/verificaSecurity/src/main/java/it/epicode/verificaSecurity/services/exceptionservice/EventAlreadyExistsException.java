package it.epicode.verificaSecurity.services.exceptionservice;

public class EventAlreadyExistsException extends ServiceException  {

    public EventAlreadyExistsException(String message) {
        super(message);
    }
}
