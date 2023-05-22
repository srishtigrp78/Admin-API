package com.iemr.admin.repo.fetosensemaster;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.iemr.admin.data.fetosensemaster.M_Fetosense;

@Repository
@RestResource(exported = false)
public interface FetosenseRepository extends CrudRepository<M_Fetosense, Integer> {
	
	@Query("SELECT F FROM M_Fetosense F WHERE fetosenseTestID = :fetosenseTestID")
	public M_Fetosense getByFetosenseTestID(@Param("fetosenseTestID") Integer fetosenseTestID);

	@Query("SELECT F FROM M_Fetosense F WHERE F.providerServiceMapID = :psmID")
	public ArrayList<M_Fetosense> getByProviderServiceMapID(@Param("psmID") Integer psmID);
	
	@Modifying
	@Transactional
	@Query(" UPDATE M_Fetosense SET testName = :testName, testDesc = :testDesc, "
			+ "modifiedBy = :modifiedBy WHERE fetosenseTestID = :fetosenseTestID ")
	public Integer updateFetosenseDetails(@Param("fetosenseTestID") Integer fetosenseTestID,
			@Param("testName") String testName, @Param("testDesc") String testDesc,
			@Param("modifiedBy") String modifiedBy);

	@Modifying
	@Transactional
	@Query("UPDATE M_Fetosense SET deleted = :status WHERE fetosenseTestID = :fetosenseTestID")
	public int updateFetosenseStatus(@Param("fetosenseTestID") Integer fetosenseTestID, @Param("status") Boolean status);
}
	
