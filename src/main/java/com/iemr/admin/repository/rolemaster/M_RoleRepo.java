package com.iemr.admin.repository.rolemaster;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.admin.data.rolemaster.M_Role;
import com.iemr.admin.data.rolemaster.M_Role104;

@Repository
@RestResource(exported = false)
public interface M_RoleRepo extends CrudRepository<M_Role, Integer> {
	

	/*@Query("SELECT distinct u.roleID,u.roleName,u.roleDesc,u.deleted,"
			+ "ms.screenName,"
			+ "rsm.sRSMappingID"
			+ " FROM M_Role u "
			+ "INNER JOIN u.roleScreenMapping rsm "
			+ "INNER JOIN rsm.m_Screen ms "
			+ " where u.providerServiceMapID = :pssmID")
	ArrayList<Object[]> getAllRoleByMapId(@Param("pssmID") int pssmID);
	*/
	
	@Query("SELECT u FROM M_Role u where u.roleID = :roleID")
	M_Role getRoleByRoleId(@Param("roleID") Integer roleID);
	
	
	@Query("SELECT u FROM M_Role u where u.providerServiceMapID = :pssmID AND deleted=0 order by u.roleName")
	ArrayList<M_Role> getAllRoleByMapId1(@Param("pssmID") int pssmID);


	ArrayList<M_Role> findByDeletedAndProviderServiceMapID(boolean b, Integer providerServiceMapID);

}
