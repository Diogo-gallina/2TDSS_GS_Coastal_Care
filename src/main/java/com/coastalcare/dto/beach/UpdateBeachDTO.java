package com.coastalcare.dto.beach;

import com.coastalcare.models.enums.PollutionLevel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UpdateBeachDTO (
        @Size(max = 100, message = "Nome deve ter no máximo 100 caracteres")
        String name,

        @Size(max = 150, message = "Endereço próximo deve ter no máximo 150 caracteres")
        String nearbyAddress,

        PollutionLevel pollutionLevel
){
}
