package com.usdata.dataExtractor.repository;

import com.usdata.dataExtractor.model.LabData;
import com.usdata.dataExtractor.model.PatientData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LabRepository extends JpaRepository<LabData, String> {
    @Query(
            "select DISTINCT t from LabData t where t.patientId=:patientId")
    List<LabData> getLabById(@Param("patientId") PatientData patientId);

    @Query(
            "select DISTINCT t from LabData t where t.patientId=:patientId AND t.dataType=:dataType")
    List<LabData> getDataByType(@Param("patientId") PatientData patientId, @Param("dataType") String dataType);
}
