package com.usdata.dataExtractor.service;

import com.usdata.dataExtractor.model.PatientData;
import com.usdata.dataExtractor.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PatientService {
    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private DateConversionService conversionService;

    HashMap<String, Boolean> responseMap = new HashMap<>();

    public List<PatientData> getAllPatients() {
        return patientRepository.findAll();
    }

    public PatientData getAllPatientsById(Long patientId) {
        return patientRepository.getPatientById(patientId);
    }

    public List<PatientData> getAllPatientBySearchId(String searchId) {
        return patientRepository.getPatientBySearch(searchId);
    }

    public PatientData savePatientRecords(PatientData patientData) {
        Instant instant = Instant.now();
        patientData.setCreatedDate(conversionService.currentEpochDate((instant)));
        return patientRepository.save(patientData);
    }

    public Map<String, Boolean> updatePatientRecord(Long patientId,PatientData patientData) {
        try {
            Instant instant = Instant.now();
            PatientData patientObj = patientRepository.getPatientById(patientId);
            if(patientObj != null) {
                patientObj.setPatientName(patientData.getPatientName());
                patientObj.setpAge(patientData.getpAge());
                patientObj.setpGender(patientData.getpGender());
                patientObj.setUpdatedDate(conversionService.currentEpochDate((instant)));
                patientObj.setpMrno(patientObj.getpMrno());
                final PatientData updatedPatient = patientRepository.save(patientObj);
                responseMap.put("status", Boolean.TRUE);
            }
        } catch (Exception e) {
            responseMap.put("status", Boolean.FALSE);
        }
        return responseMap;
    }

    public Map<String, Boolean> deletePatientData(Long patientId) {
        PatientData patient = patientRepository.getPatientById(patientId);
        if(patient != null) {
            patientRepository.delete(patient);
            responseMap.put("status", Boolean.TRUE);
        } else {
            responseMap.put("status", Boolean.FALSE);
        }
        return responseMap;
    }

    public static boolean isNumeric(String str)
    {
        for (char c : str.toCharArray())
        {
            if (!Character.isDigit(c)) return false;
        }
        return true;
    }
}
