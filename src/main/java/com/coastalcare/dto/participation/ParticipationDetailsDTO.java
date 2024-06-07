package com.coastalcare.dto.participation;

import com.coastalcare.models.Participation;

import java.time.LocalDate;

public record ParticipationDetailsDTO(
        Long participationId,
        Long userId,
        Long eventId,
        LocalDate participationDate,
        LocalDate createdAt
) {

    public ParticipationDetailsDTO(Participation participation){
        this(
                participation.getId(),
                participation.getUser().getId(),
                participation.getEvent().getId(),
                participation.getParticiparionDate(),
                participation.getCreatedAt()
        );
    }

}
