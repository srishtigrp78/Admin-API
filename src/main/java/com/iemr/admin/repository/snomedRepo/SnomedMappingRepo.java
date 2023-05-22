package com.iemr.admin.repository.snomedRepo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.admin.data.snomedMapping.DiseaseType;

@Repository
@RestResource(exported = false)
public interface SnomedMappingRepo extends CrudRepository<DiseaseType, Integer>{

	
	@Transactional
	@Modifying
	@Query("UPDATE DiseaseType c SET c.sctCode=:sctCode, c.sctTerm=:sctTerm, c.modifiedBy=:modifiedBy  WHERE c.masterID=:masterID")
	Integer updateFamilyHistoryDetails(@Param("masterID") Short masterID,@Param("sctCode") String sctCode, @Param("sctTerm") String sctTerm,@Param("modifiedBy") String modifiedBy);
	@Query("SELECT c from DiseaseType c")
	List<DiseaseType> fetchDiseaseType();
	@Transactional
	  @Modifying
	@Query("update DiseaseType u set u.deleted=:deleted, u.modifiedBy=:modifiedBy where u.masterID =:masterID")
	int updateStatus(@Param("masterID")Short masterID, @Param("deleted")Boolean deleted, @Param("modifiedBy")String modifiedBy);

}
