package com.coastalcare.repositories;

import com.coastalcare.models.Beach;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BeachRepository extends JpaRepository<Beach, Long> {
}
