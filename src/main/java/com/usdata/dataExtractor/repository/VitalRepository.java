package com.usdata.dataExtractor.repository;

import com.usdata.dataExtractor.model.PatientData;
import com.usdata.dataExtractor.model.VitalData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VitalRepository extends JpaRepository<VitalData, String> {
    @Query(
            "select DISTINCT t from VitalData t where t.patientId=:patientId")
    List<VitalData> getVitalById(@Param("patientId") PatientData patientId);
}
