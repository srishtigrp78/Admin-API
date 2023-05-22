package com.iemr.admin.repository.rolemaster;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.admin.data.employeemaster.M_Role;
import com.iemr.admin.data.rolemaster.RoleScreenMapping;

@Repository
@RestResource(exported = false)
public interface RoleScreenMappingRepo extends CrudRepository<RoleScreenMapping, Integer>{
	
	@Query("SELECT distinct u.roleID,rm.roleName,rm.roleDesc,rm.deleted,"
			+ " sm.screenName,"
			+ " u.sRSMappingID"
			+ " FROM RoleScreenMapping u "
			+ "INNER JOIN u.m_role rm "
			+ "INNER JOIN u.m_Screen sm "
			+ " where u.providerServiceMapID = :pssmID")
	ArrayList<Object[]> getAllRoleByMapId(@Param("pssmID") int pssmID);
	
	@Query("SELECT distinct u.roleID as roleID,rm.roleName as roleName,rm.roleDesc,rm.deleted,"
			+ " sm.screenName,"
			+ " u.sRSMappingID"
			+ " FROM RoleScreenMapping u "
			+ "INNER JOIN u.m_role rm "
			+ "INNER JOIN u.m_Screen sm "
			+ " where u.providerServiceMapID = :pssmID and sm.deleted=false")
	ArrayList<Object[]> getAllRoleBypsMapId(@Param("pssmID") int pssmID);
	
	
	
	@Transactional
	@Modifying
	@Query(" UPDATE  RoleScreenMapping u SET u.screenID=:screenID where u.sRSMappingID =:sRSMappingID")
	int updatescreenId(@Param("sRSMappingID")Integer sRSMappingID,@Param("screenID")Integer screenID);

}
