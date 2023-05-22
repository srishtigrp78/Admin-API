package com.iemr.admin.model.institute;

import lombok.Data;

@Data
public class InstituteTypeModelResponse
{
	private Integer institutionTypeID;
	private String institutionType;
	private String institutionTypeDesc;
	private Boolean deleted;
}
