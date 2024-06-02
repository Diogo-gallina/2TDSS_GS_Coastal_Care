package com.coastalcare.repositories;

import com.coastalcare.model.Beach;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BeachRepository extends JpaRepository<Long, Beach> {
}
