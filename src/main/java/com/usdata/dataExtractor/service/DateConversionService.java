package com.usdata.dataExtractor.service;

import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class DateConversionService {
    public long currentEpochDate(Instant instant) {
        long timeStampSeconds = instant.getEpochSecond();
        return timeStampSeconds;
    }
}
