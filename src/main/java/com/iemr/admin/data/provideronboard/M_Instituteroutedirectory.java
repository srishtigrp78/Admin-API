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
package com.iemr.admin.data.provideronboard;

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
@Table(name="m_instituteroutedirectory")
public class M_Instituteroutedirectory {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Expose
	@Column(name = "InstituteRouteDirectoryID")
	private Integer instituteRouteDirectoryID;
	@Expose
	@Column(name = "InstituteSubDirectoryID")
	private Integer instituteSubDirectoryID;
	@Expose
	@Column(name = "InstituteRouteDirectoryName")
	private String instituteRouteDirectoryName;
	@Expose
	@Column(name = "InstituteRouteDirectoryDesc")
	private String instituteRouteDirectoryDesc; 
	@Expose
	@Column(name = "Deleted", insertable = false, updatable = true)
	private Boolean deleted;
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
	
	
	public M_Instituteroutedirectory() {
		// TODO Auto-generated constructor stub
	}


	public Integer getInstituteRouteDirectoryID() {
		return instituteRouteDirectoryID;
	}


	public void setInstituteRouteDirectoryID(Integer instituteRouteDirectoryID) {
		this.instituteRouteDirectoryID = instituteRouteDirectoryID;
	}


	public Integer getInstituteSubDirectoryID() {
		return instituteSubDirectoryID;
	}


	public void setInstituteSubDirectoryID(Integer instituteSubDirectoryID) {
		this.instituteSubDirectoryID = instituteSubDirectoryID;
	}


	public String getInstituteRouteDirectoryName() {
		return instituteRouteDirectoryName;
	}


	public void setInstituteRouteDirectoryName(String instituteRouteDirectoryName) {
		this.instituteRouteDirectoryName = instituteRouteDirectoryName;
	}


	public String getInstituteRouteDirectoryDesc() {
		return instituteRouteDirectoryDesc;
	}


	public void setInstituteRouteDirectoryDesc(String instituteRouteDirectoryDesc) {
		this.instituteRouteDirectoryDesc = instituteRouteDirectoryDesc;
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
