package com.iemr.admin.repository.item;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.admin.data.items.M_ItemCategory;

@Repository
@RestResource(exported = false)
public interface ItemCategoryRepo extends CrudRepository<M_ItemCategory, Integer> {
//	OrderByItemCategoryName
	List<M_ItemCategory> findByDeletedAndProviderServiceMapIDOrderByItemCategoryName(Boolean deleted, Integer providerServiceMapID);

	List<M_ItemCategory> findByProviderServiceMapIDOrderByItemCategoryName(Integer providerServiceMapID);

	@Transactional
	@Modifying
	@Query("UPDATE M_ItemCategory c SET c.issueType = :issuetype WHERE c.itemCategoryID = :id")
	Integer updateIssueConfig(@Param("id") Integer id, @Param("issuetype") String issuetype);

	@Transactional
	@Modifying
	@Query("UPDATE M_ItemCategory c SET c.itemCategoryDesc = :itemCategoryDesc, c.modifiedBy = :modifiedBy WHERE c.itemCategoryID = :itemCategoryID")
	Integer updateItemCategoryDetails(@Param("itemCategoryID") Integer itemCategoryID,
			@Param("itemCategoryDesc") String itemCategoryDesc, @Param("modifiedBy") String modifiedBy);

	@Transactional
	@Modifying
	@Query("UPDATE M_ItemCategory c SET c.deleted = :flag , c.modifiedBy = :modifiedBy WHERE c.itemCategoryID = :itemCategoryID")
	Integer blockItemCategory(@Param("itemCategoryID") Integer itemCategoryID, @Param("flag") Boolean flag,
			@Param("modifiedBy") String modifiedBy);

	List<M_ItemCategory> findByItemCategoryCodeAndProviderServiceMapID(String itemCategoryCode,
			Integer providerServiceMapID);

	@Transactional
	@Modifying
	@Query("UPDATE M_ItemCategory c SET c.alertBeforeDays = :alertBeforeDays WHERE c.itemCategoryID = :id")
	Integer updateExpiryAlert(@Param("id") Integer id, @Param("alertBeforeDays") Integer alertBeforeDays);
}
