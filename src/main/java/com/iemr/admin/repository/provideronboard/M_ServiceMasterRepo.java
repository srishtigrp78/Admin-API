package com.iemr.admin.repository.provideronboard;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.admin.data.provideronboard.M_ServiceMaster;

@Repository
@RestResource(exported = false)
public interface M_ServiceMasterRepo extends CrudRepository<M_ServiceMaster, Integer> {
	@Query("SELECT u FROM M_ServiceMaster u where deleted=0") 
	List<M_ServiceMaster> getAllServiceline();

}
