package com.iemr.admin.repo.blocking;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.admin.data.blocking.M_Providerservicemapping_Blocking;
import com.iemr.admin.data.blocking.V_Showproviderservicemapping;

@Repository
@RestResource(exported = false)
public interface V_ShowproviderservicemappingRepo extends CrudRepository<V_Showproviderservicemapping, Integer>{

	
	
	@Query("SELECT u FROM V_Showproviderservicemapping u where u.serviceProviderID = :serviceProviderID AND u.stateID=:stateID AND u.serviceID=:serviceID AND deleted=0")
	ArrayList<V_Showproviderservicemapping> getProviderServiceMappingDetails1(@Param("serviceProviderID")Integer serviceProviderID,@Param("stateID") Integer stateID,
			@Param("serviceID")Integer serviceID);
    
	
	@Query("SELECT u FROM V_Showproviderservicemapping u where u.serviceProviderID = :serviceProviderID AND u.stateID=:stateID AND deleted=0")
	ArrayList<V_Showproviderservicemapping> getProviderStateMappingDetails(@Param("serviceProviderID")Integer serviceProviderID,@Param("stateID") Integer stateID);
	
    
	
	@Query("SELECT u FROM V_Showproviderservicemapping u where u.serviceProviderID = :serviceProviderID AND deleted=0 "
			+ " GROUP BY u.stateID "
			+ " ORDER BY u.serviceName")
	ArrayList<V_Showproviderservicemapping> getProviderStatus(@Param("serviceProviderID")Integer serviceProviderID);
	
	
	@Query("SELECT u FROM V_Showproviderservicemapping u where u.serviceProviderID = :serviceProviderID AND deleted=0 "
			+ " ORDER BY u.serviceName")
	ArrayList<V_Showproviderservicemapping> getProviderStatus1(@Param("serviceProviderID")Integer serviceProviderID);
   
	
	@Query("SELECT u FROM V_Showproviderservicemapping u where u.serviceProviderID = :serviceProviderID AND u.serviceID=:serviceID AND deleted=0")
	ArrayList<V_Showproviderservicemapping> getProviderStatusByProviderAndServiceId(@Param("serviceProviderID")Integer serviceProviderID,
			@Param("serviceID")Integer serviceID);


	List<V_Showproviderservicemapping> findByProviderServiceMapIDIn(ArrayList<Integer> ids);
	
}
