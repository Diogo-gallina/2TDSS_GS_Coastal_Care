package com.coastalcare.infra;

import com.coastalcare.infra.exceptions.PasswordConfirmationException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Void> error404(){
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler({
            PasswordConfirmationException.class
    })
    public ResponseEntity error400(){
        return ResponseEntity.badRequest().build();
    }

}
