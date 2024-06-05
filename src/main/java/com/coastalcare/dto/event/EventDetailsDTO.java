package com.coastalcare.dto.event;

import com.coastalcare.models.Event;
import com.coastalcare.models.enums.EventStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record EventDetailsDTO(
        Long eventid,
        Long userId,
        Long beachId,
        String name,
        LocalDateTime eventDate,
        String description,
        EventStatus status,
        LocalDate createdAt,
        LocalDate updatedAt
) {
    public EventDetailsDTO(Event event){
        this(
                event.getId(),
                event.getUser().getId(),
                event.getBeach().getId(),
                event.getName(),
                event.getEventDate(),
                event.getDescription(),
                event.getStatus(),
                event.getCreatedAt(),
                event.getUpdatedAt()
        );
    }
}
