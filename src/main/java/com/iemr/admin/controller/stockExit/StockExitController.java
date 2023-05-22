package com.iemr.admin.controller.stockExit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iemr.admin.data.stockExit.T_PatientIssue;
import com.iemr.admin.service.stockExit.StockExitService;
import com.iemr.admin.utils.response.OutputResponse;

import io.swagger.annotations.ApiOperation;

@RestController
public class StockExitController {

	@Autowired
	StockExitService stockExitService;
	
	@CrossOrigin()
	@ApiOperation(
			value = "Stores service point Details",
			consumes = "application/json",
			produces = "application/json")
	@RequestMapping(value =  "/patientIssue" ,headers = "Authorization", method = { RequestMethod.POST })
	public String patientIssue(@RequestBody T_PatientIssue patientIssue)  {
		
			OutputResponse output = new OutputResponse();

					
			
			try {
				
				Integer value=stockExitService.issuePatientDrugs(patientIssue);
				if(value==1){
					output.setResponse("Successfully Created");
				}else{
					output.setResponse("Error in Quantity");
				}
//				output.setResponse("");
			} catch (Exception e) {
				
				output.setError(e);
			}
			return output.toString();
	}
}
