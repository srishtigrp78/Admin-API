package com.iemr.admin.repo.blocking;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.admin.data.blocking.M_Status1;

@Repository
@RestResource(exported = false)
public interface MStatusRepo extends CrudRepository<M_Status1, Integer> {
	@Query("SELECT u FROM M_Status1 u where deleted=0")
	ArrayList<M_Status1> getStatusData();

}
