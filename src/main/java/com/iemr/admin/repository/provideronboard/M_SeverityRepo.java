package com.iemr.admin.repository.provideronboard;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.admin.data.provideronboard.M_Severity;

@Repository
@RestResource(exported = false)
public interface M_SeverityRepo  extends CrudRepository<M_Severity, Integer>{
   
	
	@Query("SELECT u FROM M_Severity u where u.providerServiceMapID = :providerServiceMapID")
	ArrayList<M_Severity> getAllServerity(@Param("providerServiceMapID")Integer providerServiceMapID);
    
	
	@Query("SELECT u FROM M_Severity u where u.severityID = :severityID")
	M_Severity editServerity(@Param("severityID")Integer severityID);

}
