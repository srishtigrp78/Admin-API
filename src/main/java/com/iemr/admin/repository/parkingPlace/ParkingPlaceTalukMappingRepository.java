package com.iemr.admin.repository.parkingPlace;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.admin.data.parkingPlace.ParkingplaceTalukMapping;

@Repository
@RestResource(exported = false)
public interface ParkingPlaceTalukMappingRepository extends CrudRepository<ParkingplaceTalukMapping, Integer> {

	@Query("SELECT u FROM ParkingplaceTalukMapping u left join u.districtBlock left join u.parkingplace where u.providerServiceMapID=:pid ")
	List<ParkingplaceTalukMapping> findByProviderServiceMapID(@Param("pid")Integer id);

	@Query("SELECT u FROM ParkingplaceTalukMapping u left join u.districtBlock left join u.parkingplace where u.parkingPlaceID=:pid ")
	List<ParkingplaceTalukMapping> findByParkingPlaceID(@Param("pid")Integer parkingPlaceID);

	@Query("SELECT u FROM ParkingplaceTalukMapping u left join u.districtBlock left join u.parkingplace where u.parkingPlaceID=:pid and u.districtID=:did order by u.districtBlock.blockName")
	List<ParkingplaceTalukMapping> findByParkingPlaceIDAndDistrictIDOrderByM_DistrictDistrictNameAsc(
			@Param("pid")Integer parkingPlaceID, @Param("did")Integer districtID);

	@Query("SELECT u.districtBlockID FROM ParkingplaceTalukMapping u where  u.districtID=:did and u.providerServiceMapID=:sid and u.deleted=false")
	List<Integer> finbyDistrictID(@Param("did") Integer districtID,@Param("sid") Integer pID);

	
}
