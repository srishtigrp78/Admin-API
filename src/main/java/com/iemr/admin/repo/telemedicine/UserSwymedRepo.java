package com.iemr.admin.repo.telemedicine;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.admin.data.telemedicine.UserSwymed;

@Repository
@RestResource(exported = false)
public interface UserSwymedRepo extends CrudRepository<UserSwymed, Long> {

	@Query("select new UserSwymed(us,u.UserName,desc1.designationName,u.Deleted,desc1.designationID) from UserSwymed us left join us.user u  left join u.designation desc1 where u.ServiceProviderID=:serviceproviderID ")
	List<UserSwymed> fetchmappedUser(@Param("serviceproviderID")Integer serviceproviderID);

}
