package com.iemr.admin.repo.employeemaster;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.admin.data.employeemaster.M_Role;

@Repository
@RestResource(exported = false)
public interface RoleRepo extends CrudRepository<M_Role, Integer>
{
	@Query("SELECT u FROM M_Role u where deleted=0 ")
	ArrayList<M_Role> getAllRole();

	@Query("SELECT role FROM M_Role role where role.providerServiceMapID = :pssmID")
	ArrayList<M_Role> getAllRoleByMapId(@Param("pssmID") int pssmID);

}
