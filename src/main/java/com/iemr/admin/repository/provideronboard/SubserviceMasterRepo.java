package com.iemr.admin.repository.provideronboard;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.admin.data.provideronboard.M_Subservice;


@Repository
@RestResource(exported = false)
public interface SubserviceMasterRepo extends CrudRepository<M_Subservice, Integer> {
	@Query("SELECT u FROM M_Subservice u where u.providerServiceMapID = :providerServiceMapID AND deleted=0")
	ArrayList<M_Subservice> getServiceNameByProviderMapId(@Param ("providerServiceMapID") Integer providerServiceMapID);
    
	
	@Query("SELECT u FROM M_Subservice u where  u.providerServiceMapID = :providerServiceMapID")
	ArrayList<M_Subservice> getsubServiceName(@Param ("providerServiceMapID") Integer providerServiceMapID);
    
	
	
	@Query("SELECT u FROM M_Subservice u where u.subServiceID =:subServiceID")
	M_Subservice getsubServiceNameById(@Param("subServiceID")Integer subServiceID);

}
