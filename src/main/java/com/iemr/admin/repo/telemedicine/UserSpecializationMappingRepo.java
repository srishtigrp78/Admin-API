package com.iemr.admin.repo.telemedicine;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.admin.data.telemedicine.UserSpecializationMapping;

@Repository
@RestResource(exported = false)
public interface UserSpecializationMappingRepo extends JpaRepository<UserSpecializationMapping, Integer> {

	ArrayList<UserSpecializationMapping> findByDeleted(boolean b);

	@Query("Select new UserSpecializationMapping(u.userSpecializationMapID, u.userID, usr.UserName,u.specializationID,"
			+ " spec.specialization,u.deleted,usr.Deleted,spec.deleted) from UserSpecializationMapping u "
			+ "join u.user usr  join u.specialization spec where usr.ServiceProviderID=:data")
	ArrayList<UserSpecializationMapping> findByServiceprovider(@Param("data")Integer data);
  

	
	

}
