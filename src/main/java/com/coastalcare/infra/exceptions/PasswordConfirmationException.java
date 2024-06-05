package com.coastalcare.infra.exceptions;

public class PasswordConfirmationException extends RuntimeException {

    public PasswordConfirmationException() {
        super("Senha não é igual a confirmação");
    }

    public PasswordConfirmationException(String message) {
        super(message);
    }

}