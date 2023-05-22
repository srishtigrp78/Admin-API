package com.iemr.admin.model.location;

import lombok.Data;

@Data
public class DistrictModelResponse
{
	private Integer districtID;
	private String districtName;
	private Integer stateID;
	private Boolean deleted;
}