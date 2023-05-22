
package com.iemr.admin.repository.provideronboard;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.admin.data.provideronboard.M_104druggroup;
import com.iemr.admin.data.provideronboard.M_104drugmaster;
import com.iemr.admin.data.provideronboard.M_ProviderServiceMapping;

@Repository
@RestResource(exported = false)
public interface DrugGroupRepo extends CrudRepository<M_104druggroup, Integer>{


	@Query("SELECT g.drugGroupID,g.drugGroup,g.drugGroupDesc,g.deleted,g.serviceProviderID "
			+ " FROM M_104druggroup g "
			+ "where  (g.drugGroupID IS NULL or cast(g.drugGroupID as string) like %:drugGroupID%)"
			+ " AND (g.serviceProviderID IS NULL or cast(g.serviceProviderID as string) like %:serviceProviderID%)")
	List<Objects[]> getAllDrugGroups(@Param("drugGroupID")String drugGroupID, @Param("serviceProviderID") String serviceProviderID);
    
	
	@Query("SELECT g.drugGroupID,g.drugGroup,g.drugGroupDesc,g.deleted,g.serviceProviderID "
			+ " FROM M_104druggroup g "
			+ " where  g.deleted = false"
			+ " AND (g.serviceProviderID IS NULL or cast(g.serviceProviderID as string) like %:serviceProviderID%)")
	List<Objects[]> getValidDrugGroups(@Param("serviceProviderID") String serviceProviderID);
	
	@Transactional
	@Modifying
	@Query("update M_104druggroup u set u.deleted=:deleted, u.modifiedBy=:modifiedBy where u.drugGroupID =:drugGroupID")
	int updateStatus(@Param("drugGroupID")Integer drugGroupID, @Param("deleted")Boolean deleted, @Param("modifiedBy")String modifiedBy);
	
	
	@Query("SELECT u FROM M_104druggroup u where u.drugGroupID =:drugGroupID")
	M_104druggroup getDrugGroupById(@Param("drugGroupID")Integer drugGroupID);
}
