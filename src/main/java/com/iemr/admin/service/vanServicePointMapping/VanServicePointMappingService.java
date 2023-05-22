package com.iemr.admin.service.vanServicePointMapping;

import java.util.ArrayList;
import java.util.List;

import com.iemr.admin.data.vanMaster.M_Van;
import com.iemr.admin.data.vanServicePointMapping.M_VanServicePointMap;

public interface VanServicePointMappingService {
		
	ArrayList<M_VanServicePointMap> saveVanServicePointMappings(List<M_VanServicePointMap> vanServicePointMappings);
	
	
	int updateVanServicePointMappingStatus(M_VanServicePointMap vanMaster);
	
	M_VanServicePointMap getVanServicePointMappingByID(Integer vanServicePointMapID);

//	ArrayList<M_VanServicePointMap> getAvailableVanServicePointMappings(Integer districtID, Integer parkingPlaceID,
//			Integer vanID, Integer providerServiceMapID);

	ArrayList<M_VanServicePointMap> getAvailableVanServicePointMappings( Integer parkingPlaceID,
			Integer vanID, Integer providerServiceMapID);
}
