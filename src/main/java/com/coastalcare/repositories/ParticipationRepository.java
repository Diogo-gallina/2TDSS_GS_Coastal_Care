package com.coastalcare.repositories;

import com.coastalcare.models.Participation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParticipationRepository  extends JpaRepository<Participation, Long> {
}
