package com.iemr.admin.repo.locationmaster;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.admin.data.locationmaster.DistrictBlock;

@Repository
@RestResource(exported = false)
public interface DistrictBlockRepo extends CrudRepository<DistrictBlock, Integer>{

	@Query("select db from DistrictBlock db where db.blockID not in (:blockid) and db.districtID=:districtID and db.deleted=false")
	List<DistrictBlock> findunmapped(@Param("blockid") List<Integer> intids,@Param("districtID") Integer distID);

	@Query("select db from DistrictBlock db where  db.districtID=:districtID and db.deleted=false")
	List<DistrictBlock> findall(@Param("districtID")Integer districtID);
	

	
}
