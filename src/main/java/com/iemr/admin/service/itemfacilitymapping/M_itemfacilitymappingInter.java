package com.iemr.admin.service.itemfacilitymapping;

import java.util.ArrayList;
import java.util.List;

import com.iemr.admin.data.itemfacilitymapping.M_itemfacilitymapping;
import com.iemr.admin.data.itemfacilitymapping.V_fetchItemFacilityMap;
import com.iemr.admin.data.items.ItemInStore;

public interface M_itemfacilitymappingInter{

	ArrayList<M_itemfacilitymapping> mapItemtoStore(List<M_itemfacilitymapping> resList);

	M_itemfacilitymapping editdata(Integer itemStoreMapID);

	M_itemfacilitymapping saveEditedItem(M_itemfacilitymapping getdataforedit);

	ArrayList<M_itemfacilitymapping> getsubitemforsubStote(Integer providerServiceMapID, Integer facilityID);

	ArrayList<V_fetchItemFacilityMap> getAllFacilityMappedData(Integer providerServiceMapID);
	
	List<ItemInStore> getItemMastersFromStoreID(Integer storeID);

	Integer deleteItemStoreMapping(M_itemfacilitymapping storeID);

}
