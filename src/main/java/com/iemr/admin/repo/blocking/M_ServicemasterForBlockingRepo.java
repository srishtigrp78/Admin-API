package com.iemr.admin.repo.blocking;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.admin.data.blocking.M_ServicemasterForBlocking;
import com.iemr.admin.data.rolemaster.StateMasterForRole;

@Repository
@RestResource(exported = false)
public interface M_ServicemasterForBlockingRepo extends CrudRepository<M_ServicemasterForBlocking, Integer>{

	@Query(" SELECT u FROM M_ServicemasterForBlocking u ")
	 ArrayList<StateMasterForRole> getAllState();
}
