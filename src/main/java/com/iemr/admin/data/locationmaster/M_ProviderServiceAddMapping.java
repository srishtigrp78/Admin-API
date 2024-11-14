/*
* AMRIT – Accessible Medical Records via Integrated Technology 
* Integrated EHR (Electronic Health Records) Solution 
*
* Copyright (C) "Piramal Swasthya Management and Research Institute" 
*
* This file is part of AMRIT.
*
* This program is free software: you can redistribute it and/or modify
* it under the terms of the GNU General Public License as published by
* the Free Software Foundation, either version 3 of the License, or
* (at your option) any later version.
*
* This program is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
* GNU General Public License for more details.
*
* You should have received a copy of the GNU General Public License
* along with this program.  If not, see https://www.gnu.org/licenses/.
*/
package com.iemr.admin.data.locationmaster;

import java.sql.Timestamp;

import com.google.gson.annotations.Expose;
import com.iemr.admin.utils.mapper.OutputMapper;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name="m_ProviderServiceAddMapping")
public class M_ProviderServiceAddMapping {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	
	@Expose
	@Column(name="abdmFacilityName")
	private String abdmFacilityName;
	
	@Expose
	@Column(name="abdmFacilityId")
	private String abdmFacilityId;
	
	
	
	
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




	public String getAbdmFacilityName() {
		return abdmFacilityName;
	}




	public void setAbdmFacilityName(String abdmFacilityName) {
		this.abdmFacilityName = abdmFacilityName;
	}




	public String getAbdmFacilityId() {
		return abdmFacilityId;
	}




	public void setAbdmFacilityId(String abdmFacilityId) {
		this.abdmFacilityId = abdmFacilityId;
	}

}
