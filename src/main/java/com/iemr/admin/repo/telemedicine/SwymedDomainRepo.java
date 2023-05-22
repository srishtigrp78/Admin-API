package com.iemr.admin.repo.telemedicine;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.admin.data.telemedicine.SwymedDomain;

@Repository
@RestResource(exported = false)
public interface SwymedDomainRepo extends CrudRepository<SwymedDomain, Integer> {

	
  

	
	

}
