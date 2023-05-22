package com.iemr.admin.repo.locationmaster;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.admin.data.locationmaster.M_ProviderServiceAddMapping;
import com.iemr.admin.data.locationmaster.Showofficedetails;
import com.iemr.admin.to.locationmaster.LocationTO;

@Repository
@RestResource(exported = false)
public interface ShowofficedetailsRepo extends CrudRepository<Showofficedetails, Integer>{
	
	@Query(value = " SELECT * FROM Showofficedetails u where deleted=0",nativeQuery = true)
	ArrayList<Showofficedetails> getAlldata();
	
	
	@Query("SELECT u FROM Showofficedetails u where u.providerServiceMapID = :pssmID")
	ArrayList<Showofficedetails> getlocationByMapid(@Param("pssmID") int pssmID);


	@Query("SELECT u FROM Showofficedetails u where u.providerServiceMapID = :data ")
	ArrayList<Showofficedetails> getlocationByMapid1(@Param("data")Integer data);

	@Query("SELECT u FROM Showofficedetails u where u.providerServiceMapID = :i AND deleted=0 ")
	ArrayList<Showofficedetails> getOfficeName(@Param("i") Integer i);

	@Query("SELECT u FROM Showofficedetails u where u.providerServiceMapID = :pssmID AND u.districtID=:districtID")
	ArrayList<Showofficedetails> getlocationByMapid3(@Param("pssmID")Integer pssmID, @Param("districtID")Integer districtID);

	//ArrayList<Showofficedetails1> getlocationByMapid(int tempProSerStatMapID);
 
}
