package com.iemr.admin.repository.user;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.admin.data.user.M_User;

@Repository
@RestResource(exported = false)
public interface IemrUserRepositoryImplCustom extends CrudRepository<M_User, Long> {

}
