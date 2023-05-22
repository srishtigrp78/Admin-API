package com.iemr.admin.service.provideronboard;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonObject;
import com.iemr.admin.data.provideronboard.M_Institution;

public interface M_InstitutionInter {

	ArrayList<M_Institution> getInstution(Integer providerServiceMapID, Integer stateID, Integer districtID,
			Integer blockID);

	ArrayList<M_Institution> createInstution(List<M_Institution> createinstute);

	M_Institution editInstution(Integer institutionID);

	M_Institution saveEditData(M_Institution createInstutionData);

	ArrayList<M_Institution> getInstutionByVillage(Integer providerServiceMapID, Integer stateID, Integer districtID,
			Integer blockID, Integer villageID);

	ArrayList<M_Institution> createInstutionByVillage(List<M_Institution> createinstute);	

	String createInstitutionByFile(JsonObject getInstitutionDetails);
	

}
