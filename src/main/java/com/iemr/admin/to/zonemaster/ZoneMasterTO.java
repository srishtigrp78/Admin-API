package com.iemr.admin.to.zonemaster;

import java.util.List;

import javax.persistence.Transient;

import com.iemr.admin.data.zonemaster.M_Zone;
import com.iemr.admin.data.zonemaster.M_ZoneDistrictMap;

public class ZoneMasterTO {

	@Transient
	private List<M_Zone> zones;
	
	@Transient
	private List<M_ZoneDistrictMap> zoneDistrictMappings;

	public List<M_Zone> getZones() {
		return zones;
	}

	public void setZones(List<M_Zone> zones) {
		this.zones = zones;
	}

	public List<M_ZoneDistrictMap> getZoneDistrictMappings() {
		return zoneDistrictMappings;
	}

	public void setZoneDistrictMappings(List<M_ZoneDistrictMap> zoneDistrictMappings) {
		this.zoneDistrictMappings = zoneDistrictMappings;
	}
	
	
	
}
