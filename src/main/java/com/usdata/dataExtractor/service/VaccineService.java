package com.usdata.dataExtractor.service;

import com.usdata.dataExtractor.model.PatientData;
import com.usdata.dataExtractor.model.VaccineData;
import com.usdata.dataExtractor.repository.PatientRepository;
import com.usdata.dataExtractor.repository.VaccineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class VaccineService {
    @Autowired
    private VaccineRepository vaccineRepository;
    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private DateConversionService conversionService;

    HashMap<String, Boolean> responseMap = new HashMap<>();

    public List<VaccineData> getVaccineDataList() {
        return vaccineRepository.findAll();
    }

    public List<VaccineData> getVaccineDataById(Long patientId) {
        PatientData patientData = patientRepository.getPatientById(patientId);
        return vaccineRepository.getVaccineById(patientData);
    }

    public Map<String, Boolean> saveVaccineData(Long patientId,List<VaccineData> vaccineData) {
        PatientData patientData = patientRepository.getPatientById(patientId);
        try {
            for (VaccineData vaccine: vaccineData) {
                vaccine.setPatientId(patientData);
                vaccineRepository.save(vaccine);
            }
            responseMap.put("status", Boolean.TRUE);
        } catch (Exception e) {
            responseMap.put("status", Boolean.FALSE);
        }
        return responseMap;
    }
}
