package com.iemr.admin.service.parkingPlace;

import java.util.ArrayList;
import java.util.List;


import com.iemr.admin.data.parkingPlace.M_Parkingplace;

public interface ParkingPlaceService {
	
	ArrayList<M_Parkingplace> saveParkingPlace(List<M_Parkingplace> parkingPlaces);

	ArrayList<M_Parkingplace> getAvailableParkingPlaces(Integer stateID, Integer districtID, Integer serviceProviderID);
	
	int updateParkingPlaceStatus(M_Parkingplace m_parkingplace);

	M_Parkingplace getParkingPlaceByID(Integer parkingPlaceID);

	M_Parkingplace updateParkingPlaceData(M_Parkingplace m_parkingplace);
}
