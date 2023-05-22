package com.iemr.admin.repo.labmodule;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.iemr.admin.data.labmodule.ProcedureComponentMapping;

/***
 * 
 * @author Rajeev Tripathi
 *
 */
@Repository
@RestResource(exported = false)
public interface ProcedureComponentMappingRepo extends CrudRepository<ProcedureComponentMapping, Integer> {
	@Query("SELECT distinct pcm.procedureID, pcm.testComponentID, pm.procedureName, pm.procedureDesc, cm.testComponentName, "
			+ " pcm.createdBy, cm.testComponentDesc "
			+ " FROM ProcedureComponentMapping pcm INNER JOIN pcm.compMaster cm INNER JOIN pcm.procMaster pm"
			+ " WHERE pcm.providerServiceMapID = :psmID AND cm.providerServiceMapID = :psmID AND "
			+ " pm.providerServiceMapID = :psmID AND pcm.deleted = false AND pm.deleted = false " + "ORDER BY pcm.procedureID ")
	public ArrayList<Object[]> getProcedureComponentMappingList(@Param("psmID") Integer psmID);

	@Query("SELECT distinct pcm.procedureID, pcm.testComponentID, pm.procedureName, pm.procedureDesc, cm.testComponentName,cm.inputType,pm.procedureType,"
			+ " pcm.createdBy, cm.testComponentDesc, cm.lionicNum "
			+ " FROM ProcedureComponentMapping pcm INNER JOIN pcm.compMaster cm INNER JOIN pcm.procMaster pm"
			+ " WHERE pcm.procedureID = :pID AND pcm.deleted = false " + "ORDER BY pcm.procedureID ")
	public ArrayList<Object[]> getProcedureComponentMappingListForProcedureID(@Param("pID") Integer pID);

	@Transactional
	@Modifying
	@Query("UPDATE ProcedureComponentMapping set deleted = true, modifiedBy = :modifiedBy  WHERE procedureID = :pID AND deleted = false")
	public Integer softDeleteProcCompMapping(@Param("pID") Integer pID, @Param("modifiedBy") String modifiedBy);
}
