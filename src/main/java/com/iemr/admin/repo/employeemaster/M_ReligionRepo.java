package com.iemr.admin.repo.employeemaster;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.admin.data.employeemaster.M_Religion;

@Repository
@RestResource(exported = false)
public interface M_ReligionRepo extends CrudRepository<M_Religion, Integer>{

}
