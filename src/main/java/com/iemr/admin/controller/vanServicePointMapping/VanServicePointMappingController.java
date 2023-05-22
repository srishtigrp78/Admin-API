package com.iemr.admin.controller.vanServicePointMapping;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iemr.admin.data.vanMaster.M_Van;
import com.iemr.admin.data.vanServicePointMapping.M_VanServicePointMap;
import com.iemr.admin.service.vanServicePointMapping.VanServicePointMappingServiceImpl;
import com.iemr.admin.to.vanMaster.VanMasterTO;
import com.iemr.admin.utils.exception.IEMRException;
import com.iemr.admin.utils.mapper.InputMapper;
import com.iemr.admin.utils.response.OutputResponse;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping(value = "/vanMaster")
public class VanServicePointMappingController {

	
	@Autowired
	private VanServicePointMappingServiceImpl vanServicePointMappingServiceImpl;
	
	@CrossOrigin()
	@ApiOperation(
			value = "Stores vanServicePointMappings",
			consumes = "application/json",
			produces = "application/json")
	@RequestMapping(value =  "/save/vanServicePointMappings" ,headers = "Authorization", method = { RequestMethod.POST })
	public String saveVanServicePointMappings(@ApiParam(
			value = "{\"vanID\":\"integer\", \"servicePointID\":\"integer\", \"providerServiceMapID\":\"integer\", \"vanSession\":\"string\", "
					+ "\"createdBy\":\"string\"}") @RequestBody String vanServicePointMappings) throws IEMRException {
		
		
			OutputResponse output = new OutputResponse();

			VanMasterTO vanMaster = InputMapper.gson().fromJson(vanServicePointMappings,VanMasterTO.class);
			
			try {
				ArrayList<M_VanServicePointMap> mapsList= new ArrayList<M_VanServicePointMap>();
				for(M_VanServicePointMap vanMapping : vanMaster.getVanServicePointMappings()){
					if(vanMapping.getVanServicePointMapID()==null){
						mapsList.add(vanMapping);
						
				}else if(vanMapping.getVanServicePointMapID()>0){
					M_VanServicePointMap vanServicePointMapping = vanServicePointMappingServiceImpl.getVanServicePointMappingByID(vanMapping.getVanServicePointMapID());
						vanServicePointMapping.setVanSession(vanMapping.getVanSession());
						vanServicePointMapping.setModifiedBy(vanMapping.getCreatedBy());
						mapsList.add(vanServicePointMapping);
				}
					
				}
				ArrayList<M_VanServicePointMap> van = vanServicePointMappingServiceImpl.saveVanServicePointMappings(mapsList);
				
				//ArrayList<M_VanServicePointMap> van=vanServicePointMappingServiceImpl.saveVanServicePointMappings(vanMaster.getVanServicePointMappings());
				output.setResponse(van.toString());
			} catch (Exception e) {
				
				output.setError(e);
			}
			return output.toString();
	}
	
//	@CrossOrigin()
//	@ApiOperation(
//			value = "Stores vanServicePointMappings",
//			consumes = "application/json",
//			produces = "application/json")
//	@RequestMapping(value = { "/save/vanServicePointMappings" }, method = { RequestMethod.POST }, headers = "Authorization")
//	public String updateVanServicePointMappings(@ApiParam(
//			value = "{\"vanServicePointMapID\":\"integer\", \"vanSession\":\"string\", "
//					+ "\"modifiedBy\":\"string\"}") @RequestBody String vanServicePointMappings) {
//		
//		
//			OutputResponse output = new OutputResponse();
//
//			VanMasterTO vanMaster = InputMapper.gson().fromJson(vanServicePointMappings,VanMasterTO.class);
//			
//			
//			try {
//				ArrayList<M_VanServicePointMap> mapsList= new ArrayList<M_VanServicePointMap>();
//				for(M_VanServicePointMap vanMapping : vanMaster.getVanServicePointMappings()){
//					M_VanServicePointMap vanServicePointMapping = vanServicePointMappingServiceImpl.getVanServicePointMappingByID(vanMapping.getVanServicePointMapID());
//					vanServicePointMapping.setVanSession(vanMapping.getVanSession());
//					vanServicePointMapping.setModifiedBy(vanMapping.getModifiedBy());
//					mapsList.add(vanServicePointMapping);
//				}
//				ArrayList<M_VanServicePointMap> van = vanServicePointMappingServiceImpl.saveVanServicePointMappings(mapsList);
//				output.setResponse(van.toString());
//			} catch (Exception e) {
//				
//				output.setError(e);
//			}
//			return output.toString();
//	}
	
