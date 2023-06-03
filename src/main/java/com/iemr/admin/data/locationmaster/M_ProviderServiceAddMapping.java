package com.iemr.admin.data.locationmaster;

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
@Table(name="m_ProviderServiceAddMapping")
public class M_ProviderServiceAddMapping {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Expose
	@Column(name="PSAddMapID")
	private Integer pSAddMapID;
	@Expose
	@Column(name="ProviderServiceMapID")
	private Integer providerServiceMapID;
	@Expose
	@Column(name="DistrictID")
	private Integer districtID;
	@Expose
	@Column(name="Address")
	private String  address;
	@Expose
	@Column(name="Deleted", insertable=false, updatable=true)
	private Boolean deleted;
	@Expose
	@Column(name="CreatedBy")
	private String createdBy; 
	@Expose
	@Column(name="CreatedDate", insertable=false, updatable=false)
	private Timestamp createdDate;
	@Expose
	@Column(name="ModifiedBy")
	private String modifiedBy;
	@Expose
	@Column(name="LastModDate", insertable=false, updatable=false)
	private Timestamp lastModDate;
	
	@Expose
	@Column(name="LocationName")
	private String locationName;
	
	
	
	
	public M_ProviderServiceAddMapping() {
		// TODO Auto-generated constructor stub
	}




	public Integer getpSAddMapID() {
		return pSAddMapID;
	}




	public void setpSAddMapID(Integer pSAddMapID) {
		this.pSAddMapID = pSAddMapID;
	}




	public Integer getProviderServiceMapID() {
		return providerServiceMapID;
	}




	public void setProviderServiceMapID(Integer providerServiceMapID) {
		this.providerServiceMapID = providerServiceMapID;
	}




	public Integer getDistrictID() {
		return districtID;
	}




	public void setDistrictID(Integer districtID) {
		this.districtID = districtID;
	}




	public String getAddress() {
		return address;
	}




	public void setAddress(String address) {
		this.address = address;
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




	public String getLocationName() {
		return locationName;
	}




	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	@Transient
	private OutputMapper outputMapper = new OutputMapper();

	@Override
	public String toString() {
		return outputMapper.gson().toJson(this);
	}

}