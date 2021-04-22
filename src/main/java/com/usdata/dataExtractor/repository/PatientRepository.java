package com.usdata.dataExtractor.repository;

import com.usdata.dataExtractor.model.PatientData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<PatientData, String> {
    List<PatientData> findAll();

    @Query(
            "select DISTINCT t from PatientData t where t.patientId=:patientId")
    PatientData getPatientById(@Param("patientId") Long patientId);

    @Query(value="select DISTINCT t from PatientData t where t.patientName LIKE CONCAT('%',:searchId,'%') or t.pMrno LIKE CONCAT('%',:searchId,'%') ")
    List<PatientData> getPatientBySearch(String searchId);

}
