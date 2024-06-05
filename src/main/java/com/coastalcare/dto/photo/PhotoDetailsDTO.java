package com.coastalcare.dto.photo;

import com.coastalcare.models.Photo;
import com.coastalcare.models.enums.ClassificationPhoto;

import java.time.LocalDate;

public record PhotoDetailsDTO(
        Long photoId,
        Long userId,
        Long beachId,
        String url,
        ClassificationPhoto classification,
        LocalDate uploadedDate
) {
    public PhotoDetailsDTO(Photo photo) {
        this(
                photo.getId(),
                photo.getUser().getId(),
                photo.getBeach().getId(),
                photo.getUrl(),
                photo.getClassification(),
                photo.getUploadedDate()
        );
    }
}
