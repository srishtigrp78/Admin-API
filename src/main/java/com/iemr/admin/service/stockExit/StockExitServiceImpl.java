package com.iemr.admin.service.stockExit;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iemr.admin.data.items.ItemMaster;
import com.iemr.admin.data.stockExit.ItemStockExit;
import com.iemr.admin.data.stockExit.T_PatientIssue;
import com.iemr.admin.data.stockentry.ItemStockEntry;
import com.iemr.admin.repo.stockExit.ItemStockExitRepo;
import com.iemr.admin.repo.stockExit.PatientIssueRepo;
import com.iemr.admin.service.item.ItemService;
import com.iemr.admin.service.stockEntry.StockEntryService;

@Service
public class StockExitServiceImpl implements StockExitService {

	@Autowired
	StockEntryService stockEntryService;

	@Autowired
	ItemStockExitRepo itemStockExitRepo;

	@Autowired
	PatientIssueRepo patientIssueRepo;
	
	@Autowired
	ItemService itemService;

	@Override
	public Integer issuePatientDrugs(T_PatientIssue patientIssue) {
		// TODO Auto-generated method stub
		Integer returnvalue = 0;
		if (patientIssue.getIssueType().equalsIgnoreCase("Manual")) {

			List<ItemStockExit> itemissueList = patientIssue.getItemStockExit();

			List<ItemStockExit> itemissueListUpdated = getItemStockAndValidate(itemissueList,
					patientIssue.getFacilityID(), patientIssue.getCreatedBy());
			// This is for save prescription
			if (itemissueList.size() == itemissueListUpdated.size()) {
				T_PatientIssue updatedPatientIssue = patientIssueRepo.save(patientIssue);

				returnvalue = saveItemExit(itemissueListUpdated, updatedPatientIssue.getPatientIssueID(),
						"PatientIssue");
			}

		}

		return returnvalue;
	}

	public Integer saveItemExit(List<ItemStockExit> itemissueListUpdated, Integer issueID, String issueType) {
		Integer i = 0;
		for (ItemStockExit action : itemissueListUpdated) {
			action.setExitType(issueType);
			action.setExitTypeID(issueID);
		}
		itemStockExitRepo.save(itemissueListUpdated);
		stockEntryService.updateStocks(itemissueListUpdated);
		i = 1;
		return i;
	}

	public List<ItemStockExit> getItemStockAndValidate(List<ItemStockExit> itemissueList, Integer facilityID,
			String createdBy) {
		Map<Integer, ItemStockExit> result = itemissueList.stream()
				.collect(Collectors.toMap(ItemStockExit::getItemStockEntryID, Function.identity()));

		Integer[] itemstockIDs = result.keySet().toArray(new Integer[itemissueList.size()]);

		List<Object[]> stockInHand = stockEntryService.getAllItemBatchForStoreID(facilityID, itemstockIDs);

		List<ItemStockExit> itemissueListUpdated = new ArrayList<ItemStockExit>();

		Boolean stockAvailibilty = true;
		// Validating stock in hand matches required count
		for (Object[] action : stockInHand) {
			ItemStockExit itemIssueUpdating = result.get(action[1]);
			itemIssueUpdating.setQuantityInHand(((Integer) action[3]));
			itemIssueUpdating.setCreatedBy(createdBy);

			if (itemIssueUpdating.getQuantity() <= itemIssueUpdating.getQuantityInHand()) {
				itemissueListUpdated.add(itemIssueUpdating);
			}
		}

		return itemissueListUpdated;
	}

	
}
