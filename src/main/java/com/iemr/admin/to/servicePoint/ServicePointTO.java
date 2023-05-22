package com.iemr.admin.to.servicePoint;

import java.util.List;

import javax.persistence.Transient;

import com.iemr.admin.data.servicePoint.M_Servicepoint;
import com.iemr.admin.data.servicePoint.M_Servicepointvillagemap;

public class ServicePointTO {
	@Transient
	private List<M_Servicepoint> servicePoints;
	
	@Transient
	private List<M_Servicepointvillagemap> servicePointVillageMaps;
	
	public List<M_Servicepointvillagemap> getServicePointVillageMaps() {
		return servicePointVillageMaps;
	}

	public void setServicePointVillageMaps(List<M_Servicepointvillagemap> servicePointVillageMaps) {
		this.servicePointVillageMaps = servicePointVillageMaps;
	}

	public List<M_Servicepoint> getServicePoints() {
		return servicePoints;
	}

	public void setServicePoints(List<M_Servicepoint> servicePoints) {
		this.servicePoints = servicePoints;
	}
	
}
