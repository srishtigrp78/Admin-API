package com.iemr.admin.model.emailconfig;

import lombok.Data;

@Data
public class NodalEmailRequest {
	private Integer authorityEmailID;
	private Integer stateID;
	private Integer districtID;
	private Integer blockID;
	private Integer districtBranchMappingID;
	private Integer designationID;
	private Integer providerServiceMapID;
	private Boolean deleted;
    private String mobileNo;
}
