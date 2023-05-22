package com.iemr.admin.service.parkingPlace;

import java.util.ArrayList;
import java.util.List;


import com.iemr.admin.data.parkingPlace.M_Parkingplace;
import com.iemr.admin.data.parkingPlace.ParkingplaceTalukMapping;
import com.iemr.admin.data.parkingPlace.ParkingplaceTalukMappingTO;

public interface ParkingPlaceTalukMappingService {
	
	ArrayList<ParkingplaceTalukMapping> saveParkingPlaceTalukMapping(List<ParkingplaceTalukMapping> parkingPlace);

	ParkingplaceTalukMapping updateParkingPlaceTalukMapping(ParkingplaceTalukMapping parkingPlace);

	ParkingplaceTalukMapping findbyID(Integer id);

	List<ParkingplaceTalukMappingTO> findbyProviderservicemapid(ParkingplaceTalukMapping id);

	List<ParkingplaceTalukMappingTO> findbyParkingplaceAndDistrictID(ParkingplaceTalukMapping parkingPlace);


}
