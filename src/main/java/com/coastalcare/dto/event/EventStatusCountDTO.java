package com.coastalcare.dto.event;

import com.coastalcare.models.enums.EventStatus;

public record EventStatusCountDTO(
        EventStatus eventStatus,
        Long count
) {
}
