package com.coastalcare.controllers;

import com.coastalcare.dto.event.CreateEventDTO;
import com.coastalcare.dto.event.EventDetailsDTO;
import com.coastalcare.dto.event.EventStatusCountDTO;
import com.coastalcare.dto.event.UpdateEventDTO;
import com.coastalcare.models.Event;
import com.coastalcare.services.EventService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

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

    @GetMapping
    public ResponseEntity<Page<EventDetailsDTO>> findAll(@PageableDefault(sort = "name") Pageable page) {
        var eventList = eventService.getAll(page);
        return ResponseEntity.ok(eventList);
    }

    @GetMapping("/{event_id}")
    public ResponseEntity<EventDetailsDTO> findOne(@PathVariable("event_id") Long eventId) {
        var event = eventService.getOne(eventId);
        return ResponseEntity.ok(new EventDetailsDTO((event)));
    }

    @GetMapping("/by-name")
    public ResponseEntity<Page<EventDetailsDTO>> findByName(@RequestParam("name") String name,
                                                            Pageable page) {
        var events = eventService.findByName(name, page);
        return ResponseEntity.ok(events);
    }

    @GetMapping("/by-status")
    public ResponseEntity<Page<EventDetailsDTO>> findByStatus(@RequestParam("status") String status,
                                                            Pageable page) {
        var events = eventService.findByStatus(status, page);
        return ResponseEntity.ok(events);
    }

    @GetMapping("/by-status-count")
    public ResponseEntity<List<EventStatusCountDTO>> getEventCountByStatus() {
        var groupEvents = eventService.getEventCountByStatus();
        return ResponseEntity.ok(groupEvents);
    }

    @PutMapping("/{event_id}")
    public ResponseEntity<EventDetailsDTO> update(@PathVariable("event_id") Long eventId,
                                                  @RequestBody @Valid UpdateEventDTO eventDTO) {
        var event = eventService.update(eventId, eventDTO);
        return ResponseEntity.ok(new EventDetailsDTO((event)));
    }

    @DeleteMapping("/{event_id}")
    public ResponseEntity<Void> delete(@PathVariable("event_id") Long eventId) {
        eventService.delete(eventId);
        return ResponseEntity.noContent().build();
    }

}
