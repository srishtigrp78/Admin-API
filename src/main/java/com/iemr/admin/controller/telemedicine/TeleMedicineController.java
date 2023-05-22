package com.iemr.admin.controller.telemedicine;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iemr.admin.data.telemedicine.M_UserTemp;
import com.iemr.admin.data.telemedicine.Specialization;
import com.iemr.admin.data.telemedicine.TMinput;
import com.iemr.admin.data.telemedicine.UserSpecializationMapping;
import com.iemr.admin.service.telemedicine.TMInter;
import com.iemr.admin.utils.response.OutputResponse;

@RestController
@RequestMapping(value = "/TM")
public class TeleMedicineController {
	private Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());
	
	@Autowired
	private TMInter tmInter;
	
	
	@CrossOrigin()
	@RequestMapping(value =  "/getUser" ,headers = "Authorization", method = { RequestMethod.POST }, produces = { "application/json" })
	public String getUserTM(@RequestBody TMinput tminput) {
		
		OutputResponse response = new OutputResponse();

		try {
		     

			
			ArrayList<M_UserTemp> createdData=tmInter.getUser(tminput);
			
			
			response.setResponse(createdData.toString());

		} catch (Exception e) {
			//e.printStackTrace();
			logger.error("Unexpected error:" , e);
			response.setError(e);

		}
		/**
		 * sending the response...
		 */
		return response.toString();

	}

	@CrossOrigin()
	@RequestMapping(value =  "/getSpecialization" ,headers = "Authorization", method = { RequestMethod.POST }, produces = { "application/json" })
	public String getSpecialization() {
		
		OutputResponse response = new OutputResponse();

		try {
		     

			
			ArrayList<Specialization> createdData=tmInter.getSpecialization();
			
			
			response.setResponse(createdData.toString());

		} catch (Exception e) {
			//e.printStackTrace();
			logger.error("Unexpected error:" , e);
			response.setError(e);

		}
		/**
		 * sending the response...
		 */
		return response.toString();

	}
	
	@CrossOrigin()
	@RequestMapping(value =  "/getUserSpecialization" ,headers = "Authorization", method = { RequestMethod.POST }, produces = { "application/json" })
	public String getUserSpecialization(@RequestBody TMinput tminput) {
		
		OutputResponse response = new OutputResponse();

		try {
		     

			
			ArrayList<UserSpecializationMapping> createdData=tmInter.getUserSpecialization(tminput.getServiceproviderID());
			
			
			response.setResponse(createdData.toString());

		} catch (Exception e) {
			//e.printStackTrace();
			logger.error("Unexpected error:" , e);
			response.setError(e);

		}
		/**
		 * sending the response...
		 */
		return response.toString();

	}
	
	@CrossOrigin()
	@RequestMapping(value =  "/saveUserSpecialization" ,headers = "Authorization", method = { RequestMethod.POST }, produces = { "application/json" })
	public String saveUserSpecialization(@RequestBody ArrayList<UserSpecializationMapping>  userSpecializationMapping ) {
		
		OutputResponse response = new OutputResponse();

		try {
		     

			
			ArrayList<UserSpecializationMapping> createdData=tmInter.saveUserSpecialization(userSpecializationMapping);
			
			
			response.setResponse(createdData.toString());

		} catch (Exception e) {
			//e.printStackTrace();
			logger.error("Unexpected error:" , e);
			response.setError(e);

		}
		/**
		 * sending the response...
		 */
		return response.toString();

	}
	
	@CrossOrigin()
	@RequestMapping(value =  "/activateUserSpecialization" ,headers = "Authorization", method = { RequestMethod.POST }, produces = { "application/json" })
	public String saveUserSpecialization(@RequestBody UserSpecializationMapping  userSpecializationMapping ) {
		
		OutputResponse response = new OutputResponse();

		try {
		     

			
			UserSpecializationMapping createdData=tmInter.findUserSpecialization(userSpecializationMapping);
			createdData.setDeleted(userSpecializationMapping.getDeleted());
			createdData.setModifiedBy(userSpecializationMapping.getModifiedBy());
			
			createdData=tmInter.saveoneUserSpecialization(createdData);
			
			response.setResponse(createdData.toString());

		} catch (Exception e) {
			//e.printStackTrace();
			logger.error("Unexpected error:" , e);
			response.setError(e);

		}
		/**
		 * sending the response...
		 */
		return response.toString();

	}

}
