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
package com.iemr.admin.data.snomedMapping;

import java.sql.Timestamp;
import java.util.List;

import com.google.gson.annotations.Expose;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Data;

@Entity
@Table(name = "m_optionalvaccination")
@Data
public class OptionalVaccinations {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "OptionalVaccinationID")
	@Expose
	private Short masterID;
	
	@Column(name = "OptionalVaccinationTime")
	@Expose
	private String vaccinationTime;
	
	@Column(name = "OptionalVaccineName")
	@Expose
	private String masterName;
	
	@Column(name = "OptionalVaccineDesc")
	@Expose
	private String vaccineDesc;

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
	List<OptionalVaccinations> mappingDetails;
}
