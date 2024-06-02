package com.coastalcare.repositories;

import com.coastalcare.model.Participantion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParticipationRepository  extends JpaRepository<Long, Participantion> {
}
