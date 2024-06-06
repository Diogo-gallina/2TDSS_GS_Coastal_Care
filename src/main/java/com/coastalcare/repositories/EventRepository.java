package com.coastalcare.repositories;

import com.coastalcare.models.Event;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EventRepository  extends JpaRepository<Event, Long> {

    @Query("from Event e where LOWER(e.name) like LOWER(CONCAT('%', :name, '%'))")
    Page<Event> findByName(@Param("name") String name, Pageable page);

    @Query("from Event e where LOWER(e.status) = LOWER(:status)")
    Page<Event> findByStatus(@Param("status") String status, Pageable page);

}
