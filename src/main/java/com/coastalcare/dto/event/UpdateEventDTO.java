package com.coastalcare.dto.event;

import com.coastalcare.models.enums.EventStatus;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

public record UpdateEventDTO (

        @Size(max = 100, message = "Nome deve ter no máximo 100 caracteres")
        String name,

        @Future(message = "Data do evento não pode ser no passado")
        LocalDateTime eventDate,

        @Size(max = 600, message = "Descrição deve ter no máximo 600 caracteres")
        String description,

        @NotNull(message = "Status do evento não pode ser nulo")
        EventStatus status
){
}
