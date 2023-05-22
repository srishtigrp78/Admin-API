package com.iemr.admin.repo.pharmacologicalcategory;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.admin.data.pharmacologicalcategory.M_Pharmacologicalcategory;

@Repository
@RestResource(exported = false)
public interface PharmacologicalcategoryRepo extends CrudRepository<M_Pharmacologicalcategory, Integer>{
   
	
	
	@Query("SELECT u FROM M_Pharmacologicalcategory u WHERE u.providerServiceMapID=:providerServiceMapID order by u.pharmCategoryName")
	ArrayList<M_Pharmacologicalcategory> getPhormacologicalData(@Param("providerServiceMapID")Integer providerServiceMapID);
   
	
	@Query("SELECT u FROM M_Pharmacologicalcategory u WHERE u.pharmacologyCategoryID=:pharmCategoryID")
	M_Pharmacologicalcategory editPhamacologicalData(@Param("pharmCategoryID")Integer pharmCategoryID);


	List<M_Pharmacologicalcategory> findByPharmCategoryCodeAndProviderServiceMapID(String pharmCategoryCode,
			Integer providerServiceMapID);

}
