package com.coastalcare.dto.photo;

import com.coastalcare.models.enums.ClassificationPhoto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UploadPhotoDTO(

        @NotNull(message = "Id do usuário não pode ser vazio")
        Long userId,

        @NotNull(message = "Id da praia não pode ser vazio")
        Long beachId,

        @NotBlank(message = "Url não pode ser vazia")
        @Size(max = 1500, message = "Url deve ter no máximo 1500 caracteres")
        String url,

        @NotNull(message = "Classificação da foto não pode ser nula")
        ClassificationPhoto classification
) {
}
