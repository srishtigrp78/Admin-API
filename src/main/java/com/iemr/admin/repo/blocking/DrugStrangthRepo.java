package com.iemr.admin.repo.blocking;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.admin.data.drugstrangth.M_104DrugStrength;

@Repository
@RestResource(exported = false)
public interface DrugStrangthRepo extends CrudRepository<M_104DrugStrength, Integer>{

}
