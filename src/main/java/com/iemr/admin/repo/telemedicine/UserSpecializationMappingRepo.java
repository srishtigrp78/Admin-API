/*
* AMRIT – Accessible Medical Records via Integrated Technology 
* Integrated EHR (Electronic Health Records) Solution 
*
* Copyright (C) "Piramal Swasthya Management and Research Institute" 
*
* This file is part of AMRIT.
*
* This program is free software: you can redistribute it and/or modify
* it under the terms of the GNU General Public License as published by
* the Free Software Foundation, either version 3 of the License, or
* (at your option) any later version.
*
* This program is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
* GNU General Public License for more details.
*
* You should have received a copy of the GNU General Public License
* along with this program.  If not, see https://www.gnu.org/licenses/.
*/
package com.iemr.admin.repo.telemedicine;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.iemr.admin.data.telemedicine.UserSpecializationMapping;

@Repository
public interface UserSpecializationMappingRepo extends JpaRepository<UserSpecializationMapping, Integer> {

	ArrayList<UserSpecializationMapping> findByDeleted(boolean b);

	@Query("Select new UserSpecializationMapping(u.userSpecializationMapID, u.userID, usr.UserName,u.specializationID,"
			+ " spec.specialization,u.deleted,usr.Deleted,spec.deleted) from UserSpecializationMapping u "
			+ "join u.user usr  join u.specialization spec where usr.ServiceProviderID=:data")
	ArrayList<UserSpecializationMapping> findByServiceprovider(@Param("data")Integer data);
	
	UserSpecializationMapping findByUserSpecializationMapID(Integer userSpecializationMapID);
  

	
	

}
