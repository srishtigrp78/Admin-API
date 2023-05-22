package com.iemr.admin.repository.store;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.admin.data.store.V_FetchFacility;

@Repository
@RestResource(exported = false)
public interface V_FetchFacilityRepo extends CrudRepository<V_FetchFacility, Integer>{
	

	List<V_FetchFacility> findByProviderServiceMapID(Integer providerServiceMapID);

}
