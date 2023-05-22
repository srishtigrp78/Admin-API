package com.iemr.admin.model.location;

import lombok.Data;

@Data
public class DistrictBranchMappingModelResponse
{
	private Integer districtBranchID;
	private Integer blockID;
	private String blockName;
	private String panchayatName;
	private String villageName;
	private String habitat;
	private String pinCode;
	private Integer govVillageID;
	private Integer govSubDistrictID;
	private Boolean deleted;
	private String createdBy;
}