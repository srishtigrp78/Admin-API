package com.iemr.admin.service.calibration;

import com.iemr.admin.data.calibration.CalibrationStrip;
import com.iemr.admin.utils.exception.IEMRException;

public interface CalibrationService {
public Integer saveData(CalibrationStrip req) throws IEMRException;
public String fetchData(CalibrationStrip req) throws IEMRException;
public Integer deleteData(CalibrationStrip req) throws IEMRException;
public Integer updateData(CalibrationStrip req) throws IEMRException;
}
