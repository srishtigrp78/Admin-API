package com.iemr.admin.mapper.emailconfig;

import java.util.List;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.iemr.admin.data.emailconfig.AuthorityEmail;
import com.iemr.admin.model.emailconfig.CreateAuthEmailRequestModel;
import com.iemr.admin.model.emailconfig.CreateNodalEmailRequestModel;
import com.iemr.admin.model.emailconfig.NodalEmailResponse;
import com.iemr.admin.model.emailconfig.AuthEmailRequest;
import com.iemr.admin.model.emailconfig.AuthEmailResponse;
import com.iemr.admin.model.emailconfig.UpdateAuthEmailRequest;
import com.iemr.admin.model.emailconfig.UpdateNodalEmailRequest;

@Mapper(componentModel = "spring")
public interface InstituteEmailConfigMapper
{
	InstituteEmailConfigMapper INSTANCE = Mappers.getMapper(InstituteEmailConfigMapper.class);

	AuthorityEmail requestToInstituteEmailConf(AuthEmailRequest request);

	@IterableMapping(elementTargetType = AuthorityEmail.class)
	List<AuthorityEmail> requestToInstituteEmailConf(List<AuthEmailRequest> request);

	AuthorityEmail createRequestToInstituteEmailConf(CreateAuthEmailRequestModel request);
	
	AuthorityEmail createRequestToInstituteEmailConfig(CreateNodalEmailRequestModel request);

	@IterableMapping(elementTargetType = AuthorityEmail.class)
	List<AuthorityEmail> createRequestToInstituteEmailConf(List<CreateAuthEmailRequestModel> request);
	
	@IterableMapping(elementTargetType = AuthorityEmail.class)
	List<AuthorityEmail> createRequestToInstituteEmailConfig(List<CreateNodalEmailRequestModel> request);

	AuthorityEmail updateRequestToInstituteEmailConf(UpdateAuthEmailRequest request);
	
	AuthorityEmail updateRequestToInstituteNodalEmailConf(UpdateNodalEmailRequest request);

	@IterableMapping(elementTargetType = AuthorityEmail.class)
	List<AuthorityEmail> updateRequestToInstituteEmailConf(List<UpdateAuthEmailRequest> request);

	AuthEmailResponse resultToInstTypeEmailResponse(AuthorityEmail result);
	
	NodalEmailResponse resultToInstTypeNodalEmailResponse(AuthorityEmail result);
	
	NodalEmailResponse resultInstType(AuthorityEmail result);

	@IterableMapping(elementTargetType = AuthEmailResponse.class)
	List<AuthEmailResponse> resultToInstTypeEmailResponse(List<AuthorityEmail> result);
	
	@IterableMapping(elementTargetType = AuthEmailResponse.class)
	List<NodalEmailResponse> resultToInstTypeEmailResponses(List<AuthorityEmail> result);
}
