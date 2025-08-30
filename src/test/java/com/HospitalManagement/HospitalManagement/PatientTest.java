package com.HospitalManagement.HospitalManagement;

import com.HospitalManagement.HospitalManagement.dto.BloodGroupCountResponseEntity;
import com.HospitalManagement.HospitalManagement.entity.patient;
import com.HospitalManagement.HospitalManagement.entity.type.BloodGroupType;
import com.HospitalManagement.HospitalManagement.repository.PatientRepository;
import com.HospitalManagement.HospitalManagement.service.PatientService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
public class PatientTest {

    PatientRepository patientRepository;

    @Autowired
    public PatientTest(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Autowired
    private PatientService patientService;


    @Test
    public void testPatientRepository() {
        List<patient> data = patientRepository.findAll();
        System.out.println(data);
    }

    @Test
    public void testTransactionMethod() {
//        patient pt = patientService.getPatientById(1L);
//
//        System.out.println(pt);

        patient pp = patientRepository.findByName("Dishant Verma");

        System.out.println(pp);
    }

    @Test
    @Transactional
    public void testFindPatientOfGivenSpecification() {
        List<patient> pp = patientRepository.findByDOBOrEmail(LocalDate.of(1988, 3, 15), "kabir.singh@example.com");

//        for(patient pr: pp){
//            System.out.println(pr);
//        }
//        List<patient> data = patientRepository.findByDOBBetween(LocalDate.of(1990, 05, 10), LocalDate.of(1993, 7, 11));
//        List<patient> data1 = patientRepository.findByNameContaining("di");
//        List<patient> data2 = patientRepository.findByBloodGroup(BloodGroupType.A_POSITIVE);

//        List<patient> data2 = patientRepository.findByDOBAfter(LocalDate.of(1988,12,15));

//        for (patient el : data2) {
//            System.out.println(el);
//        }

//        List<Object[]> data3 = patientRepository.countEachBloodGroupType();

//        for (Object[] el : data3) {
//            System.out.println(el[0]+" "+el[1]);
//        }

//        List<patient> patients = patientRepository.findAllPatients();
//        for(patient p : patients){
//            System.out.println(p);
//        }

//        int changedRow = patientRepository.UpdateName("Arav",1L);
//        System.out.println(changedRow);
//
//        List<BloodGroupCountResponseEntity> data3 = patientRepository.countEachBloodGroupType();
//
//        for(BloodGroupCountResponseEntity el: data3){
//            System.out.println(el);
//        }

        Page<patient> patients = patientRepository.findAllPatients(PageRequest.of(1,2, Sort.by("DOB")));
        for(patient p : patients){
            System.out.println(p);
        }

    }





}