	@CrossOrigin()
	@ApiOperation(
			value = "get vanServicePointMappings",
			consumes = "application/json",
			produces = "application/json")
	@RequestMapping(value =  "/get/vanServicePointMappings" ,headers = "Authorization", method = { RequestMethod.POST })
	public String getVanServicePointMappings(@ApiParam(
			value = "{\"stateID\":\"integer\", \"districtID\":\"integer\", \"parkingPlaceID\":\"integer\", \"serviceProviderID\":\"integer\"}") @RequestBody String vanMaster) throws IEMRException {
		
			OutputResponse output = new OutputResponse();
			
			M_Van vanDetails = InputMapper.gson().fromJson(vanMaster,M_Van.class);
			M_VanServicePointMap vanDetails1 = InputMapper.gson().fromJson(vanMaster,M_VanServicePointMap.class);

			try {
//				ArrayList<M_VanServicePointMap> vans=vanServicePointMappingServiceImpl.getAvailableVanServicePointMappings(
//						vanDetails1.getDistrictID(), vanDetails.getParkingPlaceID(),vanDetails.getVanID(), vanDetails.getProviderServiceMapID());

				ArrayList<M_VanServicePointMap> vans=vanServicePointMappingServiceImpl.getAvailableVanServicePointMappings(
						 vanDetails.getParkingPlaceID(),vanDetails.getVanID(), vanDetails.getProviderServiceMapID());

				
				output.setResponse(vans.toString());
			} catch (Exception e) {
				
				output.setError(e);
			}
			return output.toString();
	}
	@CrossOrigin()
	@ApiOperation(
			value = "get vanServicePointMappings",
			consumes = "application/json",
			produces = "application/json")
	@RequestMapping(value =  "/get/vanServicePointMappingsV1" ,headers = "Authorization", method = { RequestMethod.POST })
	public String vanServicePointMappingsV1(@ApiParam(
			value = "{ \"vanID\":\"integer\", \"parkingPlaceID\":\"integer\", \"providerServiceMapID\":\"integer\"}") @RequestBody String vanMaster) throws IEMRException {
		
			OutputResponse output = new OutputResponse();
			
			M_Van vanDetails = InputMapper.gson().fromJson(vanMaster,M_Van.class);
			M_VanServicePointMap vanDetails1 = InputMapper.gson().fromJson(vanMaster,M_VanServicePointMap.class);

			try {
//				ArrayList<M_VanServicePointMap> vans=vanServicePointMappingServiceImpl.getAvailableVanServicePointMappings(
//						vanDetails1.getDistrictID(), vanDetails.getParkingPlaceID(),vanDetails.getVanID(), vanDetails.getProviderServiceMapID());

				ArrayList<M_VanServicePointMap> vans=vanServicePointMappingServiceImpl.getAvailableVanServicePointMappingsV1(
						 vanDetails.getParkingPlaceID(),vanDetails.getVanID(), vanDetails.getProviderServiceMapID());

				
				output.setResponse(vans.toString());
			} catch (Exception e) {
				
				output.setError(e);
			}
			return output.toString();
	}
	
	@CrossOrigin()
	@ApiOperation(
			value = "Removes vanServicePointMapping",
			consumes = "application/json",
			produces = "application/json")
	@RequestMapping(value =  "/remove/vanServicePointMapping" ,headers = "Authorization", method = { RequestMethod.POST })
	public String deleteVanServicePointMappingDetails(@ApiParam(
			value = "{\"vanServicePointMapID\":\"integer\", \"deleted\":\"boolean\", \"modifiedBy\":\"string\"}") @RequestBody String vanServicePointMapping) throws IEMRException {
		
			OutputResponse output = new OutputResponse();

			M_VanServicePointMap vanMaster = InputMapper.gson().fromJson(vanServicePointMapping,M_VanServicePointMap.class);
			
			try {
				String response;
				int update=vanServicePointMappingServiceImpl.updateVanServicePointMappingStatus(vanMaster);
				if(update==1){
					response = "status updated successfully";
				}else{
					response = "Failed to update the status";
				}
				output.setResponse(response.toString());
			} catch (Exception e) {
				
				output.setError(e);
			}
			return output.toString();
	}
	
	
}
