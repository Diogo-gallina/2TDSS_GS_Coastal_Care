package com.coastalcare.models;

import com.coastalcare.dto.beach.CreateBeachDTO;
import com.coastalcare.models.enums.PollutionLevel;
import com.coastalcare.utils.Geocoder;
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

    @Column(name = "latitude", nullable = false, precision = 10)
    private Double latitude;

    @Column(name = "longitude", nullable = false, precision = 10)
    private Double longitude;

    @Enumerated(EnumType.STRING)
    @Column(name = "pollution_level", nullable = false)
    private PollutionLevel pollutionLevel;

    @CreatedDate
    @Column(name = "created_at", nullable = false)
    private LocalDate createdAt;

    @Column(name = "updated_at")
    private LocalDate updatedAt;

    @OneToMany(mappedBy = "beach")
    private List<Event> events;

    @OneToMany(mappedBy = "beach")
    private List<Photo> photos;

    public Beach(CreateBeachDTO beachDTO, Double latitude, Double longitude) {
        this.name = beachDTO.name();
        this.pollutionLevel = beachDTO.pollutionLevel();
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getAddress(Double latitude, Double longitude) {
        return Geocoder.parseCoordinateToAddress(latitude, longitude);
    }
}
