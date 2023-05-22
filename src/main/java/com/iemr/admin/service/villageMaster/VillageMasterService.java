package com.iemr.admin.service.villageMaster;

import java.util.ArrayList;
import java.util.List;

import com.iemr.admin.data.locationmaster.DistrictBranchMapping;
import com.iemr.admin.data.zonemaster.M_Zone;

public interface VillageMasterService {
	
	ArrayList<DistrictBranchMapping> storeVillageDetails(List<DistrictBranchMapping> villageList);
	
	ArrayList<DistrictBranchMapping> getAvailableVillages(Integer blockID);
	
	int updateVillageStatus(DistrictBranchMapping districtBranchMapping);
	
	int updateVillageData(DistrictBranchMapping districtBranchMapping);
	
}
