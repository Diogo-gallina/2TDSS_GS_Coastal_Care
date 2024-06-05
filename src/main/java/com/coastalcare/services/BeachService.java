package com.coastalcare.services;

import com.coastalcare.dto.beach.BeachDetailsDTO;
import com.coastalcare.dto.beach.CreateBeachDTO;
import com.coastalcare.dto.beach.UpdateBeachDTO;
import com.coastalcare.models.Beach;
import com.coastalcare.repositories.BeachRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Service
public class BeachService {

    @Autowired
    BeachRepository beachRepository;

    @Transactional
    public Beach create(CreateBeachDTO beachDTO) {
        Beach beach = new Beach(beachDTO);
        return beachRepository.save(beach);
    }

    public Page<BeachDetailsDTO> getAll(Pageable page){
        return beachRepository.findAll(page)
                .map(BeachDetailsDTO::new);
    }

    public Beach getOne(Long beachId) {
        return beachRepository.getReferenceById(beachId);
    }

    public Page<BeachDetailsDTO> findByName(String name, Pageable page) {
        return beachRepository.findByName(name, page)
                .map(BeachDetailsDTO::new);
    }


    @Transactional
    public BeachDetailsDTO update(Long beachId, UpdateBeachDTO beachDTO) {
        Beach beach = beachRepository.getReferenceById(beachId);

        beach.setName(beachDTO.name());
        beach.setLatitude(beachDTO.latitude());
        beach.setLongitude(beachDTO.longitude());
        beach.setPollutionLevel(beachDTO.pollutionLevel());
        beach.setUpdatedAt(LocalDate.now());

        return new BeachDetailsDTO(beach);
    }

    @Transactional
    public void delete(Long beachId) {
        beachRepository.deleteById(beachId);
    }

}
