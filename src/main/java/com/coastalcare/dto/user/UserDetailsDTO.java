package com.coastalcare.dto.user;

import com.coastalcare.models.User;
import com.coastalcare.models.enums.UserType;

import java.time.LocalDate;

public record UserDetailsDTO (
        Long id,
        String name,
        String email,
        UserType userType,
        String password,
        LocalDate createdAt,
        LocalDate updatedAt
) {
    public UserDetailsDTO (User user) {
        this(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getUserType(),
                user.getPassword(),
                user.getCreatedAt(),
                user.getUpdatedAt()
        );
    }
}
