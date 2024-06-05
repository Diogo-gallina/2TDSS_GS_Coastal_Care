package com.coastalcare.services;

import com.coastalcare.dto.Participation.RegisterParticipationDTO;
import com.coastalcare.infra.exceptions.EventHasNoAssociationWithUserException;
import com.coastalcare.infra.exceptions.ExpiredEventException;
import com.coastalcare.models.Event;
import com.coastalcare.models.Participantion;
import com.coastalcare.models.User;
import com.coastalcare.repositories.EventRepository;
import com.coastalcare.repositories.ParticipationRepository;
import com.coastalcare.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ParticipantionService {

    @Autowired
    ParticipationRepository participationRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    EventRepository eventRepository;

    public Participantion register(RegisterParticipationDTO participationDTO) {
        User user = userRepository.getReferenceById(participationDTO.userId());
        Event event = eventRepository.getReferenceById(participationDTO.eventId());
        Participantion participantion = new Participantion(user, event);

        return participationRepository.save(participantion);
    }

    public Participantion checkIn(Long participationId, Long userId){
        User user = userRepository.getReferenceById(userId);
        Participantion participantion = participationRepository.getReferenceById(participationId);
        LocalDateTime eventDate = participantion.getEvent().getEventDate();
        List<Long> userEventsIndexes = user.getEvents().stream().map(Event::getId).toList();

        if(!userEventsIndexes.contains(participantion.getEvent().getId()))
            throw new EventHasNoAssociationWithUserException();

        if(LocalDate.now().isAfter(eventDate.toLocalDate()))
            throw new ExpiredEventException();

        participantion.setParticiparionDate(LocalDate.now());

        return participationRepository.save(participantion);
    }

}
