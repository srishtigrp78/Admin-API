package com.iemr.admin.repo.calibration;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.admin.data.calibration.Calibration;

@Repository
@RestResource(exported = false)
public interface CalibrationAPIRepo extends CrudRepository<Calibration, Integer>{
	@Query("SELECT calib from Calibration calib where calib.deleted=false")
	public Calibration getCalibration();
	
}
