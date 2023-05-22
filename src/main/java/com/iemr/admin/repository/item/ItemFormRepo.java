package com.iemr.admin.repository.item;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.admin.data.items.M_ItemForm;


@Repository
@RestResource(exported = false)
public interface ItemFormRepo extends CrudRepository<M_ItemForm, Integer> {
	
	@Query("select u from M_ItemForm u")
	List<M_ItemForm> getAll();
	
//	List<M_ItemForm> findByDeletedOrderByItemForm(Boolean deleted);
	
	List<M_ItemForm> findByProviderServiceMapIDOrderByItemForm(Integer providerServiceMapID);
	
	@Transactional
	@Modifying
	@Query("UPDATE M_ItemForm c SET c.itemFormDesc = :itemFormDesc, c.ModifiedBy = :modifiedBy WHERE c.itemFormID = :itemFormID")
	Integer updateItemFormDetails(@Param("itemFormID") Integer itemFormID,
			@Param("itemFormDesc") String itemFormDesc, @Param("modifiedBy") String modifiedBy);

	@Transactional
	@Modifying
	@Query("UPDATE M_ItemForm c SET c.deleted = :flag, c.ModifiedBy = :modifiedBy WHERE c.itemFormID = :itemFormID")
	Integer blockItemForm(@Param("itemFormID") Integer itemFormID, @Param("flag") Boolean flag,
			@Param("modifiedBy") String modifiedBy);

	List<M_ItemForm> findByItemFormCodeAndProviderServiceMapID(String itemFormCode, Integer providerServiceMapID);


}
