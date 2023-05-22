package com.iemr.admin.repo.employeemaster;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.admin.data.employeemaster.M_Gender;

@Repository
@RestResource(exported = false)
public interface M_GenderRepo extends CrudRepository<M_Gender, Integer> {
	@Query("SELECT u FROM M_Gender u where deleted=0")
	ArrayList<M_Gender> getAllGender();

}
