package com.iemr.admin.repository.uptsu;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.admin.data.uptsu.CDSSMapping;
@Repository
@RestResource(exported = false)
public interface CDSSMappingRepo extends CrudRepository<CDSSMapping, Long>{
	
	CDSSMapping findByPsmIdAndDeleted(Integer psmId, Boolean deleted);
	
	CDSSMapping findByPsmId(Integer psmId);

}
