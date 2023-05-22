package com.iemr.admin.repo.employeemaster;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.admin.data.employeemaster.M_UserDemographics;

@Repository
@RestResource(exported = false)
public interface M_UserDemographicsRepo extends CrudRepository<M_UserDemographics, Integer>{
	@Query("SELECT u FROM M_UserDemographics u WHERE u.userID=:userID AND deleted=0")
	M_UserDemographics mdedit(@Param ("userID") Integer userID);

	M_UserDemographics findByUserID(Integer userID);

}
