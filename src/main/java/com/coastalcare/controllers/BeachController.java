package com.coastalcare.controllers;

import com.coastalcare.dto.beach.BeachDetailsDTO;
import com.coastalcare.dto.beach.CreateBeachDTO;
import com.coastalcare.dto.beach.UpdateBeachDTO;
import com.coastalcare.models.Beach;
import com.coastalcare.services.BeachService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/beaches")
public class BeachController {

    @Autowired
    BeachService beachService;

    @PostMapping
    public ResponseEntity<BeachDetailsDTO> create(@RequestBody @Valid CreateBeachDTO beachDTO,
                                                  UriComponentsBuilder uri) {
        Beach beach = beachService.create(beachDTO);
        var url = uri.path("/beaches/{beach_id}").buildAndExpand(beach.getId()).toUri();
        return ResponseEntity.created(url).body(new BeachDetailsDTO(beach));
    }

    @GetMapping
    public ResponseEntity<Page<BeachDetailsDTO>> findAll(@PageableDefault(sort = "name") Pageable page) {
        var beachesList = beachService.getAll(page);
        return ResponseEntity.ok(beachesList);
    }

    @GetMapping("/{beach_id}")
    public ResponseEntity<BeachDetailsDTO> findOne(@PathVariable("beach_id") Long beachId) {
        Beach beach = beachService.getOne(beachId);
        return ResponseEntity.ok(new BeachDetailsDTO(beach));
    }

    @GetMapping("byname")
    public ResponseEntity<Page<BeachDetailsDTO>> findByName(@RequestParam("name") String name,
                                                                  Pageable page) {
        var beaches = beachService.findByName(name, page);
        return ResponseEntity.ok(beaches);
    }

    @PutMapping("/{beach_id}")
    public ResponseEntity<BeachDetailsDTO> update(@PathVariable("beach_id") Long beachId,
                                                  @RequestBody @Valid UpdateBeachDTO beachDTO) {
        BeachDetailsDTO beach = beachService.update(beachId, beachDTO);
        return ResponseEntity.ok(beach);
    }

    @DeleteMapping("/{beach_id}")
    public ResponseEntity<Void> delete(@PathVariable("beach_id") Long beachId) {
        beachService.delete(beachId);
        return ResponseEntity.noContent().build();
    }


}
