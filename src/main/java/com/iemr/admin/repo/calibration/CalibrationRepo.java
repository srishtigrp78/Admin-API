package com.iemr.admin.repo.calibration;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.admin.data.calibration.CalibrationStrip;

@Repository
@RestResource(exported = false)
public interface CalibrationRepo extends CrudRepository<CalibrationStrip, Integer>{

	
	@Query("SELECT iotProcedure FROM CalibrationStrip iotProcedure where iotProcedure.deleted=false and providerServiceMapID = :providerServiceMapID order by 1 desc ")
	public Page<CalibrationStrip> getCalibrationStripsWithPagination(@Param("providerServiceMapID") Integer providerServiceMapID, Pageable pageable);
	
	@Query("SELECT iotProcedure FROM CalibrationStrip iotProcedure where providerServiceMapID = :providerServiceMapID order by 1 desc ")
	public ArrayList<CalibrationStrip>  getCalibrationStripsWithoutPagination(@Param("providerServiceMapID") Integer providerServiceMapID);
	
	@Transactional
	@Modifying
	@Query("update CalibrationStrip set deleted = :deleted where calibrationStripID = :id")
	public int deleteCalibrationStrip(@Param("id") Long id, @Param("deleted") Boolean deleted);

	@Query("SELECT iotProcedure FROM CalibrationStrip iotProcedure where iotProcedure.stripCode =:stripCode and providerServiceMapID = :providerServiceMapID ")
	public ArrayList<CalibrationStrip> checkIfAlreadyStripPresent(@Param("providerServiceMapID") Integer providerServiceMapID, @Param("stripCode") String stripCode);
}
