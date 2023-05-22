package com.iemr.admin.to.vanMaster;

import java.util.List;

import javax.persistence.Transient;

import com.iemr.admin.data.servicePoint.M_Servicepoint;
import com.iemr.admin.data.vanMaster.M_Van;
import com.iemr.admin.data.vanServicePointMapping.M_VanServicePointMap;
import com.iemr.admin.data.vanType.M_VanType;

public class VanMasterTO {

	@Transient
	private List<M_Van> vanMaster;
	
	@Transient
	private List<M_VanType> vanTypeMaster;
	
	@Transient
	private  List<M_VanServicePointMap> vanServicePointMappings;

	public List<M_VanServicePointMap> getVanServicePointMappings() {
		return vanServicePointMappings;
	}

	public void setVanServicePointMappings(List<M_VanServicePointMap> vanServicePointMappings) {
		this.vanServicePointMappings = vanServicePointMappings;
	}

	public List<M_VanType> getVanTypeMaster() {
		return vanTypeMaster;
	}

	public void setVanTypeMaster(List<M_VanType> vanTypeMaster) {
		this.vanTypeMaster = vanTypeMaster;
	}

	public List<M_Van> getVanMaster() {
		return vanMaster;
	}

	public void setVanMaster(List<M_Van> vanMaster) {
		this.vanMaster = vanMaster;
	}
}
