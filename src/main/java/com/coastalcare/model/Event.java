package com.coastalcare.model;

import com.coastalcare.model.enums.EventStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "GS_2TDSS_EVENT")
@EntityListeners(AuditingEntityListener.class)
public class Event {

    @Id
    @GeneratedValue
    @Column(name = "event_id")
    private Long id;

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

    @OneToMany(mappedBy = "event")
    private List<Participantion> participantions;

    @ManyToOne
    @JoinColumn(name = "beach_id")
    private Beach beach;
}
