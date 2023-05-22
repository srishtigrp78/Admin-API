package com.iemr.admin.repository.provideronboard;

import java.util.ArrayList;
import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.admin.data.provideronboard.M_Institution;

@Repository
@RestResource(exported = false)
public interface M_InstitutionRepo extends CrudRepository<M_Institution, Integer> {

	@Query("SELECT u FROM M_Institution u where u.providerServiceMapID=:providerServiceMapID AND u.stateID=:stateID AND u.districtID=:districtID AND u.blockID=:blockID")
	ArrayList<M_Institution> getInstution(@Param("providerServiceMapID") Integer providerServiceMapID,
			@Param("stateID") Integer stateID, @Param("districtID") Integer districtID,
			@Param("blockID") Integer blockID);

	@Query("SELECT u FROM M_Institution u where u.providerServiceMapID=:providerServiceMapID AND u.stateID=:stateID AND u.districtID=:districtID")
	ArrayList<M_Institution> getInstution(@Param("providerServiceMapID") Integer providerServiceMapID,
			@Param("stateID") Integer stateID, @Param("districtID") Integer districtID);

	@Query("SELECT u FROM M_Institution u where u.institutionID=:institutionID")
	M_Institution geteditedData(@Param("institutionID") Integer institutionID);

	@Query("SELECT u FROM M_Institution u where u.providerServiceMapID=:providerServiceMapID AND u.stateID=:stateID AND u.districtID=:districtID AND u.blockID=:blockID")
	ArrayList<M_Institution> getInstutionByBlock(@Param("providerServiceMapID") Integer providerServiceMapID,
			@Param("stateID") Integer stateID, @Param("districtID") Integer districtID,
			@Param("blockID") Integer blockID);

	@Query("SELECT u FROM M_Institution u where u.providerServiceMapID=:providerServiceMapID AND u.stateID=:stateID AND u.districtID=:districtID AND u.villageID=:villageID")
	ArrayList<M_Institution> getInstutionByVillage(@Param("providerServiceMapID") Integer providerServiceMapID,
			@Param("stateID") Integer stateID, @Param("districtID") Integer districtID,
			@Param("villageID") Integer villageID);

	@Query("SELECT u FROM M_Institution u where u.providerServiceMapID=:providerServiceMapID AND u.stateID=:stateID "
			+ "AND u.districtID=:districtID AND u.blockID=:blockID AND u.villageID=:villageID")
	ArrayList<M_Institution> getInstutionByBlockAndVillage(@Param("providerServiceMapID") Integer providerServiceMapID,
			@Param("stateID") Integer stateID, @Param("districtID") Integer districtID,
			@Param("blockID") Integer blockID, @Param("villageID") Integer villageID);
	/*
	 * Created by DU20091017
	 */
	@Query(value =" call db_iemr.PR_InstituteBulkUpload(:institutionDetails, :createdby, :userID, :providerID)", nativeQuery = true)
	ArrayList<Object[]> institutionByFile(@Param("institutionDetails") String institutionDetails,@Param("createdby") String createdby,
			@Param("userID") Integer userID,@Param("providerID") Integer providerID);
}
