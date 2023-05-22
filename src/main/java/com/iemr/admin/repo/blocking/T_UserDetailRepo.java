package com.iemr.admin.repo.blocking;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.admin.data.blocking.T_Userdetail;


@Repository
@RestResource(exported = false)
public interface T_UserDetailRepo extends CrudRepository<T_Userdetail, Integer> {

}
