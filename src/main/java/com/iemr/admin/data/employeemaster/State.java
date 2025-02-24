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
package com.iemr.admin.data.employeemaster;

import java.sql.Timestamp;

import com.google.gson.annotations.Expose;
import com.iemr.admin.utils.mapper.OutputMapper;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name="m_state")
public class State {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Expose
	@Column(name="StateID")
	private Integer stateID; 
	@Expose
	@Column(name="StateName")
	private String stateName;

	@Expose
	@Column(name="StateCode")
	private char stateCode;
	@Expose
	@Column(name="CountryID")
	private Integer countryID;
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
	
	/*@OneToOne(mappedBy="stateMaster")
	private M_UserServiceRoleMapping2 m_UserServiceRoleMapping;*/
	
	@OneToOne(mappedBy="mstate")
	private M_UserDemographics m_UserDemographics;
	
	public M_UserDemographics getM_UserDemographics() {
		return m_UserDemographics;
	}

	public void setM_UserDemographics(M_UserDemographics m_UserDemographics) {
		this.m_UserDemographics = m_UserDemographics;
	}

	public State() {
		// TODO Auto-generated constructor stub
	}

	public Integer getStateID() {
		return stateID;
	}

	public void setStateID(Integer stateID) {
		this.stateID = stateID;
	}


	public char getStateCode() {
		return stateCode;
	}

	public void setStateCode(char stateCode) {
		this.stateCode = stateCode;
	}

	public Integer getCountryID() {
		return countryID;
	}

	public void setCountryID(Integer countryID) {
		this.countryID = countryID;
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

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	/*public M_UserServiceRoleMapping2 getM_UserServiceRoleMapping() {
		return m_UserServiceRoleMapping;
	}

	public void setM_UserServiceRoleMapping(M_UserServiceRoleMapping2 m_UserServiceRoleMapping) {
		this.m_UserServiceRoleMapping = m_UserServiceRoleMapping;
	}*/
	
	
	
	
	@Transient
	private OutputMapper outputMapper = new OutputMapper();

	@Override
	public String toString() {
		return outputMapper.gson().toJson(this);
	}

	
	


}
