package com.coastalcare.infra.exceptions;

public class AddressInfoNotFoundException extends RuntimeException{
    public AddressInfoNotFoundException(String message) {
        super(message);
    }
}
