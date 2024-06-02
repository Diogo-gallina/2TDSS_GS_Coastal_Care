package com.coastalcare.model;

import com.coastalcare.model.enums.ClassificationPhoto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "GS_2TDSS_PHOTO")
@EntityListeners(AuditingEntityListener.class)
public class Photo {

    @Id
    @GeneratedValue
    @Column(name = "photo_id")
    private Long id;

    @Column(name = "url", nullable = false, length = 1500)
    private String url;

    @Column(name = "classification", nullable = false)
    private ClassificationPhoto classification;

    @CreatedDate
    @Column(name = "uploadedDate", nullable = false)
    private LocalDate uploadedDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "beach_id")
    private Beach beach;

}
