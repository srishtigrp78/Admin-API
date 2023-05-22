package com.iemr.admin.repo.blocking;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.admin.data.blocking.M_Serviceprovider_Blocking;


@Repository
@RestResource(exported = false)
public interface MServiceproviderBlockingRepo extends CrudRepository<M_Serviceprovider_Blocking, Integer>{
   
	@Query("SELECT u FROM M_Serviceprovider_Blocking u where u.serviceProviderID = :serviceProviderID AND deleted=0" )
	M_Serviceprovider_Blocking getProviderDetailsByID(@Param("serviceProviderID") Integer serviceProviderID);

}
