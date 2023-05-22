package com.iemr.admin.repo.locationmaster;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.admin.data.locationmaster.DistrictBlock;
import com.iemr.admin.data.locationmaster.DistrictBranchMapping;

@Repository
@RestResource(exported = false)
public interface DistrictBranchMappingRepo extends CrudRepository<DistrictBranchMapping, Integer>{

	@Query("select db from DistrictBranchMapping db where db.districtBranchID not in (:branchid) and db.blockID=:talukid and db.deleted=false")
	List<DistrictBranchMapping> getunmappedvillage(@Param("branchid") List<Integer> intids,@Param("talukid") Integer distID);

	@Query("select db from DistrictBranchMapping db where db.blockID=:talukid and db.deleted=false")
	List<DistrictBranchMapping> getallvillage(@Param("talukid")Integer districtBlockID);


	

	
}
