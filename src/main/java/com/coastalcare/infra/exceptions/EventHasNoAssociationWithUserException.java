package com.coastalcare.infra.exceptions;

public class EventHasNoAssociationWithUserException extends RuntimeException {

    public EventHasNoAssociationWithUserException() {
        super("Evento não está associado com usuário, registre-se no evento antes de confirmar a presença");
    }

}