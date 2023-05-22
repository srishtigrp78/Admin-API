package com.iemr.admin.data.parkingPlace;

import java.sql.Date;

import javax.persistence.Transient;

import com.google.gson.annotations.Expose;
import com.iemr.admin.utils.mapper.OutputMapper;

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
