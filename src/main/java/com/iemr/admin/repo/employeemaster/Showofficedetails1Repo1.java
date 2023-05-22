package com.iemr.admin.repo.employeemaster;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.admin.data.employeemaster.Showofficedetails1;

@Repository
@RestResource(exported = false)
public interface Showofficedetails1Repo1 extends CrudRepository<Showofficedetails1, Integer>{
	@Query("SELECT u FROM Showofficedetails1 u where u.providerServiceMapID = :pssmID AND u.districtID=:districtID AND deleted=0")
	ArrayList<Showofficedetails1> getlocationByMapid(@Param("pssmID") int pssmID,@Param("districtID")Integer districtID);
	//ArrayList<Showofficedetails1> getlocationByMapid(int tempProSerStatMapID, Integer districtID);

}
