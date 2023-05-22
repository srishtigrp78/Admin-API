package com.iemr.admin.repo.employeemaster;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.admin.data.employeemaster.M_ProviderServiceMap1;


@Repository
@RestResource(exported = false)
public interface M_ProviderServiceMap1Repo  extends CrudRepository<M_ProviderServiceMap1, Integer>{

	
	
	@Query("SELECT u FROM M_ProviderServiceMap1 u WHERE u.serviceProviderID=:serviceProviderID AND u.stateID=:stateID AND u.serviceID=:serviceID AND deleted=0")
	   List getAllByMapId2(@Param("serviceProviderID") Integer serviceProviderID, @Param("stateID") Integer stateID, @Param("serviceID") Integer serviceID);
	//ArrayList<M_ProviderServiceMap1> getAllByMapId2(Integer serviceProviderID, Integer stateID, Integer serviceID);

	
	
}
