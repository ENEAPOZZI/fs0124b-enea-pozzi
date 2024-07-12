package it.epicode.verificaSecurity.services.exceptionservice;

public class EventAlreadyBookedException extends ServiceException  {

    public EventAlreadyBookedException(String message) {
        super(message);
    }
}
