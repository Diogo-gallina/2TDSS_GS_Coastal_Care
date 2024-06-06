package com.coastalcare.dto.photo;

import com.coastalcare.models.enums.ClassificationPhoto;

public record PhotoClassificationCountDTO(
        ClassificationPhoto classification,
        Long count
) {
}
