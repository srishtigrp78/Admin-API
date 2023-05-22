package com.iemr.admin.repo.locationmaster;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.admin.data.locationmaster.StateServiceMapping1;

@Repository
@RestResource(exported = false)
public interface LocationMasterRepo extends CrudRepository<StateServiceMapping1, Integer>{
	
	@Query("SELECT distinct rp.stateID,"
			  + " sm.stateName as stateName, "
			  + " rp.statusID,"
			  + " rp.providerServiceMapID"
			  + " FROM StateServiceMapping1 rp "
			  + " JOIN rp.stateMaster sm "
			  + " WHERE rp.serviceProviderID =:serviceProviderID AND rp.deleted=0 ORDER BY sm.stateName")
	ArrayList<Object[]> getStateByServiceProviderId(@Param("serviceProviderID") Integer serviceProviderID);
	
	
	@Query("SELECT distinct rp.serviceID, rp.providerServiceMapID,"
			+ " sm.serviceName as serviceName"
			+ " FROM StateServiceMapping1 rp "
			+ " JOIN rp.serviceMaster sm "
			+ " WHERE rp.serviceProviderID =:serviceProviderID AND rp.stateID =:stateID AND rp.deleted=0")

	ArrayList<Object[]> getServiceByServiceProviderIdAndStateId(@Param ("serviceProviderID") Integer serviceProviderID, @Param ("stateID") Integer stateID);

	@Query("SELECT u.providerServiceMapID FROM StateServiceMapping1 u WHERE u.serviceProviderID=:serviceProviderID AND u.stateID=:stateID AND u.serviceID=:serviceID AND deleted=0 ")
	StateServiceMapping1 getProviderServiceMapID(@Param("serviceProviderID") Integer serviceProviderID, @Param("stateID") Integer stateID, @Param("serviceID") Integer serviceID);


	
	@Query("SELECT u FROM StateServiceMapping1 u WHERE u.serviceProviderID=:serviceProviderID AND u.stateID=:stateID AND u.serviceID=:serviceID AND deleted=0 ")
	   List getAllByMapId2(@Param("serviceProviderID") Integer serviceProviderID, @Param("stateID") Integer stateID, @Param("serviceID") Integer serviceID);

    
	
	@Query("SELECT u FROM StateServiceMapping1 u WHERE u.serviceProviderID=:serviceProviderID AND u.serviceID=:serviceID AND deleted=0 ")
	ArrayList<StateServiceMapping1> getLocationByServiceID(@Param("serviceProviderID")Integer serviceProviderID,@Param("serviceID") Integer serviceID);

     
	@Query("SELECT u FROM StateServiceMapping1 u WHERE u.serviceProviderID=:serviceProviderID AND u.stateID=:stateID AND deleted=0")
	ArrayList<StateServiceMapping1> getLocationByStateID(@Param("serviceProviderID")Integer serviceProviderID,@Param("stateID")Integer stateID);

	@Query("SELECT distinct u.stateID, sm.stateName as stateName, u.providerServiceMapID  "
			+ "FROM StateServiceMapping1 u "
			+ " JOIN u.stateMaster sm "
			+ "WHERE u.serviceID=:serviceID and u.serviceProviderID =:serviceProviderID  ")
	ArrayList<Object[]> getStatesByServiceId(@Param("serviceID") Integer serviceID,@Param ("serviceProviderID") Integer serviceProviderID);
	
	
	@Query("SELECT u FROM StateServiceMapping1 u WHERE u.serviceProviderID=:serviceProviderID AND u.stateID=null AND u.serviceID=:serviceID AND deleted=0 ")
	   List getAllByMapId3(@Param("serviceProviderID") Integer serviceProviderID, @Param("serviceID") Integer serviceID);

	
}
