package com.usdata.dataExtractor.controller;

import com.usdata.dataExtractor.model.LabData;
import com.usdata.dataExtractor.model.PatientData;
import com.usdata.dataExtractor.repository.LabRepository;
import com.usdata.dataExtractor.repository.PatientRepository;
import com.usdata.dataExtractor.service.DateConversionService;
import com.usdata.dataExtractor.service.LabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class LabController {
    @Autowired
    private LabService labService;

    @GetMapping("/getallLab")
    public List<LabData> getPatientList() {
        return labService.fetchAllData();
    }

    @GetMapping("/getallLabById/{patientId}")
    public List<LabData> getLabListById(@PathVariable Long patientId) {
        return labService.fetchAllDataById(patientId);
    }

    @GetMapping("/getallByType/{patientId}/{dataType}")
    public List<LabData> getLabListById(@PathVariable Long patientId, @PathVariable String dataType) {
        return labService.fetchAllDataByType(patientId, dataType);
    }

    @PostMapping("/addLab/{patientId}")
    public Map<String, Boolean> addLab(@PathVariable Long patientId, @RequestBody List<LabData> labData){
        return labService.saveLabData(patientId, labData);
    }

}
