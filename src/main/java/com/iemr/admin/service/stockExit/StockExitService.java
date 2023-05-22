package com.iemr.admin.service.stockExit;

import java.util.List;

import com.iemr.admin.data.stockExit.ItemStockExit;
import com.iemr.admin.data.stockExit.T_PatientIssue;
import com.iemr.admin.data.stockentry.ItemStockEntry;

public interface StockExitService {

	Integer issuePatientDrugs(T_PatientIssue patientIssue);
	
	Integer saveItemExit(List<ItemStockExit> itemissueListUpdated, Integer issueID, String issueType);
	
	List<ItemStockExit> getItemStockAndValidate(List<ItemStockExit> itemissueList, Integer facilityID,
			String createdBy);
	
//	 List<ItemStockEntry> getItemStockFromItemID(Integer facilityID,List<ItemStockExit> itemStockExit);
	 
	 
}
