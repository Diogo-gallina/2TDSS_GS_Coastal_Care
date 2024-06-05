package com.coastalcare.repositories;

import com.coastalcare.models.Photo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhotoRepository  extends JpaRepository<Photo, Long> {
}
