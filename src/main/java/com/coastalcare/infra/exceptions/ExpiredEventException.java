package com.coastalcare.infra.exceptions;

public class ExpiredEventException extends RuntimeException {

    public ExpiredEventException() {
        super("Data do evento expirada");
    }

}
