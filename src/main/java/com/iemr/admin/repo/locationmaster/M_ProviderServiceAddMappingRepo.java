package com.iemr.admin.repo.locationmaster;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.admin.data.locationmaster.M_ProviderServiceAddMapping;

@Repository
@RestResource(exported = false)
public interface M_ProviderServiceAddMappingRepo extends CrudRepository<M_ProviderServiceAddMapping, Integer>{

	
	@Query("SELECT u FROM M_ProviderServiceAddMapping u WHERE u.pSAddMapID=:pSAddMapID")
	M_ProviderServiceAddMapping editData(@Param ("pSAddMapID")Integer pSAddMapID);
	
	
	@Query("SELECT u FROM M_ProviderServiceAddMapping u where deleted=0")
	ArrayList<M_ProviderServiceAddMapping> getAlldata();

	@Query("SELECT u FROM M_ProviderServiceAddMapping u where u.providerServiceMapID = :pssmID")
	ArrayList<M_ProviderServiceAddMapping> getlocationByMapid(@Param("pssmID") int pssmID);

	@Query("SELECT u FROM M_ProviderServiceAddMapping u where u.providerServiceMapID = :data AND deleted=0")
	ArrayList<M_ProviderServiceAddMapping> getlocationByMapid1(@Param("data")Integer data);


	

}
