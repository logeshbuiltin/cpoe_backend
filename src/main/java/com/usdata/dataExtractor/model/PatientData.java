package com.usdata.dataExtractor.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "patient_data")
public class PatientData {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long patientId;

    @Column(name = "patient_name")
    private String patientName;

    @Column(name = "p_mrno")
    private String pMrno;

    @Column(name = "p_gender")
    private String pGender;

    @Column(name = "p_age")
    private String pAge;

    @Column(name = "createdDate")
    private long createdDate;

    @Column(name = "updatedDate")
    private long updatedDate;

    @Column(name = "p_status")
    private String pStatus;

    public String getpMrno() {
        return pMrno;
    }

    public void setpMrno(String pMrno) {
        this.pMrno = pMrno;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getpGender() {
        return pGender;
    }

    public void setpGender(String pGender) {
        this.pGender = pGender;
    }

    public String getpAge() {
        return pAge;
    }

    public void setpAge(String pAge) {
        this.pAge = pAge;
    }

    public long getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(long createdDate) {
        this.createdDate = createdDate;
    }

    public long getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(long updatedDate) {
        this.updatedDate = updatedDate;
    }

    public String getpStatus() {
        return pStatus;
    }

    public void setpStatus(String pStatus) {
        this.pStatus = pStatus;
    }
}
