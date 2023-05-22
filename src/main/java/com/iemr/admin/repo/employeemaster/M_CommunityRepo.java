package com.iemr.admin.repo.employeemaster;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.admin.data.employeemaster.M_Community;

@Repository
@RestResource(exported = false)
public interface M_CommunityRepo extends CrudRepository<M_Community, Integer>{

}
