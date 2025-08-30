package com.HospitalManagement.HospitalManagement.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,length=50)
    private String name;

    @Column(nullable = false, length = 100)
    private String specialization;

    @Column(nullable = false, unique = true, length = 50)
    private String email;

    @OneToMany(mappedBy = "doctor")
    private List<Appointment> appointment;

    @ManyToMany(mappedBy = "doctors")
    private Set<Department> departments = new HashSet<>();
}
