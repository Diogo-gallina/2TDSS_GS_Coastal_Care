package com.coastalcare.model;

import com.coastalcare.model.enums.EventStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "GS_2TDSS_EVENT")
@EntityListeners(AuditingEntityListener.class)
public class Event {

    @Id
    @GeneratedValue
    @Column(name = "event_id")
    private Long eventId;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    private LocalDate eventDate;

    @Column(name = "description", nullable = false, length = 100)
    private String description;

    @Column(name = "status", nullable = false, length = 15)
    private EventStatus status;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
