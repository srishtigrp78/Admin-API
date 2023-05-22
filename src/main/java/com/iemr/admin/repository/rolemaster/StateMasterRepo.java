package com.iemr.admin.repository.rolemaster;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.admin.data.rolemaster.StateMasterForRole;

@Repository
@RestResource(exported = false)
public interface StateMasterRepo extends CrudRepository<StateMasterForRole, Integer>{
    
	
	 @Query(" SELECT u FROM StateMasterForRole u ")
	 ArrayList<StateMasterForRole> getAllState();

}
