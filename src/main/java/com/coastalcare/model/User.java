package com.coastalcare.model;

import com.coastalcare.model.enums.UserType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "GS_2TDSS_USER")
@EntityListeners(AuditingEntityListener.class)
public class User {

    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private Long UserId;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "email", nullable = false, length = 100)
    private String email;

    @Column(name = "password", nullable = false, length = 100)
    private String password;

    @Column(name = "user_type", nullable = false, length = 10)
    private UserType userType;

    @CreatedDate
    @Column(name = "created_at", nullable = false)
    private LocalDate createdAt;

    @Column(name = "updated_at")
    private LocalDate updatedAt;

    @Column(name = "deleted_at")
    private LocalDate deletedAt;

}
