package com.iemr.admin.repo.blocking;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.admin.data.blocking.UserForBlocking;

@Repository
@RestResource(exported = false)
public interface UserBlockingRepo extends CrudRepository<UserForBlocking, Integer>{
	@Query("SELECT u FROM UserForBlocking u where u.userID = :userID AND deleted=0")
	UserForBlocking getUserDetailByUserId(@Param("userID")Integer userID);

	
	
	
	
	@Transactional
	@Modifying
	@Query(" UPDATE  UserForBlocking u SET u.statusID=:statusID where u.userID = :userID")
	void blockUser(@Param("userID")  Integer userID,@Param("statusID") Integer statusID);

}
