package com.coastalcare.repositories;

import com.coastalcare.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository  extends JpaRepository<Long, Event> {
}
