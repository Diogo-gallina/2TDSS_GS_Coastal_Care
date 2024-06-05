package com.coastalcare.services;

import com.coastalcare.dto.Participation.ParticipationDetailsDTO;
import com.coastalcare.dto.Participation.RegisterParticipationDTO;
import com.coastalcare.infra.exceptions.EntityHasNoAssociationException;
import com.coastalcare.infra.exceptions.ExpiredEventException;
import com.coastalcare.models.Event;
import com.coastalcare.models.Participantion;
import com.coastalcare.models.User;
import com.coastalcare.repositories.EventRepository;
import com.coastalcare.repositories.ParticipationRepository;
import com.coastalcare.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ParticipantionService {

    @Autowired
    ParticipationRepository participationRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    EventRepository eventRepository;

    @Transactional
    public Participantion register(RegisterParticipationDTO participationDTO) {
        User user = userRepository.getReferenceById(participationDTO.userId());
        Event event = eventRepository.getReferenceById(participationDTO.eventId());
        Participantion participantion = new Participantion(user, event);

        return participationRepository.save(participantion);
    }

    @Transactional
    public Participantion checkIn(Long participationId, Long userId){
        User user = userRepository.getReferenceById(userId);
        Participantion participation = participationRepository.getReferenceById(participationId);
        LocalDateTime eventDate = participation.getEvent().getEventDate();
        checkEventAssociationWithUser(user, participation);

        if(LocalDate.now().isAfter(eventDate.toLocalDate()))
            throw new ExpiredEventException();

        participation.setParticiparionDate(LocalDate.now());

        return participationRepository.save(participation);
    }

    public Page<ParticipationDetailsDTO> getAllUserParticipations(Long userId, Pageable page) {
        User user = userRepository.getReferenceById(userId);
        List<ParticipationDetailsDTO> participationDetailsDTOs = user.getParticipantions().stream()
                .map(ParticipationDetailsDTO::new)
                .collect(Collectors.toList());

        return new PageImpl<>(participationDetailsDTOs, page, participationDetailsDTOs.size());
    }

    @Transactional
    public void remove(Long participationId, Long userId){
        User user = userRepository.getReferenceById(userId);
        Participantion participation = participationRepository.getReferenceById(participationId);
        checkEventAssociationWithUser(user, participation);

        participationRepository.deleteById(participationId);
    }

    private static void checkEventAssociationWithUser(User user, Participantion participation){
        List<Long> userEventsIndexes = user.getEvents().stream().map(Event::getId).toList();
        if(!userEventsIndexes.contains(participation.getEvent().getId()))
            throw new EntityHasNoAssociationException("Evento não está associado com usuário, registre-se no evento antes de confirmar a presença");
    }

}
