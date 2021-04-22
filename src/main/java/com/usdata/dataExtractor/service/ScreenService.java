package com.usdata.dataExtractor.service;

import com.usdata.dataExtractor.model.PatientData;
import com.usdata.dataExtractor.model.ScreeningData;
import com.usdata.dataExtractor.repository.PatientRepository;
import com.usdata.dataExtractor.repository.ScreeningRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ScreenService {
    @Autowired
    private ScreeningRepository screeningRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private DateConversionService conversionService;

    HashMap<String, Boolean> responseMap = new HashMap<>();

    public List<ScreeningData> fetchAllData() {
        return screeningRepository.findAll();
    }

    public List<ScreeningData> fetchAllDataById(Long patientId) {
        PatientData patientData = patientRepository.getPatientById(patientId);
        return screeningRepository.getScreenById(patientData);
    }

    public Map<String, Boolean> saveScreenData(Long patientId, List<ScreeningData> screeningDataList) {
        PatientData patientData = patientRepository.getPatientById(patientId);
        try {
            for (ScreeningData screen: screeningDataList) {
                screen.setPatientId(patientData);
                screeningRepository.save(screen);
            }
            responseMap.put("status", Boolean.TRUE);
        } catch (Exception e) {
            responseMap.put("status", Boolean.FALSE);
        }
        return responseMap;
    }

}
