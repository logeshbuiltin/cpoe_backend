package com.usdata.dataExtractor.service;

import com.usdata.dataExtractor.model.LabData;
import com.usdata.dataExtractor.model.PatientData;
import com.usdata.dataExtractor.repository.LabRepository;
import com.usdata.dataExtractor.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class LabService {
    @Autowired
    private LabRepository labRepository;
    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private DateConversionService conversionService;

    HashMap<String, Boolean> responseMap = new HashMap<>();

    public List<LabData> fetchAllData() {
       return labRepository.findAll();
    }

    public List<LabData> fetchAllDataById(Long patientId) {
        PatientData patientData = patientRepository.getPatientById(patientId);
        return labRepository.getLabById(patientData);
    }

    public Map<String, Boolean> saveLabData(Long patientId, List<LabData> labDataList) {
        PatientData patientData = patientRepository.getPatientById(patientId);
        try {
            for (LabData lab: labDataList) {
                lab.setPatientId(patientData);
                labRepository.save(lab);
            }
            responseMap.put("status", Boolean.TRUE);
        } catch (Exception e) {
            responseMap.put("status", Boolean.FALSE);
        }
        return responseMap;
    }

    public List<LabData> fetchAllDataByType(Long patientId, String dataType) {
        PatientData patientData = patientRepository.getPatientById(patientId);
        return labRepository.getDataByType(patientData, dataType);
    }
}
