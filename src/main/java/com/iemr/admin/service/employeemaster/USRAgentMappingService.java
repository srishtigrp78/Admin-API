package com.iemr.admin.service.employeemaster;

import java.util.List;

import com.iemr.admin.data.employeemaster.USRAgentMapping;
import com.iemr.admin.utils.exception.IEMRException;

public interface USRAgentMappingService
{
	List<USRAgentMapping> getAvailableAgentIds(String request) throws IEMRException, com.iemr.admin.utils.exception.IEMRException;

	Integer updateAgentIds(String request) throws IEMRException;
	
	List<USRAgentMapping> createUSRAgentMapping(String request) throws IEMRException;
	
	List<String> getAvailableCampaigns(String request) throws IEMRException;

	List<USRAgentMapping> getAllAgentIds(String request) throws IEMRException;

	Integer updateCTICampaignNameMapping(String request) throws IEMRException;

	void updateDeletedAgentIDStatus(String agentID);
}
