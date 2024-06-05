package com.coastalcare.dto.event;

import com.coastalcare.models.enums.EventStatus;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

public record CreateEventDTO (

        @NotNull(message = "Id do usuário não pode ser vazio")
        Long userId,

        @NotNull(message = "Id da praia não pode ser vazio")
        Long beachId,

        @NotBlank(message = "Nome não pode ser vazio")
        @Size(max = 100, message = "Nome deve ter no máximo 100 caracteres")
        String name,

        @NotNull(message = "Data do evento não pode ser nula")
        @Future(message = "Data do evento não pode ser no passado")
        LocalDateTime eventDate,

        @NotBlank(message = "Descrição não pode ser vazia")
        @Size(max = 600, message = "Descrição deve ter no máximo 600 caracteres")
        String description

) {
}
