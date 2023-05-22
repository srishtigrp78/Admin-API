package com.iemr.admin.repository.provideronboard;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.admin.data.provideronboard.V_Showprovideradmin;

@Repository
@RestResource(exported = false)
public interface V_ShowprovideradminRepo extends CrudRepository<V_Showprovideradmin, Integer> {
    
	@Query("SELECT u FROM V_Showprovideradmin u ORDER BY u.serviceProviderName")
	ArrayList<V_Showprovideradmin> getAllProviderAdmin();

}
