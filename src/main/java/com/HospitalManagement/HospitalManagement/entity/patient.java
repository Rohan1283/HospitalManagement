package com.HospitalManagement.HospitalManagement.entity;

import com.HospitalManagement.HospitalManagement.entity.type.BloodGroupType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Fetch;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@ToString
@Setter
@Getter
@Table(
        uniqueConstraints = {
                @UniqueConstraint(name = "unique_patient_email", columnNames = {"email"}),
                @UniqueConstraint(name = "unique_name_dob", columnNames = {"name","DOB"})
        },
        indexes = {
                @Index(name = "Idx_patient_dateOf_birth",columnList = "DOB")
        }
)
public class patient {


    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", dob=" + DOB +
                ", gender='" + gender + '\'' +
                ", bloodGroup=" + bloodGroup +
                ", createdAt=" + createdAt +
                ", hasInsurance=" + (insurance != null) +  // Just indicate if insurance exists
                '}';
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

//    @ToString.Exclude
    private LocalDate DOB;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String gender;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @Enumerated(EnumType.STRING)
    private BloodGroupType bloodGroup;

    @JoinColumn(name= "patient_insurance_id")
    @OneToOne(cascade = {CascadeType.ALL},orphanRemoval = true)                                         // owning side
    private Insurance insurance;

    @OneToMany(mappedBy = "pat", cascade = {CascadeType.REMOVE}, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Appointment> appointment= new ArrayList<>();

}


