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
@Table(name = "screen_data")
public class ScreeningData {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long screenId;

    @Column(name = "pmrno")
    private String pMrno;

    @Column(name = "screen_name")
    private String screenName;

    @Column(name = "screen_value")
    private String screenValue;

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

    public Long getScreenId() {
        return screenId;
    }

    public void setScreenId(Long screenId) {
        this.screenId = screenId;
    }

    public String getpMrno() {
        return pMrno;
    }

    public void setpMrno(String pMrno) {
        this.pMrno = pMrno;
    }

    public String getScreenName() {
        return screenName;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    public String getScreenValue() {
        return screenValue;
    }

    public void setScreenValue(String screenValue) {
        this.screenValue = screenValue;
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
