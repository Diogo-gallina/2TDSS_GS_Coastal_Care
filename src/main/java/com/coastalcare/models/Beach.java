package com.coastalcare.models;

import com.coastalcare.models.enums.PollutionLevel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "GS_2TDSS_BEACH")
@EntityListeners(AuditingEntityListener.class)
public class Beach {
    @Id
    @GeneratedValue
    @Column(name = "beach_id")
    private Long id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "latitude", nullable = false)
    private Long latitude;

    @Column(name = "longitude", nullable = false)
    private Long longitude;

    @CreatedDate
    @Column(name = "created_at", nullable = false)
    private LocalDate createdAt;

    @Column(name = "updated_at")
    private LocalDate updatedAt;

    @Column(name = "pollution_level", nullable = false)
    private PollutionLevel pollutionLevel;

    @OneToMany(mappedBy = "beach")
    private List<Event> events;

    @OneToMany(mappedBy = "beach")
    private List<Photo> photos;
}
