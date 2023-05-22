package com.iemr.admin.repository.rolemaster;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.admin.data.rolemaster.M_Screen;

@Repository
@RestResource(exported = false)
public interface M_ScreenRepo extends CrudRepository<M_Screen, Integer>{
	@Query("SELECT u FROM M_Screen u where u.serviceID=:serviceID")
	ArrayList<M_Screen> getAllFeature(@Param("serviceID") Integer serviceID);



}
