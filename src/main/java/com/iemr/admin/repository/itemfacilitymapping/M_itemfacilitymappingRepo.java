package com.iemr.admin.repository.itemfacilitymapping;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.admin.data.itemfacilitymapping.M_itemfacilitymapping;

@Repository
@RestResource(exported = false)
public interface M_itemfacilitymappingRepo extends CrudRepository<M_itemfacilitymapping, Integer>{
	
	 @Query("SELECT distinct mi.itemID,"
             + " imfm.itemName as itemName, "
             + " imfm.discontinued as discontinued,"
             + " imfm.itemCategoryID as itemCategoryID "
             + " FROM M_itemfacilitymapping mi "
             + " JOIN mi.itemMasterforFacilityMapping imfm  "
             + " WHERE mi.providerServiceMapID =:providerServiceMapID AND mi.facilityID=:facilityID AND mi.deleted=0 AND imfm.deleted=0 ORDER BY imfm.itemName ")
	ArrayList<Object[]> getItemforSubstore(@Param("providerServiceMapID")Integer providerServiceMapID,@Param("facilityID") Integer facilityID);
	
	@Query("SELECT distinct mi.itemID,"
			  + " imfm.itemName as itemName "
			  + " FROM M_itemfacilitymapping mi "
			  + " JOIN mi.itemMasterforFacilityMapping imfm  "
			  + " WHERE mi.facilityID=:facilityID AND mi.deleted=0 AND imfm.deleted=0 ORDER BY imfm.itemName ")
	ArrayList<Object[]> getItemforStore(@Param("facilityID") Integer facilityID);
	
	@Transactional
	@Modifying
	@Query("UPDATE M_itemfacilitymapping c SET c.deleted = :deleted WHERE c.itemFacilityMapID = :mapID")
	Integer updateDeleteMap(@Param("mapID") Integer mapID,@Param("deleted") Boolean deleted);
	
	
}
