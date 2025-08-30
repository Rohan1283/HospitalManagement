package com.HospitalManagement.HospitalManagement.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Insurance {

    @Override
    public String toString() {
        return "Insurance{" +
                "id=" + id +
                ", policyNumber='" + policyNumber + '\'' +
                ", provider='" + provider + '\'' +
                ", validUntil=" + validUntil +
                ", createdAt=" + createdAt +
                ", hasPatient=" + (pat != null) +  // Just indicate if patient exists
                '}';
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false , unique = true, length = 50)
    private String policyNumber;

    @Column(nullable = false, length = 100)
    private String provider;

    @Column(nullable = false)
    private LocalDate validUntil;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @OneToOne(mappedBy = "insurance")   // inverse side
    private patient pat;
}
