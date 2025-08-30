package com.HospitalManagement.HospitalManagement.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime appointment;

    @Column(length = 500)
    private String reason;

    @ManyToOne
    @ToString.Exclude
    @JoinColumn(name = "patient_appointment_id")
    private patient pat;

    @ManyToOne
    @ToString.Exclude
    @JoinColumn(nullable = false)
    private Doctor doctor;

}
