package com.coastalcare.services;

import com.coastalcare.dto.event.CreateEventDTO;
import com.coastalcare.dto.event.EventDetailsDTO;
import com.coastalcare.models.Event;
import com.coastalcare.models.enums.EventStatus;
import com.coastalcare.repositories.EventRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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

}
