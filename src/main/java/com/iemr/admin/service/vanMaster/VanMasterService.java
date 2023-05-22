package com.iemr.admin.service.vanMaster;

import java.util.ArrayList;
import java.util.List;

import com.iemr.admin.data.parkingPlace.M_Parkingplace;
import com.iemr.admin.data.vanMaster.M_Van;
import com.iemr.admin.data.vanType.M_VanType;

public interface VanMasterService {
	
	ArrayList<M_Van> saveVanDetails(List<M_Van> vanMaster);

	//ArrayList<M_Van> getAvailableVans(Integer stateID, Integer districtID, Integer parkingPlaceID,Integer vanTypeID,Integer serviceProviderID);
	
	int updateVanStatus(M_Van vanMaster);
	
	ArrayList<M_VanType> saveVanTypeDetails(List<M_VanType> vanTypeMaster);
	
	int updateVanTypeStatus(M_VanType vanType);
	
	ArrayList<M_VanType> getVanTypes();
	
	M_Van getVanByID(Integer vanID);
	
	M_Van updateVanData(M_Van van);

//	ArrayList<M_Van> getAvailableVans(Integer districtID, Integer parkingPlaceID, Integer vanTypeID,
//			Integer providerServiceMapID);

	ArrayList<M_Van> getAvailableVans( Integer parkingPlaceID,Integer vanTypeID, Integer providerServiceMapID);

//	ArrayList<M_Van> getNonMappedAvailablevans(Integer parkingPlaceID, Integer vanTypeID, Integer providerServiceMapID);
	
}
