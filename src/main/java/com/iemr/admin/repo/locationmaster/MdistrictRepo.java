package com.iemr.admin.repo.locationmaster;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.admin.data.locationmaster.M_District;

@Repository
@RestResource(exported = false)
public interface MdistrictRepo  extends CrudRepository<M_District, Integer>{
	@Query("SELECT u FROM M_District u WHERE u.stateID=:stateID AND deleted=0")
	ArrayList<M_District> getAllDistrictByStateId(@Param("stateID") Integer stateID);

}
