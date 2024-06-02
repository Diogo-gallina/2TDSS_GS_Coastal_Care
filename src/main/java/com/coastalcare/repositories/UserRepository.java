package com.coastalcare.repositories;

import com.coastalcare.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<Long, User> {
}
