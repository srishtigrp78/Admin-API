package com.iemr.admin.repo.employeemaster;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.admin.data.employeemaster.V_Userservicerolemapping;
import com.iemr.admin.data.rolemaster.M_Role;

@Repository
@RestResource(exported = false)
public interface V_UserservicerolemappingRepo extends CrudRepository<V_Userservicerolemapping, Integer>{

	/*@Query("SELECT u FROM M_Role u where u.roleID = :roleID")
	M_Role getRoleByRoleId(@Param("roleID") Integer roleID);*/
         
	
	
	@Query("SELECT u FROM V_Userservicerolemapping u where u.userID = :userID")
	ArrayList<V_Userservicerolemapping> getDataByUserID(@Param("userID") Integer userID);
    
	@Query("SELECT u FROM V_Userservicerolemapping u where u.name = :name")
	ArrayList<V_Userservicerolemapping> getDataByName(@Param("name") String name);
    
	
	@Query("SELECT u FROM V_Userservicerolemapping u where u.serviceProviderID = :serviceProviderID ORDER By u.userName")
	ArrayList<V_Userservicerolemapping> getAllRoleOfProvider(@Param("serviceProviderID") Integer serviceProviderID);

	

}
