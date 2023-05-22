package com.iemr.admin.repo.employeemaster;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.admin.data.employeemaster.M_Userqualification;

@Repository
@RestResource(exported = false)
public interface M_QualificationRepo extends CrudRepository<M_Userqualification, Integer>{
	@Query("SELECT u FROM M_Userqualification u where deleted=0 order by u.name ")
	ArrayList<M_Userqualification> getAllQualification();

}
