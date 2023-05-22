package com.iemr.admin.model.emailconfig;

import lombok.Data;

@Data
public class UpdateNodalEmailRequest {
	
	private Integer authorityEmailID;
	private Integer stateID;
	private Integer districtID;
	private Integer blockID;
	private Integer districtBranchMappingID;
	private Integer designationID;
	private String authorityName;
	private String emailID;
	private String contactNo;
	private Integer providerServiceMapID;
	private String modifiedBy;
	private Boolean deleted;
	private String mobileNo;

}
