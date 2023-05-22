package com.iemr.admin.data.store;

import javax.persistence.Transient;

import com.google.gson.annotations.Expose;
import com.iemr.admin.utils.mapper.OutputMapper;

import lombok.Data;

@Data
public class M_facilityMap {

	@Expose
	private Integer facilityID;
	
	@Expose
	private Boolean isMainFacility;

	@Expose
	private Integer oldVanID;

	@Expose
	private Integer oldParkingPlaceID;
	@Expose
	private Integer vanID;

	@Expose
	private Integer parkingPlaceID;
	
	@Expose
	private String createdBy;

	@Transient
	private OutputMapper outputMapper = new OutputMapper();

	@Override
	public String toString() {
		return outputMapper.gson().toJson(this);
	}
}
