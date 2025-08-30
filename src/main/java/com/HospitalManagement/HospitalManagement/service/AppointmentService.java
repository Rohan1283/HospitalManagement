package com.HospitalManagement.HospitalManagement.service;

import com.HospitalManagement.HospitalManagement.entity.Appointment;
import com.HospitalManagement.HospitalManagement.entity.patient;
import com.HospitalManagement.HospitalManagement.entity.Doctor;
import com.HospitalManagement.HospitalManagement.repository.AppointmentRepository;
import com.HospitalManagement.HospitalManagement.repository.DoctorRepository;
import com.HospitalManagement.HospitalManagement.repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.print.Doc;

@Service
@RequiredArgsConstructor
public class AppointmentService {
    private final AppointmentRepository appointmentRepository;
    private final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;

    @Transactional
    public Appointment createNewAppointment(Appointment appointment, Long doctorId, Long patientId){
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow();
        patient pat = patientRepository.findById(patientId).orElseThrow();

        if(appointment.getId() != null) throw new IllegalArgumentException("Appointment should not have been present");

        appointment.setPat(pat);
        appointment.setDoctor(doctor);

        pat.getAppointment().add(appointment);  // just to maintain consistency

        return appointmentRepository.save(appointment);
    }

    @Transactional
    public Appointment reAssignAppointmentToAnotherDoctor(Long appointmentId, Long doctorId){
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow();
        Appointment appointment = appointmentRepository.findById(appointmentId).orElseThrow();

        appointment.setDoctor(doctor);

        doctor.getAppointment().add(appointment);


        return appointment;
    }
}

