package com.iemr.admin.repository.provideronboard;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.admin.data.provideronboard.M_Institutedirectory;

@Repository
@RestResource(exported = false)
public interface InstuteDirectoryRepo extends CrudRepository<M_Institutedirectory, Integer> {
    
	
	@Query("SELECT u FROM M_Institutedirectory u WHERE u.providerServiceMapId=:providerServiceMapId ")
	ArrayList<M_Institutedirectory> getInstuteDirectory(@Param("providerServiceMapId")Integer providerServiceMapId);
     
	
	
	@Query("SELECT u FROM M_Institutedirectory u WHERE u.instituteDirectoryID=:instituteDirectoryID ")
	M_Institutedirectory editInstuteDirectory(@Param("instituteDirectoryID")Integer instituteDirectoryID);
	
	
}
