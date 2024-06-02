package com.coastalcare.dto.user;

import com.coastalcare.model.User;
import com.coastalcare.model.enums.UserType;

import java.time.LocalDate;

public record UserDetailsDTO (
        Long id,
        String name,
        String email,
        UserType userType,
        LocalDate createdAt,
        LocalDate updatedAt
) {
    public UserDetailsDTO (User user) {
        this(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getUserType(),
                user.getCreatedAt(),
                user.getUpdatedAt()
        );
    }
}
