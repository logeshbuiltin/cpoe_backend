package com.usdata.dataExtractor.controller;

import com.usdata.dataExtractor.model.PatientData;
import com.usdata.dataExtractor.model.ScreeningData;
import com.usdata.dataExtractor.repository.PatientRepository;
import com.usdata.dataExtractor.repository.ScreeningRepository;
import com.usdata.dataExtractor.service.DateConversionService;
import com.usdata.dataExtractor.service.ScreenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ScreenController {

    @Autowired
    private ScreenService screenService;

    HashMap<String, Boolean> responseMap = new HashMap<>();

    @GetMapping("/getallScreen")
    public List<ScreeningData> getScreenList() {
        return screenService.fetchAllData();
    }

    @GetMapping("/getallScreenById/{patientId}")
    public List<ScreeningData> getScreenListById(@PathVariable Long patientId) {
        return screenService.fetchAllDataById(patientId);
    }

    @PostMapping("/addScreening/{patientId}")
    public Map<String, Boolean> addScreening(@PathVariable Long patientId, @RequestBody List<ScreeningData> screeningData){
        return screenService.saveScreenData(patientId, screeningData);
    }
}
