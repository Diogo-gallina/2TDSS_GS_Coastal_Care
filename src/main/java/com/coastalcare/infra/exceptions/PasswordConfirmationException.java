package com.coastalcare.infra.exceptions;

public class PasswordConfirmationException extends RuntimeException {

    public PasswordConfirmationException() {
        super("Password does not match the confirmation.");
    }

    public PasswordConfirmationException(String message) {
        super(message);
    }

}