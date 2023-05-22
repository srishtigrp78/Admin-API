package com.iemr.admin.model.location;

import lombok.Data;

@Data
public class StateModelResponse
{
	private Integer stateID;
	private String stateName;
	private char stateCode;
	private Integer countryID;
	private Boolean deleted;
}
