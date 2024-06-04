package com.coastalcare.dto.beach;

import com.coastalcare.models.enums.PollutionLevel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UpdateBeachDTO (
        @NotBlank(message = "Nome não pode ser vazio")
        @Size(max = 100, message = "Nome deve ter no máximo 100 caracteres")
        String name,

        @NotNull(message = "Latitude não pode ser vazia")
        Long latitude,

        @NotNull(message = "Longitude não pode ser vazia")
        Long longitude,

        @NotNull(message = "Nível de poluição não pode ser vazio")
        PollutionLevel pollutionLevel
){
}
