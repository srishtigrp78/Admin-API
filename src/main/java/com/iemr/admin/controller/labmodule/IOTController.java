package com.iemr.admin.controller.labmodule;

import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iemr.admin.sevice.labmodule.IOTService;
import com.iemr.admin.utils.response.OutputResponse;

@RestController
@RequestMapping("/iotController")
public class IOTController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	@Autowired
	IOTService iotService;
	
	@CrossOrigin()
	@RequestMapping(value = "/getIOTProcedure", headers = "Authorization", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON, 
							consumes = MediaType.APPLICATION_JSON)
	public String getIOTProcedure() {
		OutputResponse response = new OutputResponse();
		logger.info("getIOTProcedure request : {}");

		try {
			String data = iotService.getIOTProcedure();
			response.setResponse(data);
		} catch (Exception e) {
			//e.printStackTrace();
			logger.error("Unexpected error:" , e);
			response.setError(e);
		}
		logger.info("getIOTProcedure response : {}", response);

		/**
		 * sending the response...
		 */
		return response.toString();

	}
	
	@CrossOrigin()
	@RequestMapping(value = "/getIOTComponent", headers = "Authorization" ,method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON, 
							consumes = MediaType.APPLICATION_JSON)
	public String getIOTComponent() {
		OutputResponse response = new OutputResponse();
		logger.info("getIOTComponent request : {}");

		try {
			String data = iotService.getIOTComponent();
			response.setResponse(data);
		} catch (Exception e) {
			//e.printStackTrace();
			logger.error("Unexpected error:" , e);
			response.setError(e);
		}
		logger.info("getIOTComponent response : {}", response);

		/**
		 * sending the response...
		 */
		return response.toString();

	}
}
