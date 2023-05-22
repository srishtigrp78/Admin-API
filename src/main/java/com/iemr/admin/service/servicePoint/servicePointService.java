package com.iemr.admin.service.servicePoint;

import java.util.ArrayList;
import java.util.List;

import com.iemr.admin.data.servicePoint.M_Servicepoint;
import com.iemr.admin.data.servicePoint.M_Servicepointvillagemap;

public interface servicePointService {
	ArrayList<M_Servicepoint> saveServicePoint(List<M_Servicepoint> ServicePoints);

	ArrayList<M_Servicepoint> getAvailableServicePoints(Integer stateID, Integer districtID, Integer parkingPlaceID, Integer serviceProviderID);
	
	int updateServicePointStatus(M_Servicepoint m_ServicePoint);
	
	
	ArrayList<M_Servicepointvillagemap> saveServicePointVillageMap(List<M_Servicepointvillagemap> Servicepointvillagemaps);

	ArrayList<M_Servicepointvillagemap> getAvailableServicePointVillageMaps(Integer stateID, Integer districtID, 
			Integer parkingPlaceID, Integer servicePointID,  Integer serviceProviderID);
	
	int updateServicePointVillageMapStatus(M_Servicepointvillagemap m_ServicePoint);
}
