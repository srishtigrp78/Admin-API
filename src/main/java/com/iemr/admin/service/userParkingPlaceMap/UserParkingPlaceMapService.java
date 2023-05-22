package com.iemr.admin.service.userParkingPlaceMap;

import java.util.ArrayList;
import java.util.List;

import com.iemr.admin.data.userParkingPlaceMap.M_UserParkingPlaceMap;

public interface UserParkingPlaceMapService {
	
	ArrayList<M_UserParkingPlaceMap> saveUserParkingPlaceDetails(List<M_UserParkingPlaceMap> userParkingPlaceMaster) ;

	ArrayList<M_UserParkingPlaceMap> getUserParkingPlaceMappings( Integer providerServiceMapID, Integer stateID, Integer districtID, 
			Integer parkingPlaceID, Integer designationID);
	
	int updateUserParkingPlaceMapStatus(M_UserParkingPlaceMap userParkingPlaceMaster);
	
	M_UserParkingPlaceMap getUserParkingPlaceMapByID(Integer userParkingPlaceMapID);
	
}
