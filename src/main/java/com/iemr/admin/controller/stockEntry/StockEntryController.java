package com.iemr.admin.controller.stockEntry;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iemr.admin.data.stockExit.ItemStockExit;
import com.iemr.admin.data.stockentry.ItemStockEntry;
import com.iemr.admin.data.stockentry.PhysicalStockEntry;
import com.iemr.admin.service.stockEntry.StockEntryService;
import com.iemr.admin.utils.response.OutputResponse;

import io.swagger.annotations.ApiOperation;

@RestController
public class StockEntryController {
	private Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());

	@Autowired
	StockEntryService stockEntryService;
	
	@CrossOrigin()
	@ApiOperation(
			value = "Stores service point Details",
			consumes = "application/json",
			produces = "application/json")
	@RequestMapping(value =  "/physicalStockEntry" ,headers = "Authorization", method = { RequestMethod.POST })
	public String physicalStockEntry(@RequestBody PhysicalStockEntry physicalStockEntry)  {
		
			OutputResponse output = new OutputResponse();

					
			
			try {
				physicalStockEntry=stockEntryService.savePhysicalStockEntry(physicalStockEntry);
				
				output.setResponse(physicalStockEntry.toString());
			} catch (Exception e) {
				
				output.setError(e);
			}
			return output.toString();
	}
	
	@CrossOrigin()
	@RequestMapping(value = "/getItemBatchForStoreID", headers = "Authorization", method = {
			RequestMethod.POST }, produces = { "application/json" })
	public String getItemBatchForStoreID(@RequestBody ItemStockEntry itemStockEntry) {

		OutputResponse response = new OutputResponse();

		try {

			List<ItemStockEntry> getData = stockEntryService.getItemBatchForStoreID(itemStockEntry);

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
	@RequestMapping(value = "/allocateStockFromItemID/{facilityID}", headers = "Authorization", method = {
			RequestMethod.POST }, produces = { "application/json" })
	public String allocateStockFromItemID(@PathVariable("facilityID") Integer facilityID,@RequestBody List<ItemStockExit> itemStockExitList) {

		OutputResponse response = new OutputResponse();

		try {

			List<ItemStockEntry> getData = stockEntryService.getItemStockFromItemID(facilityID, itemStockExitList);

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
	
}
