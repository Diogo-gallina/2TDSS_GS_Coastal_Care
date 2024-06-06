package com.coastalcare.dto.user;

import com.coastalcare.models.enums.UserType;

public record UserTypeCountDTO (
        UserType type,
        Long count
){
}
