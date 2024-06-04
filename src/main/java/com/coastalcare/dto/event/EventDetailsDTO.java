package com.coastalcare.dto.event;

import com.coastalcare.models.Event;
import com.coastalcare.models.enums.EventStatus;

import java.time.LocalDate;

public record EventDetailsDTO(
        Long id,
        String name,
        LocalDate eventDate,
        String description,
        EventStatus status,
        LocalDate createdAt,
        LocalDate updatedAt
) {
    public EventDetailsDTO(Event event){
        this(
                event.getId(),
                event.getName(),
                event.getEventDate(),
                event.getDescription(),
                event.getStatus(),
                event.getCreatedAt(),
                event.getUpdatedAt()
        );
    }
}
