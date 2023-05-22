package com.iemr.admin.service.snomedMapping;



import org.springframework.stereotype.Service;

import com.google.gson.JsonObject;


@Service
public interface SnomedService {

	String editSnomedMappingData(JsonObject requestOBJ,String obj);

	 String saveSnomedMappingData(JsonObject requestOBJ,String reObj);
	 String fetchSnomedMaster(JsonObject requestOBJ);
     String updateStatus(String obj);

}
