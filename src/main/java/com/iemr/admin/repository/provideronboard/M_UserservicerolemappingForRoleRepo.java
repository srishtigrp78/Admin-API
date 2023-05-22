package com.iemr.admin.repository.provideronboard;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.admin.data.provideronboard.M_UserservicerolemappingForRole;

@Repository
@RestResource(exported = false)
public interface M_UserservicerolemappingForRoleRepo extends CrudRepository<M_UserservicerolemappingForRole, Integer>{

}
