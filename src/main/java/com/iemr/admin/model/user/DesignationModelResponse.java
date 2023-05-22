package com.iemr.admin.model.user;

import lombok.Data;

@Data
public class DesignationModelResponse
{
	private Integer designationID;
	private String designationName;
	private String designationDesc;
	private Boolean deleted;
}