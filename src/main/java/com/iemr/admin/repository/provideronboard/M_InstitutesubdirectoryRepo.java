package com.iemr.admin.repository.provideronboard;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.admin.data.provideronboard.M_Institutesubdirectory;

@Repository
@RestResource(exported = false)
public interface M_InstitutesubdirectoryRepo extends CrudRepository<M_Institutesubdirectory, Integer>{
	
	
	
	@Query("SELECT u FROM M_Institutesubdirectory u where u.instituteDirectoryID=:instituteDirectoryID AND u.providerServiceMapId=:providerServiceMapId")
	ArrayList<M_Institutesubdirectory> getInstutesubDirectory(@Param("instituteDirectoryID") Integer instituteDirectoryID,
		@Param("providerServiceMapId") Integer providerServiceMapId);
    
	
	@Query("SELECT u FROM M_Institutesubdirectory u where u.instituteSubDirectoryID=:instituteSubDirectoryID")
	M_Institutesubdirectory editInstutesubDirectory(@Param("instituteSubDirectoryID")Integer instituteSubDirectoryID);
	
	

}
