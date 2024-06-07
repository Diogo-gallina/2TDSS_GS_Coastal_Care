package com.coastalcare.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter

@Entity
@Table(name = "GS_2TDSS_PARTICIPATION")
@EntityListeners(AuditingEntityListener.class)
public class Participation {

    @Id
    @GeneratedValue
    @Column(name = "participation_id")
    private Long id;

    @Column(name = "participarion_date")
    private LocalDate participarionDate;

    @CreatedDate
    @Column(name = "created_at")
    private LocalDate createdAt;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;

    public Participation(User user, Event event) {
        this.user = user;
        this.event = event;
    }
}
