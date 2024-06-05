package com.coastalcare.dto.photo;

import com.coastalcare.models.enums.ClassificationPhoto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UpdatePhotoDTO(

        @NotNull(message = "Id do usuário não pode ser vazio")
        Long userId,

        Long beachId,

        @Size(max = 1500, message = "Url deve ter no máximo 1500 caracteres")
        String url,

        ClassificationPhoto classification

) {
}
