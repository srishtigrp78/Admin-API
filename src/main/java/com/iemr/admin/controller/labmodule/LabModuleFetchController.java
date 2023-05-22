package com.iemr.admin.controller.labmodule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iemr.admin.sevice.labmodule.MastersFetchingServiceImpl;
import com.iemr.admin.utils.response.OutputResponse;

import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin
@RequestMapping(value = "labModule", headers = "Authorization")
public class LabModuleFetchController {
	private MastersFetchingServiceImpl mastersFetchingServiceImpl;

	@Autowired
	public void setMastersFetchingServiceImpl(MastersFetchingServiceImpl mastersFetchingServiceImpl) {
		this.mastersFetchingServiceImpl = mastersFetchingServiceImpl;
	}

	@CrossOrigin
	@ApiOperation(value = "Fetch procedure master for provider-service-map-id", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/fetchProcedureMaster/{psmID}" }, method = { RequestMethod.GET })
	public String fetchProcedureMaster(@PathVariable("psmID") Integer psmID) {
		OutputResponse response = new OutputResponse();
		try {
			if (psmID != null & psmID > 0) {
				String s = mastersFetchingServiceImpl.getProcedureMaster(psmID);
				response.setResponse(s);
			} else {
				response.setError(5002, "Invalid Request ");
			}
		} catch (Exception e) {
			response.setError(e);
		}
		return response.toString();
	}

	@CrossOrigin
	@ApiOperation(value = "Fetch component master for provider-service-map-id", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/fetchComponentMaster/{psmID}" }, method = { RequestMethod.GET })
	public String fetchComponentMaster(@PathVariable("psmID") Integer psmID) {
		OutputResponse response = new OutputResponse();
		try {
			if (psmID != null & psmID > 0) {
				String s = mastersFetchingServiceImpl.getComponentMaster(psmID);
				response.setResponse(s);
			} else {
				response.setError(5002, "Invalid Request ");
			}
		} catch (Exception e) {
			response.setError(e);
		}
		return response.toString();
	}

	@CrossOrigin
	@ApiOperation(value = "Fetch procedure master for provider-service-map-id and deleted is false", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/fetchProcedureMasterDelFalse/{psmID}" }, method = { RequestMethod.GET })
	public String fetchProcedureMasterDelFalse(@PathVariable("psmID") Integer psmID) {
		OutputResponse response = new OutputResponse();
		try {
			if (psmID != null & psmID > 0) {
				String s = mastersFetchingServiceImpl.getProcedureMasterDelFalse(psmID);
				response.setResponse(s);
			} else {
				response.setError(5002, "Invalid Request ");
			}
		} catch (Exception e) {
			response.setError(e);
		}
		return response.toString();
	}

	@CrossOrigin
	@ApiOperation(value = "Fetch component master for provider-service-map-id and deleted false", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/fetchComponentMasterDelFalse/{psmID}" }, method = { RequestMethod.GET })
	public String fetchComponentMasterDelFalse(@PathVariable("psmID") Integer psmID) {
		OutputResponse response = new OutputResponse();
		try {
			if (psmID != null & psmID > 0) {
				String s = mastersFetchingServiceImpl.getComponentMasterDelFalse(psmID);
				response.setResponse(s);
			} else {
				response.setError(5002, "Invalid Request ");
			}
		} catch (Exception e) {
			response.setError(e);
		}
		return response.toString();
	}

	@CrossOrigin
	@ApiOperation(value = "Fetch procedure component mapping list for provider-service-map-id and deleted false", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/fetchprocCompMappingDelFalse/{psmID}" }, method = { RequestMethod.GET })
	public String fetchProcCompMappingDelFalse(@PathVariable("psmID") Integer psmID) {
		OutputResponse response = new OutputResponse();
		try {
			if (psmID != null & psmID > 0) {
				String s = mastersFetchingServiceImpl.getProcCompMappingDelFalse(psmID);
				response.setResponse(s);
			} else {
				response.setError(5002, "Invalid Request ");
			}
		} catch (Exception e) {
			response.setError(e);
		}
		return response.toString();
	}

	@CrossOrigin
	@ApiOperation(value = "Fetch procedure component mapping list for particular procedureID", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/fetchProcCompMappingForSingleProcedure/{pID}" }, method = { RequestMethod.GET })
	public String fetchProcCompMappingForSingleProcedure(@PathVariable("pID") Integer pID) {
		OutputResponse response = new OutputResponse();
		try {
			if (pID != null & pID > 0) {
				String s = mastersFetchingServiceImpl.getProcCompMappingForProcedureID(pID);
				response.setResponse(s);
			} else {
				response.setError(5002, "Invalid Request ");
			}
		} catch (Exception e) {
			response.setError(e);
		}
		return response.toString();
	}

	@CrossOrigin
	@ApiOperation(value = "Fetch  component details  for particular componentID", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/fetchComponentDetailsForComponentID/{cID}" }, method = { RequestMethod.GET })
	public String fetchComponentDetailsForComponentID(@PathVariable("cID") Integer cID) {
		OutputResponse response = new OutputResponse();
		try {
			if (cID != null & cID > 0) {
				String s = mastersFetchingServiceImpl.getComponentDetailsForComponentID(cID);
				if(s != null){
				response.setResponse(s);
				}else{
					response.setResponse("Component Details not found in Database.");
				}
			} else {
				response.setError(5002, "Invalid Request ");
			}
		} catch (Exception e) {
			response.setError(e);
		}
		return response.toString();
	}

}
