package com.iemr.admin.repository.rolemaster;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.admin.data.rolemaster.M_Role;
import com.iemr.admin.data.rolemaster.StateServiceMapping;

@Repository
@RestResource(exported = false)
public interface RoleMasterRepo extends CrudRepository<StateServiceMapping, Integer> {
		@Query("SELECT distinct rp.stateID,"
			  + " sm.stateName, "
			  //+ " sm.stateName as createdBy "
			  //+ " sm.stateName as createdBy "
			  + "rp.statusID"
			  + " FROM StateServiceMapping rp "
			  + " JOIN rp.stateMaster sm "
			  + " WHERE rp.serviceProviderID =:serviceProviderID AND rp.deleted=0 ORDER BY sm.stateName ")
	ArrayList<Object[]> getStateByServiceProviderId(@Param ("serviceProviderID") Integer serviceProviderID);
		
	
	@Query("SELECT distinct rp.serviceID, rp.providerServiceMapID,"
		+ " sm.serviceName as serviceName,"
		 + "rp.statusID"
		+ " FROM StateServiceMapping rp "
		+ " JOIN rp.serviceMaster sm "
		+ " WHERE rp.serviceProviderID =:serviceProviderID AND rp.stateID =:stateID  AND rp.deleted=0")
		ArrayList<Object[]> getServiceByServiceProviderIdAndStateId(@Param ("serviceProviderID") Integer serviceProviderID, @Param ("stateID") Integer stateID);

		@Query("SELECT u FROM StateServiceMapping u WHERE u.serviceProviderID=:serviceProviderID AND u.stateID=:stateID AND u.serviceID=:serviceID AND u.deleted=0")
	   List getAllByMapId(@Param("serviceProviderID") Integer serviceProviderID, @Param("stateID") Integer stateID, @Param("serviceID") Integer serviceID);
      
		/*String query="SELECT u FROM StateServiceMapping u "
				@Query("query", nativeQuery = true);
		   List getAllByMapId(@Param("testquery") String testquery);*/
		
		@Query("SELECT u FROM StateServiceMapping u WHERE u.serviceProviderID=:serviceProviderID AND u.stateID=null AND u.serviceID=:serviceID AND u.deleted=0")
		   List getAllByMapId(@Param("serviceProviderID") Integer serviceProviderID, @Param("serviceID") Integer serviceID);
}
