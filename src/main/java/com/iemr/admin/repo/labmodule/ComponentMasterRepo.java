package com.iemr.admin.repo.labmodule;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.iemr.admin.data.labmodule.ComponentMaster;
import com.iemr.admin.data.loinc.*;

/***
 * 
 * @author Rajeev Tripathi
 *
 */
@Repository
@RestResource(exported = false)
public interface ComponentMasterRepo extends CrudRepository<ComponentMaster, Integer> {
	/*
	 * @Query("SELECT DISTINCT cm.testComponentID, cm.testComponentName, cm.testComponentDesc, cm.inputType, cm.createdBy FROM ComponentMaster cm LEFT JOIN cm.componentResultMap crm "
	 * +
	 * " WHERE cm.providerServiceMapID = :psmID AND crm.providerServiceMapID = :psmID AND cm.deleted != 1 "
	 * )
	 */
	@Query("SELECT cm.testComponentID, cm.testComponentName, cm.testComponentDesc, cm.inputType, cm.createdBy, cm.deleted "
			+ " FROM ComponentMaster cm WHERE cm.providerServiceMapID = :psmID")

	public ArrayList<Object[]> getComponentDetails(@Param("psmID") Integer psmID);
	
	@Query("SELECT new ComponentMaster (cm.testComponentID, cm.testComponentName, cm.testComponentDesc, cm.inputType, cm.createdBy, cm.deleted, cm.iotComponentID) "
			+ " FROM ComponentMaster cm WHERE cm.providerServiceMapID = :psmID")
	public ArrayList<ComponentMaster> getComponentDetailsBypsmID(@Param("psmID") Integer psmID);

//	@Query("SELECT cm.testComponentID, cm.testComponentName, cm.testComponentDesc,cm.inputType,cm.lionicNum "
//			+ " FROM ComponentMaster cm WHERE cm.providerServiceMapID = :psmID AND cm.deleted=0")
	
	@Query(value = "SELECT cm.TestComponentID, cm.TestComponentName, cm.TestComponentDesc,cm.InputType,cm.Loinc_Num,cm.loinc_Component " + 
			" FROM db_iemr.m_testcomponent cm  WHERE cm.providerServiceMapID = :psmID AND cm.deleted=0 ", nativeQuery = true)

	public ArrayList<Object[]> getComponentDetailsDelFalse(@Param("psmID") Integer psmID);

	@Query("SELECT cm.testComponentID, cm.testComponentName, cm.testComponentDesc, cm.inputType, cm.createdBy, cm.deleted "
			+ " FROM ComponentMaster cm WHERE cm.testComponentID = :componentID")

	public ArrayList<Object[]> getComponentDetailsByCompID(@Param("componentID") Integer componentID);

	@Modifying
	@Transactional
	@Query("UPDATE ComponentMaster set deleted = :status WHERE testComponentID = :componentID")
	public int updateComponentStatus(@Param("componentID") Integer componentID, @Param("status") Boolean status);

	@Modifying
	@Transactional
	@Query("UPDATE ComponentMaster set testComponentName = :testComponentName, testComponentDesc = :testComponentDesc, "
			+ " measurementUnit = :measurementUnit, range_min = :range_min, "
			+ " range_normal_min = :range_normal_min, range_normal_max = :range_normal_max, range_max = :range_max, modifiedBy = :modifiedBy, iotComponentID =:iotComponentID, lionicNum =:lionicNum, lionicTerm =:lionicTerm  "
			+ " WHERE testComponentID = :componentID ")
	public Integer updateComponentDetailsTextBox(@Param("componentID") Integer componentID,
			@Param("testComponentName") String testComponentName, @Param("testComponentDesc") String testComponentDesc,
			@Param("measurementUnit") String measurementUnit, @Param("range_min") Double range_min,
			@Param("range_normal_min") Double range_normal_min, @Param("range_normal_max") Double range_normal_max,
			@Param("range_max") Double range_max, @Param("modifiedBy") String modifiedBy,  @Param("iotComponentID") Integer iotComponentID,
			  @Param("lionicNum") String lionicNum,@Param("lionicTerm") String lionicTerm);

	@Modifying
	@Transactional
	@Query("UPDATE ComponentMaster set testComponentName = :testComponentName, testComponentDesc = :testComponentDesc, lionicNum =:lionicNum, lionicTerm =:lionicTerm, "
			+ " modifiedBy = :modifiedBy, iotComponentID =:iotComponentID " + " WHERE testComponentID = :componentID ")
	public Integer updateComponentDetailsOtherThenTextBox(@Param("componentID") Integer componentID,
			@Param("testComponentName") String testComponentName, @Param("testComponentDesc") String testComponentDesc,
			@Param("modifiedBy") String modifiedBy,  @Param("iotComponentID") Integer iotComponentID, @Param("lionicNum") String lionicNum,@Param("lionicTerm") String lionicTerm);

//	@Query( value = "Select component from db_iemr.m_loinc where loinc_num = :lionicNum ", nativeQuery = true)
//	public String getComponentWithLoincCode(@Param("lionicNum") String lionicNum);
	public ComponentMaster findByTestComponentID(Integer testComponentID);
}
