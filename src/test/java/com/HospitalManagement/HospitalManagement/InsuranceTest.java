package com.HospitalManagement.HospitalManagement;

import com.HospitalManagement.HospitalManagement.entity.Appointment;
import com.HospitalManagement.HospitalManagement.entity.Insurance;
import com.HospitalManagement.HospitalManagement.entity.patient;
import com.HospitalManagement.HospitalManagement.service.AppointmentService;
import com.HospitalManagement.HospitalManagement.service.InsuranceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootTest
public class InsuranceTest {

    @Autowired
    private InsuranceService insuranceService;

    @Autowired
    private AppointmentService appointmentService;

    @Test

    public void testInsurance(){
        Insurance insurance= Insurance.builder()
                .provider("HDFC")
                .policyNumber("HDFC_1234")
                .validUntil(LocalDate.of(2030, 12, 15))
                .build();

        patient pat = insuranceService.assignInsuranceToPatient(insurance,1L);
        System.out.println(pat);

        var newPatient = insuranceService.disAssociateInsuranceFromPatient(pat.getId());
        System.out.println(newPatient);
    }

    @Test
    public void createNewAppointment(){
        Appointment appointment = Appointment.builder()
                .appointment(LocalDateTime.of(2025,12,10,14,0))
                .reason("Cancer")
                .build();

        var newAppointment = appointmentService.createNewAppointment(appointment,3L,5L);

        System.out.println(newAppointment);

        var updatedAppointment = appointmentService.reAssignAppointmentToAnotherDoctor(newAppointment.getId(), 1L);

        System.out.println(updatedAppointment);

    }






}
