package com.iemr.admin.data.provideronboard;

import java.sql.Date;
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
   @Table(name="m_subservicemaster")

public class M_SubservicemasterPA {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Expose
	@Column(name="SubServiceMasterID")
	private Integer subServiceMasterID;
	@Expose
	@Column(name="SubServiceName")
	private String subServiceName;
	@Expose
	@Column(name="SubServiceDesc")
	private String subServiceDesc;
	@Expose
	@Column(name="ServiceID")
	private Integer serviceID; 
	@Expose
	@Column(name="Deleted", insertable = false, updatable = true)
	private Boolean deleted;  
	@Expose
	@Column(name="CreatedBy")
	private String createdBy; 
	@Expose
	@Column(name="CreatedDate", insertable = false, updatable = false)
	private Timestamp createdDate; 
	@Expose
	@Column(name="ModifiedBy")		
	private String modifiedBy;
	@Expose
	@Column(name="LastModDate", insertable = false, updatable = false)
	private Timestamp lastModDate;
	
	
	
	
	
	
	public M_SubservicemasterPA() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
	
	public Integer getSubServiceMasterID() {
		return subServiceMasterID;
	}


	public void setSubServiceMasterID(Integer subServiceMasterID) {
		this.subServiceMasterID = subServiceMasterID;
	}


	public String getSubServiceName() {
		return subServiceName;
	}


	public void setSubServiceName(String subServiceName) {
		this.subServiceName = subServiceName;
	}


	public String getSubServiceDesc() {
		return subServiceDesc;
	}


	public void setSubServiceDesc(String subServiceDesc) {
		this.subServiceDesc = subServiceDesc;
	}


	public Integer getServiceID() {
		return serviceID;
	}


	public void setServiceID(Integer serviceID) {
		this.serviceID = serviceID;
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


	


	public String getModifiedBy() {
		return modifiedBy;
	}


	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}








	public Timestamp getCreatedDate() {
		return createdDate;
	}







	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
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
