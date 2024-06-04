package com.coastalcare.models;

import com.coastalcare.dto.event.CreateEventDTO;
import com.coastalcare.models.enums.EventStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter

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

    @Column(name = "event_date", nullable = false)
    private LocalDate eventDate;

    @Column(name = "description", nullable = false, length = 600)
    private String description;

    @Column(name = "status", nullable = false)
    private EventStatus status;

    @CreatedDate
    @Column(name = "created_at", nullable = false)
    private LocalDate createdAt;

    @Column(name = "updated_at")
    private LocalDate updatedAt;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "event")
    private List<Participantion> participantions;

    @ManyToOne
    @JoinColumn(name = "beach_id")
    private Beach beach;

    public Event(CreateEventDTO eventDTO) {
        name = eventDTO.name();
        eventDate = eventDTO.eventDate();
        description = eventDTO.description();
    }
}
