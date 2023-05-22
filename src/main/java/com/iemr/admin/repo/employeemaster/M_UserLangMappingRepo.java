package com.iemr.admin.repo.employeemaster;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.admin.data.employeemaster.M_UserLangMapping;


@Repository
@RestResource(exported = false)
public interface M_UserLangMappingRepo extends CrudRepository<M_UserLangMapping, Integer>{
	@Query("SELECT u FROM M_UserLangMapping u WHERE u.userID=:userID AND u.languageID=:languageID AND deleted=0")
	M_UserLangMapping ulangmapedit(@Param ("userID") Integer userID,@Param ("languageID") Integer languageID);

	
	
	
	
	@Query("SELECT distinct ulm.userLangID,ulm.userID,ulm.languageID,ulm.weightage,"
			+ " ml.languageName as languageName,"
			+ " concat(COALESCE(us.firstName, ''), ' ', COALESCE(us.middleName, ''), ' ', COALESCE(us.lastName, '')) as userName,"
			+ " ulm.canRead,"
			+ " ulm.canWrite,"
			+ " ulm.canSpeak,"
			+ " ulm.createdBy,"
			+ " ulm.deleted,"
			+ " ulm.weightage_Read,"
			+ " ulm.weightage_Write,"
			+ " ulm.weightage_Speak,"
			+ " us.deleted as userDeleted "
			+ " FROM M_UserLangMapping ulm "
			+ " JOIN ulm.m_user us"
     		+ " JOIN ulm.m_Language1 ml"
			+ " WHERE ulm.languageID=ml.languageID And ulm.userID=us.userID And ulm.serviceProviderID=:serviceProviderID"
			)
	ArrayList<Object[]> getMappedLanguge(@Param("serviceProviderID") Integer serviceProviderID);




	@Query("SELECT u FROM M_UserLangMapping u WHERE u.userID=:userID")
	ArrayList<M_UserLangMapping> getmappedlanguageData(@Param("userID") Integer userID);

}
