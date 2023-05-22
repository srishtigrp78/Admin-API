package com.iemr.admin.service.nodalemailconfig;

import java.util.List;

import com.iemr.admin.model.emailconfig.NodalEmailResponse;
import com.iemr.admin.model.emailconfig.UpdateAuthEmailRequest;
import com.iemr.admin.model.emailconfig.UpdateNodalEmailRequest;
import com.iemr.admin.model.emailconfig.AuthEmailRequest;
import com.iemr.admin.model.emailconfig.AuthEmailResponse;
import com.iemr.admin.model.emailconfig.CreateNodalEmailRequestModel;
import com.iemr.admin.model.emailconfig.NodalEmailRequest;

public interface NodalConfigService {
	
	List<NodalEmailResponse> saveNodalEmailConfigs(List<CreateNodalEmailRequestModel> createEmailRequests);
	
	List<NodalEmailResponse> getAllNodalEmailConfigs(NodalEmailRequest request);
	
	NodalEmailResponse updateNodalEmailConfigs(UpdateNodalEmailRequest request);

}
