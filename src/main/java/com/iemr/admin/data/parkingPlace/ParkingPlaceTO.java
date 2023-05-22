package com.iemr.admin.data.parkingPlace;

import java.util.List;

import javax.persistence.Transient;


public class ParkingPlaceTO {
	@Transient
	private List<M_Parkingplace> parkingPlaces;

	public List<M_Parkingplace> getParkingPlaces() {
		return parkingPlaces;
	}

	public void setParkingPlaces(List<M_Parkingplace> parkingPlaces) {
		this.parkingPlaces = parkingPlaces;
	}

}
