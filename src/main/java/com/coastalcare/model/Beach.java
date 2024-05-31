package com.coastalcare.model;

import com.coastalcare.model.enums.PollutionLevel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "GS_2TDSS_BEACH")
public class Beach {
    @Id
    @GeneratedValue
    @Column(name = "beach_id")
    private Long id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "name", nullable = false)
    private Long latitude;

    @Column(name = "name", nullable = false)
    private Long longitude;

    @Column(name = "pollution_level", nullable = false, length = 10)
    private PollutionLevel pollutionLevel;

    @OneToMany(mappedBy = "beach")
    private List<Event> events;
}
