package com.iemr.admin.service.stockEntry;

import java.util.List;

import com.iemr.admin.data.stockExit.ItemStockExit;
import com.iemr.admin.data.stockentry.ItemStockEntry;
import com.iemr.admin.data.stockentry.PhysicalStockEntry;

public interface StockEntryService {

	PhysicalStockEntry savePhysicalStockEntry(PhysicalStockEntry physicalStockEntry);

	List<ItemStockEntry> getItemBatchForStoreID(ItemStockEntry itemStockEntry);
	
	List<Object[]> getAllItemBatchForStoreID(Integer storeID,Integer[] itemStockID);

	Integer updateStocks(List<ItemStockExit> itemissueListUpdated);
	
	List<ItemStockEntry> getItemStockForStoreIDOrderByEntryDateAsc(Integer facilityID,Integer itemID);
	
	List<ItemStockEntry> getItemStockForStoreIDOrderByEntryDateDesc(Integer facilityID,Integer itemID);
	
	List<ItemStockEntry> getItemStockForStoreIDOrderByExpiryDate(Integer facilityID,Integer itemID);
	
	List<ItemStockEntry> getItemStockFromItemID(Integer facilityID,List<ItemStockExit> itemStockExitList);
}
