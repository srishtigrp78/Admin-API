package com.iemr.admin.controller.fetosensemaster;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iemr.admin.data.fetosensemaster.FetosenseDeviceID;
import com.iemr.admin.service.fetosensemaster.FetosenseService;
import com.iemr.admin.utils.exception.IEMRException;
import com.iemr.admin.utils.mapper.InputMapper;
import com.iemr.admin.utils.response.OutputResponse;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * 
 * @author DE40034072
 *
 */
@CrossOrigin
@RestController
@RequestMapping(value = "/fetosense", headers = "Authorization")
public class FetosenseFetchController {

	@Autowired
	private FetosenseService fetosenseService;

	private Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());
	/***
	 * @author DU20091017
	 * @param requestObj
	 * @return
	 */
	@CrossOrigin
	@ApiOperation(value = "Provides the fetosense DeviceID")
	@RequestMapping(value = "/fetch/fetosenseDeviceID", method = RequestMethod.POST, headers = "Authorization")
	public String getFetosenseDeviceID(
			@ApiParam("{ 'providerServiceMapID': Integer }") @RequestBody String requestObj) {

		logger.info("Request Object for getting fetosense DeviceID - " + requestObj);
		OutputResponse output = new OutputResponse();
		try {
			FetosenseDeviceID fetosenseRequest = InputMapper.gson().fromJson(requestObj, FetosenseDeviceID.class);
			String response = fetosenseService.getFetosenseDeviceID(fetosenseRequest);
			if (response != null)
				output.setResponse(response);
		} catch (IEMRException e) {
			logger.error("getFetosenseDeviceID failed with error " + e.getMessage());
			output.setError(5000, e.getMessage());
		}
		return output.toString();
	}

	/***
	 * @author DU20091017
	 * @param requestObj
	 * @return
	 */
	@CrossOrigin
	@ApiOperation(value = "Provides the vanID and fetosense DeviceID")
	@RequestMapping(value = "/fetch/vanIDAndFetosenseDeviceID", method = RequestMethod.POST, headers = "Authorization")
	public String getVanIDAndDeviceID(
			@ApiParam("\r\n" + "{\"parkingPlaceID\" : Integer,\r\n" + "                    \"vanTypeID\" : Integer,\r\n"
					+ "                    \"providerServiceMapID\" : Integer\r\n" + "                  };\r\n"
					+ "") @RequestBody String requestObj) {

		logger.info("Request Object for getting van ID and fetosense DeviceID - " + requestObj);
		OutputResponse output = new OutputResponse();

		try {
			FetosenseDeviceID fetosenseRequest = InputMapper.gson().fromJson(requestObj, FetosenseDeviceID.class);
			String response = fetosenseService.getvanIDAndFetosenseDeviceID(fetosenseRequest);
			if (response != null)
				output.setResponse(response);
		} catch (IEMRException e) {
			logger.error("getVanIDAndDeviceID failed with error " + e.getMessage());
			output.setError(5000, e.getMessage());
		}

		return output.toString();
	}
	
	@CrossOrigin
	@ApiOperation(value = "Provides the worklist of vanID and fetosense DeviceID")
	@RequestMapping(value = "/fetch/mappingWorklist", method = RequestMethod.POST, headers = "Authorization")
	public String getMappedWorklist(
			@ApiParam("\r\n" + "{\"parkingPlaceID\" : Integer,\r\n" + "                    \"vanTypeID\" : Integer,\r\n"
					+ "                    \"providerServiceMapID\" : Integer\r\n" + "                  };\r\n"
					+ "") @RequestBody String requestObj) {
		logger.info("Request Object for getting van ID and fetosense DeviceID - " + requestObj);
		OutputResponse output = new OutputResponse();
		try {
			FetosenseDeviceID fetosenseRequest = InputMapper.gson().fromJson(requestObj, FetosenseDeviceID.class);
			String mappedWorklist = fetosenseService.getVanIDMappingWorklist(fetosenseRequest);
			if(mappedWorklist != null)
				output.setResponse(mappedWorklist);
		}catch (IEMRException e) {
			logger.error("getMappedWorklist failed with error " + e.getMessage());
			output.setError(5000, e.getMessage());
		}
		return output.toString();
	}

}
