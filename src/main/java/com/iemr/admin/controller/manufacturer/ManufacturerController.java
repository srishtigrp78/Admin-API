package com.iemr.admin.controller.manufacturer;

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

import com.iemr.admin.data.manufacturer.M_Manufacturer;
import com.iemr.admin.service.manufacturer.ManufacturerInter;
import com.iemr.admin.utils.mapper.InputMapper;
import com.iemr.admin.utils.response.OutputResponse;

@RestController
public class ManufacturerController {
	private Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());
	@Autowired
	private ManufacturerInter manufacturerInter;
	
	
	
	@CrossOrigin()
	@RequestMapping(value =  "/createManufacturer" ,headers = "Authorization", method = { RequestMethod.POST }, produces = { "application/json" })
	public String createManufacturer(@RequestBody String createManufacturer) {
		//JSONObject requestOBJ = new JSONObject(providerBlocking);
		
		OutputResponse response = new OutputResponse();

		try {

			M_Manufacturer[] Manufacturer = InputMapper.gson().fromJson(createManufacturer,
					M_Manufacturer[].class);
		      List<M_Manufacturer> ManufacturerData = Arrays.asList(Manufacturer);
			
			ArrayList<M_Manufacturer> saveData=manufacturerInter.createManufacturer(ManufacturerData);
			
			
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
	@RequestMapping(value =  "/getManufacturer" ,headers = "Authorization", method = { RequestMethod.POST }, produces = { "application/json" })
	public String getManufacturer(@RequestBody String getManufacturer) {
		//JSONObject requestOBJ = new JSONObject(providerBlocking);
		
		OutputResponse response = new OutputResponse();

		try {

			M_Manufacturer Manufacturer = InputMapper.gson().fromJson(getManufacturer,
					M_Manufacturer.class);
		     // List<M_Manufacturer> ManufacturerData = Arrays.asList(Manufacturer);
			
			ArrayList<M_Manufacturer> getData=manufacturerInter.createManufacturer(Manufacturer.getProviderServiceMapID());
			
			
			//ArrayList<V_Showproviderservicemapping> getProviderStatus1=blockingInter.getProviderStatus1(Pharmacologicalcategory.getServiceProviderID());
			
			response.setResponse(getData.toString());

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
	@RequestMapping(value =  "/editManufacturer" ,headers = "Authorization", method = { RequestMethod.POST }, produces = { "application/json" })
	public String editManufacturer(@RequestBody String editManufacturer) {
		//JSONObject requestOBJ = new JSONObject(providerBlocking);
		
		OutputResponse response = new OutputResponse();

		try {

			M_Manufacturer Manufacturer = InputMapper.gson().fromJson(editManufacturer,
					M_Manufacturer.class);
		     // List<M_Manufacturer> ManufacturerData = Arrays.asList(Manufacturer);
			
			M_Manufacturer editData=manufacturerInter.editManufacturer(Manufacturer.getManufacturerID());
			
			editData.setManufacturerDesc(Manufacturer.getManufacturerDesc());
			editData.setContactPerson(Manufacturer.getContactPerson());
			editData.setcST_GST_No(Manufacturer.getcST_GST_No());
			editData.setAddressLine1(Manufacturer.getAddressLine1());
			editData.setAddressLine2(Manufacturer.getAddressLine2());
			editData.setCountryID(Manufacturer.getCountryID());
			editData.setStateID(Manufacturer.getStateID());
			editData.setDistrictID(Manufacturer.getDistrictID());
			editData.setPinCode(Manufacturer.getPinCode());
			editData.setModifiedBy(Manufacturer.getModifiedBy());
			
			M_Manufacturer saveData=manufacturerInter.saveEditedData(editData);
			
			
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
	@RequestMapping(value =  "/deleteManufacturer" ,headers = "Authorization", method = { RequestMethod.POST }, produces = { "application/json" })
	public String deleteManufacturer(@RequestBody String deleteManufacturer) {
		//JSONObject requestOBJ = new JSONObject(providerBlocking);
		
		OutputResponse response = new OutputResponse();

		try {

			M_Manufacturer Manufacturer = InputMapper.gson().fromJson(deleteManufacturer,
					M_Manufacturer.class);
		     // List<M_Manufacturer> ManufacturerData = Arrays.asList(Manufacturer);
			
			M_Manufacturer editData=manufacturerInter.editManufacturer(Manufacturer.getManufacturerID());
			
			editData.setDeleted(Manufacturer.getDeleted());
			
			
			M_Manufacturer saveData=manufacturerInter.saveEditedData(editData);
			
			
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
	@RequestMapping(value =  "/checkManufacturerCode" ,headers = "Authorization", method = { RequestMethod.POST }, produces = { "application/json" })
	public String checkManufacturerCode(@RequestBody String deleteManufacturer) {
		//JSONObject requestOBJ = new JSONObject(providerBlocking);
		
		OutputResponse response = new OutputResponse();

		try {

			M_Manufacturer Manufacturer = InputMapper.gson().fromJson(deleteManufacturer,
					M_Manufacturer.class);
		     // List<M_Manufacturer> ManufacturerData = Arrays.asList(Manufacturer);
			
			
			Boolean saveData=manufacturerInter.checkManufacturerCode(Manufacturer);
			
			
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
	

}
