package com.iemr.admin.repository.user;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.admin.data.user.M_UserServiceRoleMapping;

@Repository
@RestResource(exported = false)
public interface M_UserMappingRepo extends CrudRepository<M_UserServiceRoleMapping, Integer> {
	@Query("SELECT u FROM M_User u WHERE LOWER(u.userID) = LOWER(:userID) AND deleted=0")
	public M_UserServiceRoleMapping findByID(long userID);

}
