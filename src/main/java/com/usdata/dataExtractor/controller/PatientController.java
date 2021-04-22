package com.usdata.dataExtractor.controller;

import com.usdata.dataExtractor.model.PatientData;
import com.usdata.dataExtractor.repository.PatientRepository;
import com.usdata.dataExtractor.service.DateConversionService;
import com.usdata.dataExtractor.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class PatientController {
    @Autowired
    private PatientService patientService;

    HashMap<String, Boolean> responseMap = new HashMap<>();

    @GetMapping("/getallPatients")
    public List<PatientData> getPatientList() {
        return patientService.getAllPatients();
    }

    @GetMapping("/getPatientById/{patientId}")
    public PatientData getPatient(@PathVariable Long patientId) {
        return patientService.getAllPatientsById(patientId);
    }

    @GetMapping("/getPatientBySearch/{searchId}")
    public List<PatientData> getPatient(@PathVariable String searchId) {
        return patientService.getAllPatientBySearchId(searchId);
    }

    @PostMapping("/addPatient")
    public PatientData addPatient(@RequestBody PatientData patientData){
        return patientService.savePatientRecords(patientData);
    }

    @PutMapping("/updatePatient/{patientId}")
    public Map<String, Boolean> updatePatientById(@PathVariable Long patientId, @RequestBody PatientData patientDetails){
        return patientService.updatePatientRecord(patientId, patientDetails);
    }

    @DeleteMapping("/deletePatient/{patientId}")
    public Map<String, Boolean> deletePatientById(@PathVariable Long patientId) {
        return patientService.deletePatientData(patientId);
    }

}
