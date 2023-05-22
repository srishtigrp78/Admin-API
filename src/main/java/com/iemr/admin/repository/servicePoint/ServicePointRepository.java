package com.iemr.admin.repository.servicePoint;

import java.util.List;
import java.util.Objects;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.admin.data.servicePoint.M_Servicepoint;

@Repository
@RestResource(exported = false)
public interface ServicePointRepository extends CrudRepository<M_Servicepoint, Integer>{
	
	@Query("SELECT sp.servicePointID, sp.servicePointName, sp.servicePointDesc, sp.servicePointHQAddress, sp.providerServiceMapID, sp.deleted, sp.countryID, "
			+ "c.countryName, sp.stateID, s.stateName, d.districtID, d.districtName, b.blockID, b.blockName, bm.districtBranchID, bm.villageName, "
			+ "sp.m_providerServiceMapping, sm.serviceID, sm.serviceName, sp.parkingPlaceID, pp.parkingPlaceName "
			+ " FROM M_Servicepoint sp "
			+ " LEFT JOIN sp.m_parkingplace pp"
			+ " LEFT JOIN sp.m_country c"
			+ " LEFT JOIN sp.state s"
			+ " LEFT JOIN sp.m_district d"
			+ " LEFT JOIN sp.districtBlock b"
			+ " LEFT JOIN sp.districtBranchMapping bm"
			+ " LEFT JOIN sp.m_providerServiceMapping p "
			+ " LEFT JOIN p.m_serviceMaster sm "
			+ " where (sp.stateID IS NULL or cast(sp.stateID as string) like :stateID) "
			+ " AND (sp.districtID IS NULL or cast(sp.districtID as string) like :districtID) "
			+ " AND (sp.parkingPlaceID IS NULL or cast(sp.parkingPlaceID as string) like :parkingPlaceID)"
			+ " AND p.serviceProviderID =:serviceProviderID order by sp.servicePointName ")
	List<Objects[]> getAvailableServicePoints(@Param("stateID")String stateID, @Param("districtID")String districtID, 
			@Param("parkingPlaceID")String parkingPlaceID, @Param("serviceProviderID")Integer serviceProviderID);

	@Transactional
	@Modifying
	@Query("update M_Servicepoint sp set sp.deleted=:deleted, sp.modifiedBy=:modifiedBy where sp.servicePointID =:servicePointID")
	int updateServicePointStatus(@Param("servicePointID")Integer servicePointID, @Param("deleted")Boolean deleted, @Param("modifiedBy")String modifiedBy);
}
