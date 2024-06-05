package com.coastalcare.dto.Participation;

import com.coastalcare.models.Participantion;

import java.time.LocalDate;

public record ParticipationDetailsDTO(
        Long participationId,
        Long userId,
        Long eventId,
        LocalDate participationDate,
        LocalDate createdAt
) {

    public ParticipationDetailsDTO(Participantion participantion){
        this(
                participantion.getId(),
                participantion.getUser().getId(),
                participantion.getEvent().getId(),
                participantion.getParticiparionDate(),
                participantion.getCreatedAt()
        );
    }

}
