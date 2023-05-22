package com.iemr.admin.service.zonemaster;

import java.util.ArrayList;
import java.util.List;

import com.iemr.admin.data.provideronboard.M_104drugmaster;
import com.iemr.admin.data.zonemaster.M_Zone;
import com.iemr.admin.data.zonemaster.M_ZoneDistrictMap;

public interface ZoneMasterService {

	
	ArrayList<M_Zone> createZone(List<M_Zone> zoneList);

	ArrayList<M_Zone> getAvailableZones(Integer ServiceProviderID);
	
	ArrayList<M_ZoneDistrictMap> createZoneDistrictMapping(List<M_ZoneDistrictMap> zoneList);
	
	ArrayList<M_ZoneDistrictMap> getAvailableZoneDistrictMappings(Integer serviceProviderID);
	
	int updateZoneStatus(M_Zone m_zone);
	
	int updateZoneDistrictMappingStatus(M_ZoneDistrictMap m_zoneDistrictMap);
	
	M_Zone updateZoneData(M_Zone m_zone);
	
	M_Zone getzoneByID(Integer zoneID);
}
