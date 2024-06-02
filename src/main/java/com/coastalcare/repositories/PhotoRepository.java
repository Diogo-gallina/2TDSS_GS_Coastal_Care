package com.coastalcare.repositories;

import com.coastalcare.model.Photo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhotoRepository  extends JpaRepository<Long, Photo> {
}
