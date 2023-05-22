package com.iemr.admin.repo.labmodule;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.admin.data.labmodule.IOTComponent;
import com.iemr.admin.data.labmodule.IOTProcedure;

@Repository
@RestResource(exported = false)
public interface IOTRepo extends CrudRepository<IOTProcedure, Integer> {

	@Query("SELECT iotProcedure from IOTProcedure iotProcedure where iotProcedure.deleted=false")
	ArrayList<IOTProcedure> getIOTProcedure();
	
	@Query("SELECT iotComponent from IOTComponent iotComponent where iotComponent.deleted=false")
	ArrayList<IOTComponent> getIOTComponent();
	
	@Query("SELECT iotProcedure from IOTProcedure iotProcedure where iotProcedure.iotProcedureID =:id ")
	IOTProcedure getIOTProcedureByID(@Param("id") Integer id);
	
	@Transactional
	@Modifying
	@Query("update IOTProcedure set calibrationStartAPI = :calibrationStartAPI,calibrationStatusAPI = :calibrationStatusAPI,calibrationEndAPI = :calibrationEndAPI "
			+ " where iotProcedureID = :id")
	public int updateIOTWithCalibration(@Param("calibrationStartAPI") String calibrationStartAPI,
			@Param("calibrationStatusAPI") String calibrationStatusAPI,@Param("calibrationEndAPI") String calibrationEndAPI
			,@Param("id") Integer id);
}
