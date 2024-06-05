package com.coastalcare.services;

import com.coastalcare.dto.Participation.RegisterParticipationDTO;
import com.coastalcare.models.Event;
import com.coastalcare.models.Participantion;
import com.coastalcare.models.User;
import com.coastalcare.repositories.EventRepository;
import com.coastalcare.repositories.ParticipationRepository;
import com.coastalcare.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
