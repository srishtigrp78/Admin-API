package com.iemr.admin.repo.employeemaster;


import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.admin.data.employeemaster.V_Showuser;

@Repository
@RestResource(exported = false)
public interface V_ShowuserRepo extends CrudRepository<V_Showuser, Integer>{
     
	@Query("SELECT u FROM V_Showuser u WHERE u.isProviderAdmin=1 ORDER By u.userName")
	ArrayList<V_Showuser> getAdminDetails();
	
	@Query("SELECT u FROM V_Showuser u")
	ArrayList<V_Showuser> EmployeeDetails5();
    
	
	@Query("SELECT u FROM V_Showuser u WHERE u.serviceProviderID= :serviceProviderID ORDER By u.userName")
	ArrayList<V_Showuser> EmployeeDetails4(@Param("serviceProviderID") Integer serviceProviderID);

}
