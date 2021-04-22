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
@Table(name = "vital_data")
public class VitalData {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long vitalId;

    @Column(name = "pmrno")
    private String pMrno;

    @Column(name = "vital_name")
    private String vitalName;

    @Column(name = "vital_value")
    private String vitalValue;

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

    public Long getVitalId() {
        return vitalId;
    }

    public void setVitalId(Long vitalId) {
        this.vitalId = vitalId;
    }

    public String getpMrno() {
        return pMrno;
    }

    public void setpMrno(String pMrno) {
        this.pMrno = pMrno;
    }

    public String getVitalName() {
        return vitalName;
    }

    public void setVitalName(String vitalName) {
        this.vitalName = vitalName;
    }

    public String getVitalValue() {
        return vitalValue;
    }

    public void setVitalValue(String vitalValue) {
        this.vitalValue = vitalValue;
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
