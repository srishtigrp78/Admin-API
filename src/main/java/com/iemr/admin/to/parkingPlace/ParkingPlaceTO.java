package com.iemr.admin.to.parkingPlace;

import java.util.List;

import javax.persistence.Transient;

import com.iemr.admin.data.parkingPlace.M_Parkingplace;
import com.iemr.admin.data.userParkingPlaceMap.M_UserParkingPlaceMap;


public class ParkingPlaceTO {
	@Transient
	private List<M_Parkingplace> parkingPlaces;
	
	@Transient
	private List<M_UserParkingPlaceMap>userParkingPlaceMaps;

	public List<M_UserParkingPlaceMap> getUserParkingPlaceMaps() {
		return userParkingPlaceMaps;
	}

	public void setUserParkingPlaceMaps(List<M_UserParkingPlaceMap> userParkingPlaceMaps) {
		this.userParkingPlaceMaps = userParkingPlaceMaps;
	}

	public List<M_Parkingplace> getParkingPlaces() {
		return parkingPlaces;
	}

	public void setParkingPlaces(List<M_Parkingplace> parkingPlaces) {
		this.parkingPlaces = parkingPlaces;
	}

}
