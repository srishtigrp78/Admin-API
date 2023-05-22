package com.iemr.admin.repository.villageMaster;

import java.util.List;
import java.util.Objects;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.admin.data.locationmaster.DistrictBranchMapping;

@Repository
@RestResource(exported = false)
public interface VillageMasterRepository extends CrudRepository<DistrictBranchMapping, Integer>{
	
	@Query("SELECT d.districtBranchID, d.blockID, b.blockName, d.panchayatName, d.villageName, d.habitat, d.pinCode, d.govVillageID, d.govSubDistrictID,"
			+ " d.deleted, d.isRural "
			+ " FROM DistrictBranchMapping d "
			+ " INNER JOIN d.districtBlock b"
			+ " where d.blockID=:blockID ORDER By d.villageName ")
	List<Objects[]> getAvailableVillages(@Param("blockID") Integer blockID);
	
	@Transactional
	@Modifying
	@Query("update DistrictBranchMapping m set m.deleted=:deleted, m.modifiedBy=:modifiedBy where m.districtBranchID =:districtBranchID")
	int updateVillageStatus(@Param("districtBranchID")Integer districtBranchID, @Param("deleted")Boolean deleted, @Param("modifiedBy")String modifiedBy);
	
	@Transactional
	@Modifying
	@Query("update DistrictBranchMapping m set m.panchayatName=:panchayatName, m.villageName=:villageName, m.habitat=:habitat, m.pinCode=:pinCode, "
			+ "m.govVillageID=:govVillageID, m.govSubDistrictID=:govSubDistrictID, m.modifiedBy=:modifiedBy,m.isRural=:isRural where m.districtBranchID =:districtBranchID")
	
	int updateVillageData( @Param("panchayatName")String panchayatName, @Param("villageName")String villageName, @Param("habitat")String habitat, 
			@Param("pinCode")String pinCode, @Param("govVillageID")Integer govVillageID, @Param("govSubDistrictID")Integer govSubDistrictID, 
			@Param("districtBranchID")Integer districtBranchID, @Param("modifiedBy")String modifiedBy, @Param("isRural")Boolean isRural);
	
	
	
}
