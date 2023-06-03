package com.iemr.admin.controller.vanMaster;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iemr.admin.data.vanMaster.M_Van;
import com.iemr.admin.data.vanType.M_VanType;
import com.iemr.admin.service.vanMaster.VanMasterServiceImpl;
import com.iemr.admin.to.vanMaster.VanMasterTO;
import com.iemr.admin.utils.exception.IEMRException;
import com.iemr.admin.utils.mapper.InputMapper;
import com.iemr.admin.utils.response.OutputResponse;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping(value = "/vanMaster")
public class VanMasterController {
	
	@Autowired
	private VanMasterServiceImpl vanMasterServiceImpl;
	
	@CrossOrigin()
	@ApiOperation(
			value = "Stores Van Details",
			consumes = "application/json",
			produces = "application/json")
	@RequestMapping(value =  "/save/vanDetails" ,headers = "Authorization", method = { RequestMethod.POST })
	public String saveVanDetails(@ApiParam(
			value = "{\"vanName\":\"string\", \"vehicalNo\":\"string\", \"providerServiceMapID\":\"integer\", "
					+ "\"countryID\":\"integer\", \"stateID\":\"integer\", \"districtID\":\"integer\", "
					+ " \"createdBy\":\"string\", \"deleted\":\"boolean\" ,"
					+ " \"swymedDomain\":\"string\", \"swymedID\":\"string\", \"swymedEmail\":\"string\"}") @RequestBody String vanDetails) throws IEMRException {
		
			OutputResponse output = new OutputResponse();

			VanMasterTO vanMaster = InputMapper.gson().fromJson(vanDetails,VanMasterTO.class);
			
			
			try {

				ArrayList<M_Van> van=vanMasterServiceImpl.saveVanDetails(vanMaster.getVanMaster());
				output.setResponse(van.toString());
			} catch (Exception e) {
				
				output.setError(e);
			}
			return output.toString();
	}
	
