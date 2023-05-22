package com.iemr.admin.repo.employeemaster;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.admin.data.employeemaster.M_Gender;
import com.iemr.admin.data.employeemaster.M_Title;

@Repository
@RestResource(exported = false)
public interface M_TitleRepo extends CrudRepository<M_Title, Integer>{
	@Query("SELECT u FROM M_Title u where deleted=0")
	ArrayList<M_Title> getAllTitle();


}
