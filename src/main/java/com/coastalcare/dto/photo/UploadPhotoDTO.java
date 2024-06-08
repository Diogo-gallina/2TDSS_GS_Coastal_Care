package com.coastalcare.dto.photo;

import com.coastalcare.models.enums.ClassificationPhoto;
import jakarta.validation.constraints.NotNull;
import org.springframework.web.multipart.MultipartFile;


public record UploadPhotoDTO(

        @NotNull(message = "Id do usuário não pode ser vazio")
        Long userId,

        @NotNull(message = "Id da praia não pode ser vazio")
        Long beachId,

        @NotNull(message = "Classificação da foto não pode ser nula")
        ClassificationPhoto classification
) {
}
