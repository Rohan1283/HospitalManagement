package com.HospitalManagement.HospitalManagement.service;

import com.HospitalManagement.HospitalManagement.entity.Insurance;
import com.HospitalManagement.HospitalManagement.repository.InsuranceRepository;
import com.HospitalManagement.HospitalManagement.repository.PatientRepository;
import com.HospitalManagement.HospitalManagement.entity.patient;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InsuranceService {
    private final InsuranceRepository insuranceRepository;
    private final PatientRepository patientRepository;

    @Transactional
    public patient assignInsuranceToPatient(Insurance insurance, Long patientId){
        patient pat = patientRepository.findById(patientId).orElseThrow(()-> new EntityNotFoundException("patient not found with id: "+patientId));

        pat.setInsurance(insurance);
        insurance.setPat(pat);

        return pat;
    }

    public patient disAssociateInsuranceFromPatient(Long patientId){
        patient pat1 = patientRepository.findById(patientId).orElseThrow(()-> new EntityNotFoundException("patient not found with id: "+patientId));

        pat1.setInsurance(null);

        return pat1;
    }



}
