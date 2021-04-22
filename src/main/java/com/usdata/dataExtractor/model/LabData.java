package com.usdata.dataExtractor.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Data
@Entity
@Table(name = "lab_data")
public class LabData {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long labId;

    @Column(name = "pmrno")
    private String pMrno;

    @Column(name = "diag_name")
    private String diagName;

    @Column(name = "diag_value")
    private String diagValue;

    @Column(name = "data_type")
    private String dataType;

    @Column(name = "created_date")
    private long createdDate;

    @Column(name = "updated_date")
    private long updatedDate;

    @Column(name = "remarks")
    private String remarks;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "patientId", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private PatientData patientId;

    public Long getLabId() {
        return labId;
    }

    public void setLabId(Long labId) {
        this.labId = labId;
    }

    public String getpMrno() {
        return pMrno;
    }

    public void setpMrno(String pMrno) {
        this.pMrno = pMrno;
    }

    public String getDiagName() {
        return diagName;
    }

    public void setDiagName(String diagName) {
        this.diagName = diagName;
    }

    public String getDiagValue() {
        return diagValue;
    }

    public void setDiagValue(String diagValue) {
        this.diagValue = diagValue;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
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

    public PatientData getPatientId() {
        return patientId;
    }

    public void setPatientId(PatientData patientId) {
        this.patientId = patientId;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
