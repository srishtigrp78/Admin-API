package com.iemr.admin.data.snomedMapping;


import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.google.gson.annotations.Expose;


import lombok.Data;

@Entity
@Table(name = "m_childvaccination")
@Data
public class ChildVaccinations {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Expose
	@Column(name = "VaccinationID")
	private Short masterID;
	
	@Expose
	@Column(name = "VaccinationTime")
	private String vaccinationTime;
	
	@Expose
	@Column(name = "VaccineName")
	private String masterName;
	
	@Expose
	@Column(name = "Deleted", insertable = false, updatable = true)
	private Boolean deleted;

	@Expose
	@Column(name = "Processed", insertable = false, updatable = true)
	private String processed;

	@Expose
	@Column(name = "CreatedBy")
	private String createdBy;

	@Expose
	@Column(name = "CreatedDate", insertable = false, updatable = false)
	private Timestamp createdDate;

	@Expose
	@Column(name = "ModifiedBy")
	private String modifiedBy;

	@Expose
	@Column(name = "LastModDate", insertable = false, updatable = false)
	private Timestamp lastModDate;
	
	@Expose
	@Transient
	private String masterType;
	
	@Expose
	@Column(name="Sctcode")
	private String sctCode;
	
	@Expose
	@Column(name="SctTerm")
	private String sctTerm;
	
	@Expose
	@Transient
	List<ChildVaccinations> mappingDetails;


}