	@CrossOrigin()
	@ApiOperation(
			value = "get van Details",
			consumes = "application/json",
			produces = "application/json")
	@RequestMapping(value =  "/get/vanDetails" ,headers = "Authorization", method = { RequestMethod.POST })
	public String getServicePoints(@ApiParam(
			value = "{\"stateID\":\"integer\", \"districtID\":\"integer\", \"parkingPlaceID\":\"integer\", \"serviceProviderID\":\"integer\"}") @RequestBody String vanMaster) throws IEMRException {
		
			OutputResponse output = new OutputResponse();
			
			M_Van vanDetails = InputMapper.gson().fromJson(vanMaster,M_Van.class);

			try {
//				ArrayList<M_Van> vans=vanMasterServiceImpl.getAvailableVans( vanDetails.getDistrictID(), vanDetails.getParkingPlaceID(),
//						vanDetails.getVanTypeID(), vanDetails.getProviderServiceMapID());
				ArrayList<M_Van> vans=vanMasterServiceImpl.getAvailableVans( vanDetails.getParkingPlaceID(),
						vanDetails.getVanTypeID(), vanDetails.getProviderServiceMapID());
				output.setResponse(vans.toString());
			} catch (Exception e) {
				
				output.setError(e);
			}
			return output.toString();
	}
	
	
	@CrossOrigin()
	@ApiOperation(
			value = "Removes Van",
			consumes = "application/json",
			produces = "application/json")
	@RequestMapping(value =  "/remove/vanDetails" ,headers = "Authorization", method = { RequestMethod.POST })
	public String deleteVanDetails(@ApiParam(
			value = "{\"vanID\":\"integer\", \"deleted\":\"boolean\", \"modifiedBy\":\"string\"}") @RequestBody String vanMaster) throws IEMRException {
		
			OutputResponse output = new OutputResponse();

			M_Van van = InputMapper.gson().fromJson(vanMaster,M_Van.class);
			
			try {
				String response;
				int update=vanMasterServiceImpl.updateVanStatus(van);
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
	
	@CrossOrigin()
	@ApiOperation(
			value = "update Van Details",
			consumes = "application/json",
			produces = "application/json")
	@RequestMapping(value =  "/update/vanDetails" ,headers = "Authorization", method = { RequestMethod.POST })
	public String updateZoneData(@ApiParam(
			value = "{\"vanID\":\"integer\", \"vanName\":\"string\", \"vehicalNo\":\"string\", \"providerServiceMapID\":\"integer\", "
					+ "\"countryID\":\"integer\", \"stateID\":\"integer\", \"districtID\":\"integer\", "
					+ " \"createdBy\":\"string\", \"deleted\":\"boolean\", "
					+ " \"swymedDomain\":\"string\", \"swymedID\":\"string\", \"swymedEmail\":\"string\"}") @RequestBody String vanDetails) throws IEMRException {
		
			OutputResponse output = new OutputResponse();

			M_Van vanMaster = InputMapper.gson().fromJson(vanDetails,M_Van.class);
			
			
			try {
				M_Van vanData = vanMasterServiceImpl.getVanByID(vanMaster.getVanID());
				vanData.setStateID(vanMaster.getStateID());
//				vanData.setDistrictID(vanMaster.getDistrictID());
				vanData.setParkingPlaceID(vanMaster.getParkingPlaceID());
				vanData.setVanName(vanMaster.getVanName());
				vanData.setVehicalNo(vanMaster.getVehicalNo());
				vanData.setVanTypeID(vanMaster.getVanTypeID());
				vanData.setModifiedBy(vanMaster.getModifiedBy());
				vanData.setSwymedDomain(vanMaster.getSwymedDomain()); 
				vanData.setSwymedEmail(vanMaster.getSwymedEmail());
				vanData.setSwymedID(vanMaster.getSwymedID());
				
				M_Van updatedData = vanMasterServiceImpl.updateVanData(vanData);
				
				output.setResponse(updatedData.toString());
			} catch (Exception e) {
				
				output.setError(e);
			}
			return output.toString();
	}
	
	@CrossOrigin()
	@ApiOperation(
			value = "Stores VanType Details",
			consumes = "application/json",
			produces = "application/json")
	@RequestMapping(value =  "/save/vanTypeDetails" ,headers = "Authorization", method = { RequestMethod.POST })
	public String saveVanTypeDetails(@ApiParam(
			value = "{\"vanType\":\"string\", \"vanTypeDesc\":\"string\", \"providerServiceMapID\":\"integer\"}") @RequestBody String vanDetails) throws IEMRException {
		
			OutputResponse output = new OutputResponse();

			VanMasterTO vanMaster = InputMapper.gson().fromJson(vanDetails,VanMasterTO.class);
			
			
			try {

				ArrayList<M_VanType> vanType=vanMasterServiceImpl.saveVanTypeDetails(vanMaster.getVanTypeMaster());
				output.setResponse(vanType.toString());
			} catch (Exception e) {
				
				output.setError(e);
			}
			return output.toString();
	}
	
	@CrossOrigin()
	@ApiOperation(
			value = "get Van Types",
			consumes = "application/json",
			produces = "application/json")
	@RequestMapping(value =  "/get/vanTypes" ,headers = "Authorization", method = { RequestMethod.POST })
	public String getVanTypes() {
		
			OutputResponse output = new OutputResponse();
			try {
				ArrayList<M_VanType> vans=vanMasterServiceImpl.getVanTypes();
				output.setResponse(vans.toString());
			} catch (Exception e) {
				
				output.setError(e);
			}
			return output.toString();
	}
	
	@CrossOrigin()
	@ApiOperation(
			value = "Removes VanType",
			consumes = "application/json",
			produces = "application/json")
	@RequestMapping(value =  "/remove/vanTypeDetails" ,headers = "Authorization", method = { RequestMethod.POST })
	public String deleteVanType(@ApiParam(
			value = "{\"vanTypeID\":\"integer\", \"deleted\":\"boolean\", \"modifiedBy\":\"string\"}") @RequestBody String vanMaster) throws IEMRException {
		
			OutputResponse output = new OutputResponse();

			M_VanType vanType = InputMapper.gson().fromJson(vanMaster,M_VanType.class);
			
			try {
				String response;
				int update=vanMasterServiceImpl.updateVanTypeStatus(vanType);
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
	
	@CrossOrigin()
	@ApiOperation(
			value = "get van Details",
			consumes = "application/json",
			produces = "application/json")
	@RequestMapping(value =  "/getVanMaster" ,headers = "Authorization", method = { RequestMethod.POST })
	public String getVanMaster(@ApiParam(
			value = "{\"providerServiceMapID\":\"integer\"}") @RequestBody String vanMaster) throws IEMRException {
		
			OutputResponse output = new OutputResponse();
			
			M_Van vanDetails = InputMapper.gson().fromJson(vanMaster,M_Van.class);

			try {
				List<M_Van> vans=vanMasterServiceImpl.getVanMaster( vanDetails.getProviderServiceMapID(),vanDetails.getParkingPlaceID());
				output.setResponse(vans.toString());
			} catch (Exception e) {
				
				output.setError(e);
			}
			return output.toString();
	}
	
	@CrossOrigin()
	@ApiOperation(
			value = "get van Details",
			consumes = "application/json",
			produces = "application/json")
	@RequestMapping(value =  "/getVanFromFacilityID" ,headers = "Authorization", method = { RequestMethod.POST })
	public String getVanFromFacilityID(@ApiParam(
			value = "{\"providerServiceMapID\":\"integer\"}") @RequestBody M_Van vanMaster) throws IEMRException {
		
			OutputResponse output = new OutputResponse();
			
//			M_Van vanDetails = InputMapper.gson().fromJson(vanMaster,M_Van.class);

			try {
				List<M_Van> vans=vanMasterServiceImpl.getVanFromFacilityID( vanMaster.getFacilityID());
				output.setResponse(vans.toString());
			} catch (Exception e) {
				
				output.setError(e);
			}
			return output.toString();
	}
//	@CrossOrigin()
//	@ApiOperation(
//			value = "get van Details",
//			consumes = "application/json",
//			produces = "application/json")
//	@RequestMapping(value =  "/get/vanDetailsNotMapped" ,headers = "Authorization", method = { RequestMethod.POST })
//	public String getVanDetailsNotMapped(@ApiParam(
//			value = "{\"stateID\":\"integer\", \"districtID\":\"integer\", \"parkingPlaceID\":\"integer\", \"serviceProviderID\":\"integer\"}") @RequestBody String vanMaster) throws IEMRException {
//		
//			OutputResponse output = new OutputResponse();
//			
//			M_Van vanDetails = InputMapper.gson().fromJson(vanMaster,M_Van.class);
//
//			try {
////				ArrayList<M_Van> vans=vanMasterServiceImpl.getAvailableVans( vanDetails.getDistrictID(), vanDetails.getParkingPlaceID(),
////						vanDetails.getVanTypeID(), vanDetails.getProviderServiceMapID());
//				ArrayList<M_Van> vans=vanMasterServiceImpl.getNonMappedAvailablevans(vanDetails.getParkingPlaceID(),
//						vanDetails.getVanTypeID(), vanDetails.getProviderServiceMapID());
//				output.setResponse(vans.toString());
//			} catch (Exception e) {
//				
//				output.setError(e);
//			}
//			return output.toString();
//	}
}