package com.coastalcare.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "GS_2TDSS_PARTICIPATION")
@EntityListeners(AuditingEntityListener.class)
public class Participantion {

    @Id
    @GeneratedValue
    @Column(name = "participation_id")
    private Long id;

    @CreatedDate
    @Column(name = "participarion_date")
    private LocalDate participarionDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;

}
