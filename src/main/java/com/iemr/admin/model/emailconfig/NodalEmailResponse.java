package com.iemr.admin.model.emailconfig;

import java.sql.Timestamp;

import com.iemr.admin.model.location.DistrictBlockModelResponse;
import com.iemr.admin.model.location.DistrictBranchMappingModelResponse;
import com.iemr.admin.model.location.DistrictModelResponse;
import com.iemr.admin.model.location.StateModelResponse;
import com.iemr.admin.model.provider.ProviderServiceMapModelResponse;
import com.iemr.admin.model.user.DesignationModelResponse;

import lombok.Data;

@Data
public class NodalEmailResponse {
	
	private Integer authorityEmailID;
	private Integer stateID;
	private StateModelResponse state;
	private Integer districtID;
	private DistrictModelResponse district;
	private Integer blockID;
	private DistrictBlockModelResponse districtBlock;
	private Integer districtBranchMappingID;
	private DistrictBranchMappingModelResponse districtBranch;
	private Integer designationID;
	private DesignationModelResponse designation;
	private String authorityName;
	private String emailID;
	private String contactNo;
	private Integer providerServiceMapID;
	private ProviderServiceMapModelResponse providerService;
	private String mobileNo;
	private String createdBy;
	private Timestamp createdDate;
	private String modifiedBy;
	private Timestamp lastModDate;
	private Boolean deleted;
	

}
