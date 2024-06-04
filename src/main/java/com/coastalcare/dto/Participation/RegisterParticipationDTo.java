package com.coastalcare.dto.Participation;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

public record RegisterParticipationDTo(

        @NotNull(message = "Id do usuário não pode ser vazio")
        Long userId,

        @NotNull(message = "Id do evento não pode ser vazio")
        Long eventId

) {
}
