package com.coastalcare.controllers;

import com.coastalcare.dto.Participation.ParticipationDetailsDTO;
import com.coastalcare.dto.Participation.RegisterParticipationDTO;
import com.coastalcare.models.Participantion;
import com.coastalcare.services.ParticipantionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/participations")
public class ParticipantionController {

    @Autowired
    ParticipantionService participantionService;

    @PostMapping
    public ResponseEntity<ParticipationDetailsDTO> register(@RequestBody @Valid RegisterParticipationDTO participationDTO,
                                                            UriComponentsBuilder uri) {
        Participantion participantion = participantionService.register(participationDTO);
        var url = uri.path("/participantions/{participantions_id}")
                .buildAndExpand(participantion.getId()).toUri();
        return ResponseEntity.created(url).body(new ParticipationDetailsDTO(participantion));
    }

}
