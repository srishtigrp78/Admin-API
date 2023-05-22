package com.iemr.admin.controller.calibration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iemr.admin.data.calibration.CalibrationStrip;
import com.iemr.admin.service.calibration.CalibrationService;
import com.iemr.admin.utils.exception.IEMRException;
import com.iemr.admin.utils.mapper.InputMapper;
import com.iemr.admin.utils.response.OutputResponse;

import io.swagger.annotations.ApiParam;

@RestController
public class CalibrationController {
	@Autowired
	private CalibrationService calibrationService;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());
	
	/**
	 * @author SH20094090
	 * @param request
	 * @return CalibrationStripMasterData
	 */
	@CrossOrigin()
	@RequestMapping(value =  "/createCalibrationStrip" ,headers = "Authorization", method = { RequestMethod.POST }, produces = { "application/json" })
	public String createCalibrationStrip(@ApiParam(value = "{\"stripCode\":\"String\",\"expiryDate\":\"Timestamp\",\"providerServiceMapID\":\"Integer\",\"createdBy\":\"String\"}") @RequestBody String request) {
		
		OutputResponse response = new OutputResponse();
		logger.info("Request object for Calibration strip master creation :" + request);

		try {
			CalibrationStrip calibration = InputMapper.gson().fromJson(request,
					CalibrationStrip.class);
			
			Integer saveData=calibrationService.saveData(calibration);
			if(saveData>0)
				response.setResponse("Data saved successfully");
			else
				response.setError(5000,"Error while saving Calibration master data");
		} catch (IEMRException e) {
			e.printStackTrace();
			logger.error("Error while saving data:" + e);
			response.setError(5000,e.getMessage());

		}
		/**
		 * sending the response...
		 */
		return response.toString();
		

	}
	/**
	 * @author SH20094090
	 * @param request
	 * @return CalibrationStripList
	 */
	@CrossOrigin()
	@RequestMapping(value =  "/fetchCalibrationStrips" ,headers = "Authorization", method = { RequestMethod.POST }, produces = { "application/json" })
	public String fetchCalibrationStrips(@ApiParam(value = "{\"providerServiceMapID\":\"Integer\"}") @RequestBody String request) {
		
		OutputResponse response = new OutputResponse();
		logger.info("Request object for fetching Calibration strip :" + request);
		try {
			CalibrationStrip calibration = InputMapper.gson().fromJson(request,
					CalibrationStrip.class);
			
			String saveData=calibrationService.fetchData(calibration);
			response.setResponse(saveData);
		} catch (IEMRException e) {
			e.printStackTrace();
			logger.error("Error while fetching data:" + e);
			response.setError(e);
		}
		/**
		 * sending the response...
		 */
		return response.toString();

	}
	/**
	 * @author SH20094090
	 * @param request
	 * @return Response
	 */
	@CrossOrigin()
	@RequestMapping(value =  "/deleteCalibrationStrip" ,headers = "Authorization", method = { RequestMethod.POST }, produces = { "application/json" })
	public String deleteCalibrationStrip(@ApiParam(value = "{\"deleted\":\"Boolean\",\"CalibrationStripID\":\"Integer\"}") @RequestBody String request) {
		
		OutputResponse response = new OutputResponse();
		logger.info("Request object to delete Calibration data :" + request);
		try {
			CalibrationStrip calibration = InputMapper.gson().fromJson(request,
					CalibrationStrip.class);
			
			Integer updateData=calibrationService.deleteData(calibration);
			if(updateData>0)
				response.setResponse("Data deleted successfully");
			else 
				response.setError(5000,"Error while updating Calibration master data");
		} catch (IEMRException e) {
			e.printStackTrace();
			logger.error("Error while updating data:" + e);
			response.setError(e);

		}
		/**
		 * sending the response...
		 */
		return response.toString();

	}
	
	@CrossOrigin()
	@RequestMapping(value =  "/updateCalibrationStrip" ,headers = "Authorization", method = { RequestMethod.POST }, produces = { "application/json" })
	public String updateCalibrationStrip(@ApiParam(value = "{\"stripCode\":\"String\",\"expiryDate\":\"Timestamp\",\"providerServiceMapID\":\"Integer\",\"createdBy\":\"String\"}") @RequestBody String request) {
		
		OutputResponse response = new OutputResponse();
		logger.info("Request object for updating Calibration strip data :" + request);
		try {
			CalibrationStrip calibration = InputMapper.gson().fromJson(request,
					CalibrationStrip.class);
			
			Integer saveData=calibrationService.updateData(calibration);
			if(saveData>0)
				response.setResponse("Data updated successfully");
			else
				response.setError(5000,"Error while updating Calibration master data");
		} catch (IEMRException e) {
			e.printStackTrace();
			logger.error("Error while updating data:" + e);
			response.setError(5000,e.getMessage());

		}
		/**
		 * sending the response...
		 */
		return response.toString();

	}
	
	
}
