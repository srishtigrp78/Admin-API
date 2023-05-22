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

import com.iemr.admin.data.locationmaster.DistrictBranchMapping;
import com.iemr.admin.data.provideronboard.M_ProviderServiceMapping;
import com.iemr.admin.data.servicePoint.M_Servicepointvillagemap;

@Repository
@RestResource(exported = false)
public interface ServicePointVillageMapRepository extends CrudRepository<M_Servicepointvillagemap, Integer>{


	@Query("SELECT sp.servicePointVillageMapID, st.stateID, st.stateName, d.districtID, d.districtName, s.parkingPlaceID, pp.parkingPlaceName, sp.servicePointID, "
			+ " s.servicePointName, sp.districtBranchID, bm.villageName, sp.providerServiceMapID, sp.deleted, sp.m_servicepoint,sp.districtBranchMapping,db.districtID,db.blockName"
			+ " FROM M_Servicepointvillagemap sp "
			+ " LEFT JOIN sp.m_servicepoint s"
			+ " LEFT JOIN sp.m_providerServiceMapping p "
			+ " LEFT JOIN sp.districtBranchMapping bm"
			+ " LEFT JOIN bm.districtBlock db"
			+ " LEFT JOIN db.state st"
			+ " LEFT JOIN db.district d"
			+ " LEFT JOIN s.m_parkingplace pp"
		
			+ " where (st.stateID IS NULL or cast(st.stateID as string) like :stateID) AND (d.districtID IS NULL or cast(d.districtID as string) like :districtID)"
			+ " AND (s.parkingPlaceID IS NULL or cast(s.parkingPlaceID as string) like :parkingPlaceID) AND "
			+ " (s.servicePointID IS NULL or cast(s.servicePointID as string) like :servicePointID) AND p.serviceProviderID =:serviceProviderID")
	List<Objects[]> getAvailableServicePointVillageMaps(@Param("stateID")String stateID, @Param("districtID")String districtID, 
			@Param("parkingPlaceID")String parkingPlaceID, @Param("servicePointID")String servicePointID,
			@Param("serviceProviderID")Integer serviceProviderID);
	
	
	@Transactional
	@Modifying
	@Query("update M_Servicepointvillagemap sp set sp.deleted=:deleted, sp.modifiedBy=:modifiedBy where sp.servicePointVillageMapID =:servicePointVillageMapID")
	int updateServicePointStatus(@Param("servicePointVillageMapID")Integer servicePointVillageMapID, @Param("deleted")Boolean deleted, @Param("modifiedBy")String modifiedBy);


	@Query("SELECT u.districtBranchID FROM M_Servicepointvillagemap u where   u.providerServiceMapID=:sid and u.deleted=false")
	List<Integer> finbyTalukID(@Param("sid") Integer providerServiceMapID);
	
}
