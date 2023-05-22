package com.iemr.admin.data.drugstrangth;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.google.gson.annotations.Expose;
import com.iemr.admin.utils.mapper.OutputMapper;

@Entity
@Table(name="m_104DrugStrength")
public class M_104DrugStrength {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Expose
	@Column(name="DrugStrengthID")
	private Integer drugStrengthID;
	
	@Expose
	@Column(name="DrugStrength")
	private String drugStrength;
	
	@Expose
	@Column(name="DrugStrengthDesc")
	private String drugStrengthDesc;
	
	@Expose
	@Column(name="ServiceProviderID")
	private Integer serviceProviderID;
	
	@Expose
	@Column(name="Deleted",insertable = false, updatable = true)
	private Boolean deleted;
	
	@Expose
	@Column(name="CreatedBy")
	private String createdBy;
	
	@Expose
	@Column(name="CreatedDate",insertable = false, updatable = false)
	private Timestamp createdDate;
	
	@Expose
	@Column(name="ModifiedBy")
	private String modifiedBy;
	
	@Expose
	@Column(name="LastModDate",insertable = false, updatable = false)
	private Timestamp lastModDate;
	
	
	public M_104DrugStrength() {
		// TODO Auto-generated constructor stub
	}


	public Integer getDrugStrengthID() {
		return drugStrengthID;
	}


	public void setDrugStrengthID(Integer drugStrengthID) {
		this.drugStrengthID = drugStrengthID;
	}


	public String getDrugStrength() {
		return drugStrength;
	}


	public void setDrugStrength(String drugStrength) {
		this.drugStrength = drugStrength;
	}


	public String getDrugStrengthDesc() {
		return drugStrengthDesc;
	}


	public void setDrugStrengthDesc(String drugStrengthDesc) {
		this.drugStrengthDesc = drugStrengthDesc;
	}


	public Integer getServiceProviderID() {
		return serviceProviderID;
	}


	public void setServiceProviderID(Integer serviceProviderID) {
		this.serviceProviderID = serviceProviderID;
	}


	public Boolean getDeleted() {
		return deleted;
	}


	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}


	public String getCreatedBy() {
		return createdBy;
	}


	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}


	public Timestamp getCreatedDate() {
		return createdDate;
	}


	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}


	public String getModifiedBy() {
		return modifiedBy;
	}


	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}


	public Timestamp getLastModDate() {
		return lastModDate;
	}


	public void setLastModDate(Timestamp lastModDate) {
		this.lastModDate = lastModDate;
	}
	
	
	@Transient
	private OutputMapper outputMapper = new OutputMapper();

	@Override
	public String toString() {
		return outputMapper.gson().toJson(this);
	}
	

}
