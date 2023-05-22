package com.iemr.admin.repository.provideronboard;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.admin.data.provideronboard.M_Subservice;
import com.iemr.admin.data.provideronboard.M_SubservicemasterPA;

@Repository
@RestResource(exported = false)
public interface M_SubservicemasterPArepo  extends CrudRepository<M_SubservicemasterPA, Integer>{
   
	
	@Query("SELECT u FROM M_SubservicemasterPA u where u.serviceID = :serviceID AND deleted=0")
	//ArrayList<M_Subservice> getServiceNameByProviderMapId(@Param ("providerServiceMapID") Integer providerServiceMapID);
	ArrayList<M_SubservicemasterPA> getServiceNameByServiceID(@Param ("serviceID") Integer serviceID);

}
