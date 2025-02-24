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
package com.iemr.admin.data.parkingPlace;

import java.sql.Date;

import com.google.gson.annotations.Expose;
import com.iemr.admin.utils.mapper.OutputMapper;

import jakarta.persistence.Transient;
import lombok.Data;

@Data
public class ParkingplaceTalukMappingTO {

	@Expose
	private Integer ppSubDistrictMapID;
	@Expose
	private Integer parkingPlaceID;
	@Expose
	private Integer districtID;
	@Expose
	private Integer districtBlockID;
	@Expose
	private String parkingPlaceName;
	@Expose
	private String districtName;
	@Expose
	private String districtBlockName;
	@Expose
	private Integer providerServiceMapID;
	@Expose
	private Boolean parkingPlaceDeleted;
	@Expose
	private Boolean districtDeleted;
	@Expose
	private Boolean districtBlockDeleted;
	@Expose
	private Boolean deleted;
	@Expose
	private String processed;
	@Expose
	private String createdBy;
	@Expose
	private Date createdDate;
	@Expose
	private String modifiedBy;
	@Expose
	private Date lastModDate;

	@Transient
	private OutputMapper outputMapper = new OutputMapper();

	@Override
	public String toString() {
		return outputMapper.gson().toJson(this);
	}

}
