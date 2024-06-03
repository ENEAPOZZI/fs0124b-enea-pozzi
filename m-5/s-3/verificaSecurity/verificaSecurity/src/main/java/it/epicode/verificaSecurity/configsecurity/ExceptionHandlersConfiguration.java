package it.epicode.verificaSecurity.configsecurity;

import it.epicode.verificaSecurity.configsecurity.exceptionshttp.FieldValidationException;
import org.hibernate.service.spi.ServiceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;

public class ExceptionHandlersConfiguration extends ResponseEntityExceptionHandler {

    public record ValidationError(String field, String message) {
    }

    @ExceptionHandler(FieldValidationException.class)
    protected ResponseEntity<?> handleApiValidationException(FieldValidationException e) {
        var body = e.errors.stream() //
                .map(error -> new ValidationError(error.getField(), error.getDefaultMessage())//
                ).toList();
        return new ResponseEntity<List<ValidationError>>(body, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ServiceException.class)
    protected ResponseEntity<?> handleAppException(ServiceException e) {
        return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
