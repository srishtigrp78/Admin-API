package com.iemr.admin.repository.provideronboard;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.admin.data.provideronboard.M_Subcategory;


@Repository
@RestResource(exported = false)
public interface SubCategoryRepo extends CrudRepository<M_Subcategory, Integer>{
     
	
	@Query("SELECT u FROM M_Subcategory u where deleted=0")
	ArrayList<M_Subcategory> getCategory();
     
	
	@Query("SELECT u FROM M_Subcategory u where u.subCategoryID =:subCategoryID")
	M_Subcategory getSubCategory(@Param("subCategoryID")Integer subCategoryID);

	@Query("SELECT u FROM M_Subcategory u where u.categoryID=:categoryID AND deleted=0")
	ArrayList<M_Subcategory> getCategory(@Param("categoryID")Integer categoryID);

}
