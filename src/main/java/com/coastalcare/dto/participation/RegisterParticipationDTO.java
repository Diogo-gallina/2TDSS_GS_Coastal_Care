package com.coastalcare.dto.participation;

import jakarta.validation.constraints.NotNull;

public record RegisterParticipationDTO(

        @NotNull(message = "Id do usuário não pode ser vazio")
        Long userId,

        @NotNull(message = "Id do evento não pode ser vazio")
        Long eventId

) {
}
