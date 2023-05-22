package com.iemr.admin.repository.store;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.admin.data.store.M_Facility;

@Repository
@RestResource(exported = false)
public interface MainStoreRepo extends CrudRepository<M_Facility, Integer>{
	
	List<M_Facility> findByProviderServiceMapIDOrderByFacilityName(Integer providerServiceMapID);
    
	@Query("SELECT u FROM M_Facility u WHERE u.providerServiceMapID=:providerServiceMapID AND u.isMainFacility=:isMainFacility AND deleted=0 order by u.facilityName")
	ArrayList<M_Facility> getAllMainFacility(@Param("providerServiceMapID")Integer providerServiceMapID,@Param("isMainFacility") Boolean isMainFacility);
	
	
	@Query("SELECT u FROM M_Facility u WHERE u.providerServiceMapID=:providerServiceMapID AND u.isMainFacility=:isMainFacility AND u.mainFacilityID=:mainFacilityID AND deleted=0 order by u.facilityName")
	ArrayList<M_Facility> getAllMainFacility(@Param("providerServiceMapID")Integer providerServiceMapID,@Param("isMainFacility") Boolean isMainFacility,
			@Param("mainFacilityID") Integer mainFacilityID);

	@Query("SELECT u FROM M_Facility u WHERE u.providerServiceMapID=:providerServiceMapID AND u.mainFacilityID=:mainFacilityID AND deleted=0 order by u.facilityName")
	ArrayList<M_Facility> getChildFacility(@Param("providerServiceMapID")Integer providerServiceMapID,@Param("mainFacilityID") Integer mainFacilityID);
	
	
	ArrayList<M_Facility> findByMainFacilityIDAndDeletedOrderByFacilityName(Integer mainfacID,Boolean deleted);
	
	M_Facility findByFacilityIDAndDeleted(Integer mainfacID,Boolean deleted);

	List<M_Facility> findByFacilityCodeAndProviderServiceMapID(String facilityCode, Integer providerServiceMapID);
	

}
