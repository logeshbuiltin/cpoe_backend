package com.usdata.dataExtractor.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "vaccine_data")
public class VaccineData {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long vaccineId;

    @Column(name = "pmrno")
    private String pMrno;

    @Column(name = "vaccine_name")
    private String vaccineName;

    @Column(name = "vaccine_value")
    private String vaccineValue;

    @Column(name = "createdDate")
    private long createdDate;

    @Column(name = "updated_date")
    private long updatedDate;

    @Column(name = "remarks")
    private String remarks;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "sku_no", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private PatientData patientId;

    public Long getVaccineId() {
        return vaccineId;
    }

    public void setVaccineId(Long vaccineId) {
        this.vaccineId = vaccineId;
    }

    public String getpMrno() {
        return pMrno;
    }

    public void setpMrno(String pMrno) {
        this.pMrno = pMrno;
    }

    public String getVaccineName() {
        return vaccineName;
    }

    public void setVaccineName(String vaccineName) {
        this.vaccineName = vaccineName;
    }

    public String getVaccineValue() {
        return vaccineValue;
    }

    public void setVaccineValue(String vaccineValue) {
        this.vaccineValue = vaccineValue;
    }

    public long getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(long createdDate) {
        this.createdDate = createdDate;
    }

    public PatientData getPatientId() {
        return patientId;
    }

    public void setPatientId(PatientData patientId) {
        this.patientId = patientId;
    }

    public long getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(long updatedDate) {
        this.updatedDate = updatedDate;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
