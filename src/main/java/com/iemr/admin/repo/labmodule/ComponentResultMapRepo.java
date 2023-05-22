package com.iemr.admin.repo.labmodule;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.iemr.admin.data.labmodule.ComponentResultMap;

/***
 * 
 * @author Rajeev Tripathi
 *
 */
@Repository
@RestResource(exported = false)
public interface ComponentResultMapRepo extends CrudRepository<ComponentResultMap, Integer> {
	@Modifying
	@Transactional
	@Query("UPDATE ComponentResultMap SET deleted = true, modifiedBy = :modifiedBy WHERE testComponentID = :testComponentID")
	public Integer deletePreviousCompResultMappingSoft(@Param("testComponentID") Integer testComponentID,
			@Param("modifiedBy") String modifiedBy);

	ArrayList<ComponentResultMap> findByTestComponentIDAndDeleted(Integer testComponentID, Boolean deleted);

}
