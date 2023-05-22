package com.iemr.admin.repo.labmodule;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.iemr.admin.data.labmodule.ProcedureMaster;

/***
 * 
 * @author Rajeev Tripathi
 *
 */
@Repository
@RestResource(exported = false)
public interface ProcedureMasterRepo extends CrudRepository<ProcedureMaster, Integer> {
	@Query("SELECT procedureID, procedureName, procedureDesc, procedureType, gender, deleted, "
			+ "createdBy, iotProcedureID FROM ProcedureMaster WHERE providerServiceMapID = :psmID")
	ArrayList<Object[]> findProcByPSMID(@Param("psmID") Integer psmID);
	
	@Query("SELECT new ProcedureMaster( procedureID, procedureName, procedureDesc, procedureType, gender, deleted, "
			+ "createdBy, isMandatory, isCalibration, iotProcedureID )FROM ProcedureMaster WHERE providerServiceMapID = :psmID")
	ArrayList<ProcedureMaster> findProcByPSMIDc(@Param("psmID") Integer psmID);

	@Query("SELECT procedureID, procedureName,procedureDesc,procedureType,gender,providerServiceMapID,deleted, "
			+ "processed,createdBy,createdDate,modifiedBy,isCalibration,lastModDate FROM ProcedureMaster WHERE procedureID = :pID")
	public ArrayList<Object[]> getProcedureDetails(@Param("pID") Integer pID);

	@Query("SELECT procedureID, procedureName,procedureDesc,procedureType FROM ProcedureMaster "
			+ " WHERE providerServiceMapID = :psmID AND deleted = false ")
	public ArrayList<Object[]> getProcedureDetailsDelFalse(@Param("psmID") Integer psmID);

	@Modifying
	@Transactional
	@Query("UPDATE ProcedureMaster set deleted = :status WHERE procedureID = :procedureID")
	public int updateProcedureStatus(@Param("procedureID") Integer procedureID, @Param("status") Boolean status);

	@Modifying
	@Transactional
	@Query(" UPDATE ProcedureMaster set procedureName = :procedureName, procedureDesc = :procedureDesc, "
			+ " procedureType = :procedureType, gender = :gender, modifiedBy = :modifiedBy,iotProcedureID =:iotprocedureID,isMandatory =:isMandatory "
			+ " ,isCalibration =:isCalibration Where procedureID = :procedureID ")
	public Integer updateProcedureDetails(@Param("procedureID") Integer procedureID,
			@Param("procedureName") String procedureName, @Param("procedureDesc") String procedureDesc,
			@Param("procedureType") String procedureType, @Param("gender") String gender,
			@Param("modifiedBy") String modifiedBy,@Param("iotprocedureID") Integer iotprocedureID,@Param("isMandatory") Boolean isMandatory,@Param("isCalibration") Boolean isCalibration);
}
