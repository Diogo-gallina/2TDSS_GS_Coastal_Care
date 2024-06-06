package com.coastalcare.repositories;

import com.coastalcare.models.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository  extends JpaRepository<User, Long> {

    @Query("from User u where LOWER(u.name) like LOWER(CONCAT('%', :name, '%'))")
    Page<User> findByName(@Param("name") String name, Pageable page);

    @Query("from User u where LOWER(u.email) like LOWER(CONCAT('%', :email, '%'))")
    Page<User> findByEmail(@Param("email") String email, Pageable page);

    @Query("from User u where LOWER(u.userType) = LOWER(:type)")
    Page<User> findByUserType(@Param("type") String type, Pageable page);

    @Query("select u.userType, count(u) from User u group by u.userType")
    List<Object[]> countUsersByType();

}
