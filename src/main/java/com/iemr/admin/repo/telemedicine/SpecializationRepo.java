package com.iemr.admin.repo.telemedicine;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.admin.data.telemedicine.Specialization;

@Repository
@RestResource(exported = false)
public interface SpecializationRepo extends CrudRepository<Specialization, Integer> {

	ArrayList<Specialization> findByDeleted(boolean b);
  

	
	

}
