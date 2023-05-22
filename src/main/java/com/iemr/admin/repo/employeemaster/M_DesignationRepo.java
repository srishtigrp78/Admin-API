package com.iemr.admin.repo.employeemaster;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.admin.data.employeemaster.M_Designation;

@Repository
@RestResource(exported = false)
public interface M_DesignationRepo extends CrudRepository<M_Designation, Integer> {
   
	@Query("SELECT u FROM M_Designation u where deleted=0 order by u.designationName")
	ArrayList<M_Designation> getDesinationlist();

}
