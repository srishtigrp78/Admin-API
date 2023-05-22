package com.iemr.admin.repo.blocking;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.admin.data.blocking.T_Providerservicemappingdetail;

@Repository
@RestResource(exported = false)
public interface T_ProviderservicemappingdetailRepo extends CrudRepository<T_Providerservicemappingdetail, Integer>{

}
