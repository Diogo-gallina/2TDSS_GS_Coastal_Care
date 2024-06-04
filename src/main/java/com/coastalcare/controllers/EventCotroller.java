package com.coastalcare.controllers;

import com.coastalcare.dto.event.CreateEventDTO;
import com.coastalcare.dto.event.EventDetailsDTO;
import com.coastalcare.models.Event;
import com.coastalcare.services.EventService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/events")
public class EventCotroller {

    @Autowired
    EventService eventService;

    @PostMapping
    public ResponseEntity<EventDetailsDTO> create(@RequestBody @Valid CreateEventDTO eventDTO,
                                                  UriComponentsBuilder uri) {
        Event event = eventService.create(eventDTO);
        var url = uri.path("/events/{event_id}").buildAndExpand(event.getId()).toUri();
        return ResponseEntity.created(url).body(new EventDetailsDTO(event));
    }

}
