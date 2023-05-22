package com.iemr.admin.service.provideronboard;

import java.util.ArrayList;
import java.util.List;

import com.iemr.admin.data.provideronboard.M_104druggroup;
import com.iemr.admin.data.provideronboard.M_104drugmapping;
import com.iemr.admin.data.provideronboard.M_104drugmaster;



public interface DrugMasterInter {

	Integer getDrugGrupId(M_104druggroup druggroup);
	
	ArrayList<M_104druggroup> saveDrugGroup(List<M_104druggroup> resList);
	
	ArrayList<M_104drugmaster> saveDrugData(List<M_104drugmaster> resList);

	ArrayList<M_104drugmaster> getAllDrugData(Integer drugID, Short serviceProviderID, Boolean deleted);

	ArrayList<M_104druggroup> getAllDrugGroups(Integer drugGroupID, Short serviceProviderID, Boolean deleted);
	
	ArrayList<M_104drugmapping> getAllDrugGroupMappings(Integer drugMapID, Integer serviceProviderID, Integer serviceID);

	M_104drugmaster getDrugDataById(Integer drugID);

	M_104drugmaster saveUpdatedData(M_104drugmaster drugMasterdata);
	
	ArrayList<M_104drugmapping> mapDrugWithGroup(List<M_104drugmapping> resList);
	
	int updateDrugGroupStatus(M_104druggroup drugGroupdata);
	
	int updateDrugStatus(M_104drugmaster drugMasterdata);
	
	int updateDrugMappingStatus(M_104drugmapping drugMappingdata);
	
	M_104druggroup saveUpdatedDrugGroup(M_104druggroup drugGroupdata);
	
	M_104drugmapping saveUpdatedDrugMapping(M_104drugmapping drugGroupdata);
	
	M_104druggroup getDrugGroupById(Integer drugGroupID);
	
	M_104drugmapping getDrugMappingsById(Integer drugMapID);
	

}
