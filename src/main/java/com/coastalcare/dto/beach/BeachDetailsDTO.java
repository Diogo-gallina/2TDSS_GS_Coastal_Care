package com.coastalcare.dto.beach;

import com.coastalcare.models.Beach;
import com.coastalcare.models.enums.PollutionLevel;

import java.time.LocalDate;

public record BeachDetailsDTO (
        Long id,
        String name,
        Double latitude,
        Double longitude,
        String address,
        PollutionLevel pollutionLevel,
        LocalDate createdAt,
        LocalDate updatedAt
) {
    public BeachDetailsDTO(Beach beach) {
        this(
                beach.getId(),
                beach.getName(),
                beach.getLatitude(),
                beach.getLongitude(),
                beach.getAddress(beach.getLatitude(), beach.getLongitude()),
                beach.getPollutionLevel(),
                beach.getCreatedAt(),
                beach.getUpdatedAt()
        );
    }

}
