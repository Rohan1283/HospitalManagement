package com.HospitalManagement.HospitalManagement;

import com.HospitalManagement.HospitalManagement.entity.Appointment;
import com.HospitalManagement.HospitalManagement.repository.AppointmentRepository;
import com.HospitalManagement.HospitalManagement.repository.PatientRepository;
import com.HospitalManagement.HospitalManagement.service.AppointmentService;
import com.HospitalManagement.HospitalManagement.service.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
public class HWTesting {
    @Autowired
    private PatientService patientService;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private AppointmentService appointmentService;

    @Test
    public void createNewAppointmentsAndDeletePatients(){
        Appointment appointment1 = Appointment.builder()
                .appointment(LocalDateTime.of(2025, 11, 24, 12,0))
                .reason("headache")
                .build();

        Appointment appointment2 = Appointment.builder()
                .appointment(LocalDateTime.of(2026,01,11,11,30 ))
                .reason("Leg shin pain")
                .build();

        Appointment appointment3 = Appointment.builder()
                .appointment(LocalDateTime.of(2025,12,9, 16, 00))
                .reason("Root canal teeth")
                .build();


        var ap1 = appointmentService.createNewAppointment(appointment1,3L, 4L);
        System.out.println(ap1);

        Appointment ap2 = appointmentService.createNewAppointment(appointment2,1L,4L);
        System.out.println(ap2);

        Appointment ap3 = appointmentService.createNewAppointment(appointment3,2L,4L);
        System.out.println(ap3);

        patientRepository.deleteById(4L);
    }
}
