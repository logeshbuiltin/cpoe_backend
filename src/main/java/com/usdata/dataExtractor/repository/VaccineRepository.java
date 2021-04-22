package com.usdata.dataExtractor.repository;

import com.usdata.dataExtractor.model.PatientData;
import com.usdata.dataExtractor.model.VaccineData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VaccineRepository extends JpaRepository<VaccineData, String> {
    @Query(
            "select DISTINCT t from VaccineData t where t.patientId=:patientId")
    List<VaccineData> getVaccineById(@Param("patientId") PatientData patientId);
}
