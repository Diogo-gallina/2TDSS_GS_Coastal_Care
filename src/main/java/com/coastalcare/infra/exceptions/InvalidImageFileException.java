package com.coastalcare.infra.exceptions;

public class InvalidImageFileException extends RuntimeException {
    public InvalidImageFileException(String message) {
        super(message);
    }
}
