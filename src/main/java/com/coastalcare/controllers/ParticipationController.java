package com.coastalcare.controllers;

import com.coastalcare.dto.Participation.ParticipationDetailsDTO;
import com.coastalcare.dto.Participation.RegisterParticipationDTO;
import com.coastalcare.models.Participation;
import com.coastalcare.services.ParticipationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/participations")
public class ParticipationController {

    @Autowired
    ParticipationService participationService;

    @PostMapping
    public ResponseEntity<ParticipationDetailsDTO> register(@RequestBody @Valid RegisterParticipationDTO participationDTO,
                                                            UriComponentsBuilder uri) {
        Participation participation = participationService.register(participationDTO);
        var url = uri.path("/participantions/{participantions_id}")
                .buildAndExpand(participation.getId()).toUri();
        return ResponseEntity.created(url).body(new ParticipationDetailsDTO(participation));
    }

    @PutMapping ("/{participation_id}/users/{user_id}")
    public ResponseEntity<ParticipationDetailsDTO> checkIn(@PathVariable("participation_id") Long participationId,
                                           @PathVariable("user_id") Long userId){
        Participation participation = participationService.checkIn(participationId, userId);
        return ResponseEntity.ok(new ParticipationDetailsDTO(participation));
    }

    @GetMapping("/users/{user_id}")
    public ResponseEntity<Page<ParticipationDetailsDTO>> findAllUserParticipations(@PathVariable("user_id") Long userId,
                                                                                   Pageable page) {
        var userParticipations = participationService.getAllUserParticipations(userId, page);
        return ResponseEntity.ok(userParticipations);
    }

    @DeleteMapping("/{participation_id}/users/{user_id}")
    public ResponseEntity<Void> delete(@PathVariable("participation_id") Long participationId,
                                                    @PathVariable("user_id") Long userId){
        participationService.remove(participationId, userId);
        return ResponseEntity.noContent().build();
    }
}
