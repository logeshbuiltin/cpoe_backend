package com.usdata.dataExtractor.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.Date;

@Getter
@Setter
@MappedSuperclass
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class BaseMaster{

  @Id
  @GeneratedValue(generator = "system-uuid")
  @GenericGenerator(name = "system-uuid", strategy = "uuid")
  private String id;

  @Column(name = "unit_id")
  private String unitId;

  @Column(name = "org_id")
  private String orgId;

  @Column(name = "status")
  private char status = 'A';

  @Column(name = "created_by")
  private String createdBy;

  @Column(name = "updated_by")
  private String updatedBy;

  @Column(name = "created_date", nullable = false, updatable = false)
  // @Temporal(TemporalType.TIMESTAMP)
  public Date createdDate;

  @Column(name = "updated_date")
  // @Temporal(TemporalType.TIMESTAMP)
  public Date updatedDate;


}
