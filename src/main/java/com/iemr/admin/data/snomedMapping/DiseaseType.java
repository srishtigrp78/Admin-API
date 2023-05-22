package com.iemr.admin.data.snomedMapping;


import java.sql.Timestamp;
import java.util.ArrayList;
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
@Table(name = "m_diseasetype")
@Data
public class DiseaseType {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Expose
	@Column(name = "DiseaseTypeID")
	private Short masterID;

	@Expose
	@Column(name = "DiseaseType")
	private String masterName;

	@Expose
	@Column(name = "DiseaseTypeDesc")
	private String diseaseTypeDesc;

	@Expose
	@Column(name = "Gender")
	private String gender;

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
	private List<DiseaseType> mappingDetails;
	
//	@Transient
//	private DiseaseType[] mappingDetails1;
	
	
}
