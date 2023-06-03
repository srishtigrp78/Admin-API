package com.iemr.admin.controller.drugtype;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iemr.admin.data.drugtype.M_Drugtype;
import com.iemr.admin.service.drugtype.DrugtypeInter;
import com.iemr.admin.utils.mapper.InputMapper;
import com.iemr.admin.utils.response.OutputResponse;

@RestController
public class DrugtypeController {
	private Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());
	@Autowired
	private DrugtypeInter drugtypeInter;
	
	
	
	@CrossOrigin()
	@RequestMapping(value =  "/createDrugtype" ,headers = "Authorization", method = { RequestMethod.POST }, produces = { "application/json" })
	public String createManufacturer(@RequestBody String createDrugtype) {
		//JSONObject requestOBJ = new JSONObject(providerBlocking);
		
		
		      OutputResponse response = new OutputResponse();
		try {
			

			M_Drugtype[] Drugtype = InputMapper.gson().fromJson(createDrugtype,
					M_Drugtype[].class);
		      List<M_Drugtype> DrugtypeData = Arrays.asList(Drugtype);
			
			ArrayList<M_Drugtype> saveData=drugtypeInter.createDrugtypeData(DrugtypeData);
			
			
			//ArrayList<V_Showproviderservicemapping> getProviderStatus1=blockingInter.getProviderStatus1(Pharmacologicalcategory.getServiceProviderID());
			
			response.setResponse(saveData.toString());

		} catch (Exception e) {
			
			logger.error("Unexpected error:" , e);
			response.setError(e);

		}
		/**
		 * sending the response...
		 */
		return response.toString();

	}
	
	
	
	@CrossOrigin()
	@RequestMapping(value =  "/getDrugtype",headers = "Authorization", method = { RequestMethod.POST }, produces = { "application/json" })
	public String getManufacturer(@RequestBody String getDrugtype) {
		//JSONObject requestOBJ = new JSONObject(providerBlocking);
		
		OutputResponse response = new OutputResponse();

		try {

			M_Drugtype Drugtype = InputMapper.gson().fromJson(getDrugtype,
					M_Drugtype.class);
		      //List<M_Drugtype> DrugtypeData = Arrays.asList(Drugtype);
			
			ArrayList<M_Drugtype> getedData=drugtypeInter.getDrugtypeData(Drugtype.getProviderServiceMapID());
			
			
			//ArrayList<V_Showproviderservicemapping> getProviderStatus1=blockingInter.getProviderStatus1(Pharmacologicalcategory.getServiceProviderID());
			
			response.setResponse(getedData.toString());

		} catch (Exception e) {
			
			logger.error("Unexpected error:" , e);
			response.setError(e);

		}
		/**
		 * sending the response...
		 */
		return response.toString();

	}

	
	
	
	
	
	@CrossOrigin()
	@RequestMapping(value =  "/editDrugtype" ,headers = "Authorization", method = { RequestMethod.POST }, produces = { "application/json" })
	public String editManufacturer(@RequestBody String editDrugtype) {
		//JSONObject requestOBJ = new JSONObject(providerBlocking);
		
		OutputResponse response = new OutputResponse();

		try {

			M_Drugtype Drugtype = InputMapper.gson().fromJson(editDrugtype,
					M_Drugtype.class);
		      //List<M_Drugtype> DrugtypeData = Arrays.asList(Drugtype);
			
			M_Drugtype geteditedData=drugtypeInter.editDrugtypeData(Drugtype.getDrugTypeID());
			 
			geteditedData.setDrugTypeName(Drugtype.getDrugTypeName());
			geteditedData.setDrugTypeDesc(Drugtype.getDrugTypeDesc());
			geteditedData.setDrugTypeCode(Drugtype.getDrugTypeCode());
			geteditedData.setStatus(Drugtype.getStatus());
			geteditedData.setModifiedBy(Drugtype.getModifiedBy());
			
			M_Drugtype saveeditedData=drugtypeInter.saveeditDrugtype(geteditedData);
			
			//ArrayList<V_Showproviderservicemapping> getProviderStatus1=blockingInter.getProviderStatus1(Pharmacologicalcategory.getServiceProviderID());
			
			response.setResponse(saveeditedData.toString());

		} catch (Exception e) {
			
			logger.error("Unexpected error:" , e);
			response.setError(e);

		}
		/**
		 * sending the response...
		 */
		return response.toString();

	}

	
	
	
	
	
	@CrossOrigin()
	@RequestMapping(value =  "/deleteDrugtype" ,headers = "Authorization", method = { RequestMethod.POST }, produces = { "application/json" })
	public String deleteManufacturer(@RequestBody String deleteDrugtype) {
		//JSONObject requestOBJ = new JSONObject(providerBlocking);
		
		OutputResponse response = new OutputResponse();

		try {

			M_Drugtype Drugtype = InputMapper.gson().fromJson(deleteDrugtype,
					M_Drugtype.class);
		      //List<M_Drugtype> DrugtypeData = Arrays.asList(Drugtype);
			
			M_Drugtype geteditedData=drugtypeInter.editDrugtypeData(Drugtype.getDrugTypeID());
			 
			geteditedData.setDeleted(Drugtype.getDeleted());
			
			M_Drugtype deletedData=drugtypeInter.saveeditDrugtype(geteditedData);
			
			//ArrayList<V_Showproviderservicemapping> getProviderStatus1=blockingInter.getProviderStatus1(Pharmacologicalcategory.getServiceProviderID());
			
			response.setResponse(deletedData.toString());

		} catch (Exception e) {
			
			logger.error("Unexpected error:" , e);
			response.setError(e);

		}
		/**
		 * sending the response...
		 */
		return response.toString();

	}

	

}