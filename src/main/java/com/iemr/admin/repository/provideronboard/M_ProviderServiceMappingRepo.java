package com.iemr.admin.repository.provideronboard;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.admin.data.provideronboard.M_ProviderServiceMapping;

@Repository
@RestResource(exported = false)
public interface M_ProviderServiceMappingRepo extends CrudRepository<M_ProviderServiceMapping, Integer> {
	@Query("SELECT u FROM M_ProviderServiceMapping u where u.providerServiceMapID = :providerServiceMapID AND deleted=0")
	M_ProviderServiceMapping getPSMID(@Param ("providerServiceMapID") Integer providerServiceMapID);
	
	@Query("SELECT u FROM M_ProviderServiceMapping u where u.serviceProviderID = :serviceProviderID AND deleted=0")
	M_ProviderServiceMapping getPSMapIDByServiceProviderID(@Param ("serviceProviderID") Integer serviceProviderID);

}
