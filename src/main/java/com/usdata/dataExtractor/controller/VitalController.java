package com.usdata.dataExtractor.controller;

import com.usdata.dataExtractor.model.PatientData;
import com.usdata.dataExtractor.model.VitalData;
import com.usdata.dataExtractor.repository.PatientRepository;
import com.usdata.dataExtractor.repository.VitalRepository;
import com.usdata.dataExtractor.service.DateConversionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class VitalController {
    @Autowired
    private VitalRepository vitalRepository;
    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private DateConversionService conversionService;

    HashMap<String, Boolean> responseMap = new HashMap<>();

    @GetMapping("/getallVital")
    public List<VitalData> getPatientList() {
        return vitalRepository.findAll();
    }

    @GetMapping("/getallVitalsById/{patientId}")
    public List<VitalData> getVitalListById(@PathVariable Long patientId) {
        PatientData patientData = patientRepository.getPatientById(patientId);
        return vitalRepository.getVitalById(patientData);
    }

    @PostMapping("/addVital/{patientId}")
    public VitalData addVVitals(@PathVariable Long patientId, @RequestBody VitalData vitalData){
        PatientData patientData = patientRepository.getPatientById(patientId);
        vitalData.setPatientId(patientData);
        return vitalRepository.save(vitalData);
    }
}
