package com.iemr.admin.service.parkingPlace;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iemr.admin.controller.locationmaster.LocationMasterController;
import com.iemr.admin.data.locationmaster.DistrictBlock;
import com.iemr.admin.data.parkingPlace.ParkingplaceTalukMapping;
import com.iemr.admin.data.parkingPlace.ParkingplaceTalukMappingTO;
import com.iemr.admin.mapper.parkingplacetalukmapping.ParkingPlaceTalukMappingMapper;
import com.iemr.admin.repo.locationmaster.DistrictBlockRepo;
import com.iemr.admin.repository.parkingPlace.ParkingPlaceTalukMappingRepository;

@Service
public class ParkingPlaceTalukMappingServiceImpl implements ParkingPlaceTalukMappingService {

//	@Autowired
//	private Logger logger = LoggerFactory.getLogger(ParkingPlaceTalukMappingServiceImpl.class);
	
	@Autowired
	private ParkingPlaceTalukMappingRepository parkingPlaceTalukMappingRepository;
	
	@Autowired
	private DistrictBlockRepo districtBlockRepo;

	@Autowired
	private ParkingPlaceTalukMappingMapper parkingPlaceTalukMappingMapper;

	@Override
	public ArrayList<ParkingplaceTalukMapping> saveParkingPlaceTalukMapping(List<ParkingplaceTalukMapping> parkingPlace) {
		
		return (ArrayList<ParkingplaceTalukMapping>) parkingPlaceTalukMappingRepository.save(parkingPlace);
	}
	
	@Override
	public ParkingplaceTalukMapping updateParkingPlaceTalukMapping(ParkingplaceTalukMapping parkingPlace) {
		
		return  (ParkingplaceTalukMapping) parkingPlaceTalukMappingRepository.save(parkingPlace);
	}
	
	@Override
	public ParkingplaceTalukMapping findbyID(Integer id) {
		
		return (ParkingplaceTalukMapping) parkingPlaceTalukMappingRepository.findOne(id);
	}
	
	@Override
	public List<ParkingplaceTalukMappingTO> findbyProviderservicemapid(ParkingplaceTalukMapping parkingPlace) {
		
		return parkingPlaceTalukMappingMapper.getParkingplaceTalukMappingMapList( (List<ParkingplaceTalukMapping>) parkingPlaceTalukMappingRepository.findByParkingPlaceID(parkingPlace.getParkingPlaceID()));
	}
	
	@Override
	public List<ParkingplaceTalukMappingTO> findbyParkingplaceAndDistrictID(ParkingplaceTalukMapping parkingPlace) {
		
		return parkingPlaceTalukMappingMapper.getParkingplaceTalukMappingMapList( (List<ParkingplaceTalukMapping>) parkingPlaceTalukMappingRepository.findByParkingPlaceIDAndDistrictIDOrderByM_DistrictDistrictNameAsc(parkingPlace.getParkingPlaceID(),parkingPlace.getDistrictID()));
	}

	public List<DistrictBlock> getunmappedtaluk(Integer districtID,Integer providerservicemapID) {
		// TODO Auto-generated method stub
		List<Integer> intids=parkingPlaceTalukMappingRepository.finbyDistrictID( districtID,providerservicemapID);
//		logger.info(intids.toString());
		List<DistrictBlock> output=new ArrayList<>();
			if(intids.size()>0){
				output=districtBlockRepo.findunmapped(intids,districtID);
			}else{
				output=districtBlockRepo.findall(districtID);
			}
		return output;
	}
}
