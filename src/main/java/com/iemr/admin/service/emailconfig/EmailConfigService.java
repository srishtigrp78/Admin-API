package com.iemr.admin.service.emailconfig;

import java.util.List;

import com.iemr.admin.model.emailconfig.CreateAuthEmailRequestModel;
import com.iemr.admin.model.emailconfig.AuthEmailRequest;
import com.iemr.admin.model.emailconfig.AuthEmailResponse;
import com.iemr.admin.model.emailconfig.UpdateAuthEmailRequest;

public interface EmailConfigService
{
	List<AuthEmailResponse> getAllEmailConfigs(AuthEmailRequest request);

	List<AuthEmailResponse> saveEmailConfigs(List<CreateAuthEmailRequestModel> createEmailRequests);

	AuthEmailResponse updateEmailConfigs(UpdateAuthEmailRequest request);
}
