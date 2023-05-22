package com.iemr.admin.to;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.google.gson.annotations.Expose;

public class M_UserTO {
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Expose
	@Column(name="PSAddMapID")
	private Integer[] pSAddMapID;
	@Expose
	@Column(name="ProviderServiceMapID")
	private Integer[] providerServiceMapID;
	@Expose
	@Column(name="DistrictID")
	private Integer districtID;
	@Expose
	@Column(name="Address")
	private String  address;
	@Expose
	@Column(name="Deleted")
	private Boolean deleted;
	@Expose
	@Column(name="CreatedBy")
	private String createdBy; 
	@Expose
	@Column(name="CreatedDate")
	private Timestamp createdDate;
	@Expose
	@Column(name="ModifiedBy")
	private String modifiedBy;
	@Expose
	@Column(name="LastModDate")
	private Date lastModDate;
	
	@Expose
	@Column(name="LocationName")
	private String locationName;
	
	
	public M_UserTO() {
		// TODO Auto-generated constructor stub
	}

	

	public M_UserTO(Integer[] pSAddMapID, Integer[] providerServiceMapID, Integer districtID, String address,
			Boolean deleted, String createdBy, Timestamp createdDate, String modifiedBy, Date lastModDate) {
		this.pSAddMapID = pSAddMapID;
		this.providerServiceMapID = providerServiceMapID;
		this.districtID = districtID;
		this.address = address;
		this.deleted = deleted;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.modifiedBy = modifiedBy;
		this.lastModDate = lastModDate;
	}



	public Integer[] getpSAddMapID() {
		return pSAddMapID;
	}



	public void setpSAddMapID(Integer[] pSAddMapID) {
		this.pSAddMapID = pSAddMapID;
	}



	public Integer[] getProviderServiceMapID() {
		return providerServiceMapID;
	}



	public void setProviderServiceMapID(Integer[] providerServiceMapID) {
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



	public Date getLastModDate() {
		return lastModDate;
	}



	public void setLastModDate(Date lastModDate) {
		this.lastModDate = lastModDate;
	}



	public String getLocationName() {
		return locationName;
	}



	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}
	
	


}