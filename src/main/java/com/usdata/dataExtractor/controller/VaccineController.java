package com.usdata.dataExtractor.controller;

import com.usdata.dataExtractor.model.PatientData;
import com.usdata.dataExtractor.model.ScreeningData;
import com.usdata.dataExtractor.model.VaccineData;
import com.usdata.dataExtractor.repository.PatientRepository;
import com.usdata.dataExtractor.repository.VaccineRepository;
import com.usdata.dataExtractor.service.DateConversionService;
import com.usdata.dataExtractor.service.VaccineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class VaccineController {
    @Autowired
    private VaccineRepository vaccineRepository;

    @Autowired
    private VaccineService vaccineService;

    @Autowired
    private DateConversionService conversionService;

    HashMap<String, Boolean> responseMap = new HashMap<>();

    @GetMapping("/getallVaccine")
    public List<VaccineData> getPatientList() {
        return vaccineService.getVaccineDataList();
    }

    @GetMapping("/getallVaccineById/{patientId}")
    public List<VaccineData> getVaccineListById(@PathVariable Long patientId) {
        return vaccineService.getVaccineDataById(patientId);
    }

    @PostMapping("/addVaccine/{patientId}")
    public Map<String, Boolean> addVaccine(@PathVariable Long patientId, @RequestBody List<VaccineData> vaccineData){
        return vaccineService.saveVaccineData(patientId, vaccineData);
    }

}
