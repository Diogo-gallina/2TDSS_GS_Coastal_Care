package com.coastalcare.repositories;

import com.coastalcare.models.Beach;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BeachRepository extends JpaRepository<Beach, Long> {

    @Query("from Beach b where LOWER(b.name) like LOWER(CONCAT('%', :name, '%'))")
    Page<Beach> findByName(@Param("name") String name, Pageable page);

    @Query("from Beach b where LOWER(b.pollutionLevel) = LOWER(:pollution_level)")
    Page<Beach> findByPollutionLevel(@Param("pollution_level") String pollutionLevel, Pageable page);

}
