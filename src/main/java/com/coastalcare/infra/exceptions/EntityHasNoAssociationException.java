package com.coastalcare.infra.exceptions;

public class EntityHasNoAssociationException extends RuntimeException {

    public EntityHasNoAssociationException(String message) {
        super(message);
    }

}