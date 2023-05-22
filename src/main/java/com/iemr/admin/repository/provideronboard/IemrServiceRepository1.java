package com.iemr.admin.repository.provideronboard;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
//import org.springframework.test.annotation.Commit;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.admin.data.provideronboard.ServiceProvider_Model;

@Transactional
//@Commit

@Repository
@RestResource(exported = false)
public interface IemrServiceRepository1 extends CrudRepository<ServiceProvider_Model, Integer> {
	@Query("Select b from ServiceProvider_Model b where deleted=0")
	List<ServiceProvider_Model> getAlldata(Pageable pageable);

	@Query("SELECT u FROM ServiceProvider_Model u WHERE LOWER(u.serviceProviderId) = LOWER(:res) AND deleted=0")
	ServiceProvider_Model getDataById(@Param("res") int res);
	// M_User1 findByUserID(@Param("UserID") Long UserID);

	@Query("Select b from ServiceProvider_Model b")
	List<ServiceProvider_Model> getAlldata1();
	@Query("SELECT u.serviceProviderName FROM ServiceProvider_Model u WHERE LOWER(u.serviceProviderName) = LOWER(:serviceProviderName)")
	String getProviderName(@Param("serviceProviderName")String serviceProviderName);
    
	
	@Query(" Select b from ServiceProvider_Model b ORDER By b.serviceProviderName ")
	ArrayList<ServiceProvider_Model> getAllProviderName();
    
	
	@Query("Select b from ServiceProvider_Model b where serviceProviderId=:serviceProviderId")
	ServiceProvider_Model getProviderData(@Param("serviceProviderId")Integer serviceProviderId);

}
