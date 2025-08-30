package com.HospitalManagement.HospitalManagement.service;

import com.HospitalManagement.HospitalManagement.entity.patient;
import com.HospitalManagement.HospitalManagement.repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PatientService {
    public final PatientRepository patientRepository;

    @Transactional
    public patient getPatientById(Long id){

        patient p1 = patientRepository.findById(id).orElseThrow();
        patient p2 = patientRepository.findById(id).orElseThrow();

        p1.setName("yahooo");

        return p1;
    }
}
