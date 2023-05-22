package com.iemr.admin.service.vanSpokeMapping;

import com.iemr.admin.utils.exception.IEMRException;

public interface VanSpokeMappingService {
	public String saveVanSpokeMapping(String requestObj) throws IEMRException;
	
	public String getVanSpokeMappingDetails(String requestObj) throws IEMRException;
	
	public String deleteVanSpokeMapping(String requestObj) throws IEMRException;
	
	public String updateVanSpokeMapping(String requestObj) throws IEMRException;
}
