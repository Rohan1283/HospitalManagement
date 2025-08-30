package com.HospitalManagement.HospitalManagement.repository;

import com.HospitalManagement.HospitalManagement.dto.BloodGroupCountResponseEntity;
import com.HospitalManagement.HospitalManagement.entity.patient;
import com.HospitalManagement.HospitalManagement.entity.type.BloodGroupType;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface PatientRepository extends JpaRepository<patient,Long> {
    patient findByName(String dishantVerma);

    List<patient> findByDOBOrEmail(LocalDate of, String mail);
    List<patient> findByDOBBetween(LocalDate start, LocalDate end);
    List<patient> findByNameContaining(String query);
    List<patient> findByNameContainingOrderByIdDesc(String que);

    @Query("select p from patient p where p.bloodGroup = :bloodG ")
    List<patient> findByBloodGroup(@Param("bloodG") BloodGroupType bloodGroup);

    @Query("select p from patient p where p.DOB > :date")
    List<patient> findByDOBAfter(@Param("date")LocalDate DOB);

//    @Query("select p.bloodGroup, count(p) from patient p group by p.bloodGroup")     // normal not preferred
//    List<Object> countEachBloodGroupType();

    @Query("select new com.HospitalManagement.HospitalManagement.dto.BloodGroupCountResponseEntity(p.bloodGroup, count(p)) from patient p group by p.bloodGroup")
    List<BloodGroupCountResponseEntity> countEachBloodGroupType();   // Projection  alternative of above and better optimized

//    @Query(value = "select * from patient", nativeQuery = true)
//    List<patient> findAllPatients();

    @Query(value = "select * from patient", nativeQuery = true)                      // Pagination
    Page<patient> findAllPatients(Pageable pageable);


    @Modifying
    @Query("UPDATE patient p set name = :Name where p.id = :p_id")
    int UpdateName(@Param("Name") String name, @Param("p_id") Long id);

}
