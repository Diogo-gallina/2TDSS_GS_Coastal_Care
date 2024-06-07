package com.coastalcare.dto.beach;

import com.coastalcare.models.enums.PollutionLevel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CreateBeachDTO(

        @NotBlank(message = "Nome não pode ser vazio")
        @Size(max = 100, message = "Nome deve ter no máximo 100 caracteres")
        String name,

        @NotBlank(message = "Endereço próximo não pode ser vazio")
        @Size(max = 150, message = "Endereço próximo ter no máximo 150 caracteres")
        String nearbyAddress,

        @NotNull(message = "Nível de poluição não pode ser vazio")
        PollutionLevel pollutionLevel
) {
}
