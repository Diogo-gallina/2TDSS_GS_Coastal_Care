package com.coastalcare.services;

import com.coastalcare.dto.event.CreateEventDTO;
import com.coastalcare.models.Event;
import com.coastalcare.repositories.EventRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventService {

    @Autowired
    EventRepository eventRepository;

    @Transactional
    public Event create(CreateEventDTO eventDTO) {
        Event event = new Event(eventDTO);
        return eventRepository.save(event);
    }

}
