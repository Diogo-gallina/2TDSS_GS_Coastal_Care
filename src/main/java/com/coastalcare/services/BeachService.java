package com.coastalcare.services;

import com.coastalcare.dto.beach.BeachDetailsDTO;
import com.coastalcare.dto.beach.CreateBeachDTO;
import com.coastalcare.dto.beach.PollutionLevelCountDTO;
import com.coastalcare.dto.beach.UpdateBeachDTO;
import com.coastalcare.dto.geocoder.GeocodeLatLgnResponseDTO;
import com.coastalcare.models.Beach;
import com.coastalcare.models.enums.PollutionLevel;
import com.coastalcare.repositories.BeachRepository;
import com.coastalcare.utils.Geocoder;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BeachService {

    @Autowired
    BeachRepository beachRepository;

    @Transactional
    public Beach create(CreateBeachDTO beachDTO) {
        GeocodeLatLgnResponseDTO coordinate = Geocoder.parseAddressToCoordinate(beachDTO.nearbyAddress());
        Beach beach = new Beach(beachDTO, coordinate.latitude(), coordinate.longitude());
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

    public Page<BeachDetailsDTO> findByPollutionLevel(String pollutionLevel, Pageable page) {
        return beachRepository.findByPollutionLevel(pollutionLevel, page)
                .map(BeachDetailsDTO::new);
    }

    public List<PollutionLevelCountDTO> getBeachCountByPollutionLevel() {
        List<Object[]> results = beachRepository.countBeachesByPollutionLevel();
        return results.stream()
                .map(result -> new PollutionLevelCountDTO((PollutionLevel) result[0], (Long) result[1]))
                .toList();
    }

    @Transactional
    public BeachDetailsDTO update(Long beachId, UpdateBeachDTO beachDTO) {
        Beach beach = beachRepository.getReferenceById(beachId);
        GeocodeLatLgnResponseDTO coordinate = Geocoder.parseAddressToCoordinate(beachDTO.nearbyAddress());

        if (!beachDTO.nearbyAddress().isEmpty()){
            beach.setLatitude(coordinate.latitude());
            beach.setLongitude(coordinate.longitude());
        }

        if (!beachDTO.name().isEmpty())
            beach.setName(beachDTO.name());

        if (beachDTO.pollutionLevel() != null)
            beach.setPollutionLevel(beachDTO.pollutionLevel());

        beach.setUpdatedAt(LocalDate.now());

        return new BeachDetailsDTO(beach);
    }

    @Transactional
    public void delete(Long beachId) {
        beachRepository.deleteById(beachId);
    }

}
