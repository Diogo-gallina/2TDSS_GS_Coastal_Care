package com.coastalcare.services;

import com.coastalcare.dto.event.CreateEventDTO;
import com.coastalcare.dto.event.EventDetailsDTO;
import com.coastalcare.dto.event.UpdateEventDTO;
import com.coastalcare.models.Event;
import com.coastalcare.models.enums.EventStatus;
import com.coastalcare.repositories.EventRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class EventService {

    @Autowired
    EventRepository eventRepository;

    @Transactional
    public Event create(CreateEventDTO eventDTO) {
        Event event = new Event(eventDTO);
        event.setStatus(EventStatus.PLANNED);
        return eventRepository.save(event);
    }

    public Page<EventDetailsDTO> getAll(Pageable page) {
        return eventRepository.findAll(page).map(EventDetailsDTO::new);
    }

    public Event getOne(Long eventId) {
        return eventRepository.getReferenceById(eventId);
    }

    public Event update(Long eventId, UpdateEventDTO eventDTO) {
        Event event = eventRepository.getReferenceById(eventId);

        if(!eventDTO.name().isEmpty())
            event.setName(eventDTO.name());

        if(!eventDTO.description().isEmpty())
            event.setDescription(eventDTO.description());

        if(eventDTO.eventDate() != null)
            event.setEventDate(eventDTO.eventDate());

        event.setStatus(eventDTO.status());
        event.setUpdatedAt(LocalDate.now());
        return eventRepository.save(event);
    }

    public void delete(Long eventId) {
        eventRepository.deleteById(eventId);
    }

}
