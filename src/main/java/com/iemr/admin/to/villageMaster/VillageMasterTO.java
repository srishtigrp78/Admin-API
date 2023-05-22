package com.iemr.admin.to.villageMaster;

import java.util.List;

import javax.persistence.Transient;

import com.iemr.admin.data.locationmaster.DistrictBranchMapping;
import com.iemr.admin.data.vanMaster.M_Van;

public class VillageMasterTO {
	
	@Transient
	private List<DistrictBranchMapping> districtBranchMapping;

	public List<DistrictBranchMapping> getDistrictBranchMapping() {
		return districtBranchMapping;
	}

	public void setDistrictBranchMapping(List<DistrictBranchMapping> districtBranchMapping) {
		this.districtBranchMapping = districtBranchMapping;
	}
	
}
