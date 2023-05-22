package com.iemr.admin.repository.facilitytype;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.admin.data.facilitytype.M_facilitytype;

@Repository
@RestResource(exported = false)
public interface M_facilitytypeRepo extends CrudRepository<M_facilitytype, Integer>{

	
	
	@Query("SELECT u FROM M_facilitytype u WHERE u.providerServiceMapID=:providerServiceMapID order by u.facilityTypeName")
	ArrayList<M_facilitytype> getAllFicilityData(@Param("providerServiceMapID") Integer providerServiceMapID);

	List<M_facilitytype> findByFacilityTypeCodeAndProviderServiceMapID(String facilityTypeCode,
			Integer providerServiceMapID);

}
