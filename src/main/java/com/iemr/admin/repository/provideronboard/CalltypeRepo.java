package com.iemr.admin.repository.provideronboard;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.admin.data.provideronboard.M_Calltype;



@Repository
@RestResource(exported = false)
public interface CalltypeRepo extends CrudRepository<M_Calltype, Integer>{

	@Query("SELECT u FROM M_Calltype u where deleted=0")
	ArrayList<M_Calltype> getCalltypeData();
   
	
	@Query("SELECT u FROM M_Calltype u where u.callTypeID =:callTypeID")
	M_Calltype updateCallType(@Param("callTypeID") Integer callTypeID);

	
	   @Query("SELECT u FROM M_Calltype u where u.providerServiceMapID=:providerServiceMapID")
	ArrayList<M_Calltype> getCalltypeData(@Param("providerServiceMapID")Integer providerServiceMapID);

}
