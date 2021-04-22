package com.usdata.dataExtractor.repository;

import com.usdata.dataExtractor.model.PatientData;
import com.usdata.dataExtractor.model.ScreeningData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScreeningRepository extends JpaRepository<ScreeningData, String> {
    @Query(
            "select DISTINCT t from LabData t where t.patientId=:patientId")
    List<ScreeningData> getScreenById(@Param("patientId") PatientData patientId);
}
