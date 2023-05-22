package com.iemr.admin.repository.provideronboard;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.admin.data.provideronboard.V_Showsubcategory;

@Repository
@RestResource(exported = false)
public interface V_ShowsubcategoryRepo extends CrudRepository<V_Showsubcategory, Integer> {
     
	
	
	 @Query("SELECT u FROM V_Showsubcategory u where u.providerServiceMapID=:providerServiceMapID AND u.subServiceID=:subServiceID ")
	ArrayList<V_Showsubcategory> getCategoryByMapIDAndSubServiceID(@Param("providerServiceMapID") Integer providerServiceMapID, @Param("subServiceID")Integer subServiceID);

	
	
	 @Query("SELECT u FROM V_Showsubcategory u where u.subCategoryID=:subCategoryID ")
	ArrayList<V_Showsubcategory> getSubCategory1(@Param("subCategoryID")Integer subCategoryID);

}
