package com.coastalcare.repositories;

import com.coastalcare.models.Photo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PhotoRepository  extends JpaRepository<Photo, Long> {

    @Query("select p.classification, count(p) from Photo p group by p.classification")
    List<Object[]> countPhotosByClassification();

}
