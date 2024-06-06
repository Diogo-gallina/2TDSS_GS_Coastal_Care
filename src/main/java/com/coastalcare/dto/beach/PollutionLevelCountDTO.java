package com.coastalcare.dto.beach;

import com.coastalcare.models.enums.PollutionLevel;

public record PollutionLevelCountDTO(
        PollutionLevel pollutionLevel,
        Long count
) {
}
