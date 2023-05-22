package com.iemr.admin.model.location;

import lombok.Data;

@Data
public class DistrictBlockModelResponse
{
	private Integer blockID;
	private Integer districtID;
	private String blockName;
	private Integer stateID;
	private Boolean deleted;
}
