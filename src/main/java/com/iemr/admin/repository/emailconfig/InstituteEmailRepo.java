package com.iemr.admin.repository.emailconfig;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.admin.data.emailconfig.AuthorityEmail;

@Repository
@RestResource(exported = false)
public interface InstituteEmailRepo extends CrudRepository<AuthorityEmail, Integer>
{

}
