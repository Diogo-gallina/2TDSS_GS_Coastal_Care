package com.coastalcare.infra.exceptions;

public class AddressInfoNotFound extends RuntimeException{
    public AddressInfoNotFound(String message) {
        super(message);
    }
}
