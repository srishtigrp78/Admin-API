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
package com.iemr.admin.repo.locationmaster;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.iemr.admin.data.locationmaster.StateServiceMapping1;

@Repository
public interface LocationMasterRepo extends CrudRepository<StateServiceMapping1, Integer>{
	
	@Query("SELECT distinct rp.stateID,"
			  + " sm.stateName as stateName, "
			  + " rp.statusID,"
			  + " rp.providerServiceMapID"
			  + " FROM StateServiceMapping1 rp "
			  + " JOIN rp.stateMaster sm "
			  + " WHERE rp.serviceProviderID =:serviceProviderID AND rp.deleted=false ORDER BY sm.stateName")
	ArrayList<Object[]> getStateByServiceProviderId(@Param("serviceProviderID") Integer serviceProviderID);
	
	
	@Query("SELECT distinct rp.serviceID, rp.providerServiceMapID,"
			+ " sm.serviceName as serviceName"
			+ " FROM StateServiceMapping1 rp "
			+ " JOIN rp.serviceMaster sm "
			+ " WHERE rp.serviceProviderID =:serviceProviderID AND rp.stateID =:stateID AND rp.deleted=false")

	ArrayList<Object[]> getServiceByServiceProviderIdAndStateId(@Param ("serviceProviderID") Integer serviceProviderID, @Param ("stateID") Integer stateID);

	@Query("SELECT u.providerServiceMapID FROM StateServiceMapping1 u WHERE u.serviceProviderID=:serviceProviderID AND u.stateID=:stateID AND u.serviceID=:serviceID AND deleted=false ")
	StateServiceMapping1 getProviderServiceMapID(@Param("serviceProviderID") Integer serviceProviderID, @Param("stateID") Integer stateID, @Param("serviceID") Integer serviceID);


	
	@Query("SELECT u FROM StateServiceMapping1 u WHERE u.serviceProviderID=:serviceProviderID AND u.stateID=:stateID AND u.serviceID=:serviceID AND deleted=false ")
	   List<StateServiceMapping1> getAllByMapId2(@Param("serviceProviderID") Integer serviceProviderID, @Param("stateID") Integer stateID, @Param("serviceID") Integer serviceID);

    
	
	@Query("SELECT u FROM StateServiceMapping1 u WHERE u.serviceProviderID=:serviceProviderID AND u.serviceID=:serviceID AND deleted=false ")
	ArrayList<StateServiceMapping1> getLocationByServiceID(@Param("serviceProviderID")Integer serviceProviderID,@Param("serviceID") Integer serviceID);

     
	@Query("SELECT u FROM StateServiceMapping1 u WHERE u.serviceProviderID=:serviceProviderID AND u.stateID=:stateID AND deleted=false")
	ArrayList<StateServiceMapping1> getLocationByStateID(@Param("serviceProviderID")Integer serviceProviderID,@Param("stateID")Integer stateID);

	@Query("SELECT distinct u.stateID, sm.stateName as stateName, u.providerServiceMapID "
			+ "FROM StateServiceMapping1 u "
			+ " JOIN u.stateMaster sm "
			+ "WHERE u.serviceID=:serviceID and u.serviceProviderID =:serviceProviderID")
	ArrayList<Object[]> getStatesByServiceId(@Param("serviceID") Integer serviceID,@Param ("serviceProviderID") Integer serviceProviderID);
	
	
	@Query("SELECT u FROM StateServiceMapping1 u WHERE u.serviceProviderID=:serviceProviderID AND u.stateID is null AND u.serviceID=:serviceID AND deleted=false ")
	ArrayList<StateServiceMapping1> getAllByMapId3(@Param("serviceProviderID") Integer serviceProviderID, @Param("serviceID") Integer serviceID);

	
}
