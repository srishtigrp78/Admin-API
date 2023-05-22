package com.iemr.admin.repository.vanMaster;

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

import com.iemr.admin.data.parkingPlace.M_Parkingplace;
import com.iemr.admin.data.vanMaster.M_Van;

@Repository
@RestResource(exported = false)
public interface VanMasterRepository extends CrudRepository<M_Van, Integer>{
	

//	
//	@Query("SELECT v.vanID, v.vanName, v.vehicalNo, v.vanTypeID, vt.vanType, v.deleted, v.providerServiceMapID, v.countryID, "
//			+ "c.countryName, v.stateID, s.stateName, v.districtID, d.districtName, v.parkingPlaceID, pp.parkingPlaceName,pp.districtBlockID "
//			+ " FROM M_Van v "
//			+ " LEFT JOIN v.m_vanType vt "
//			+ " LEFT JOIN v.m_parkingplace pp"
//			+ " LEFT JOIN v.m_country c"
//			+ " LEFT JOIN v.state s"
//			+ " LEFT JOIN v.m_district d"
//			+ " LEFT JOIN v.m_providerServiceMapping p "
//			+ " where (v.districtID IS NULL or cast(v.districtID as string) like :districtID) "
//			+ " AND (v.parkingPlaceID IS NULL or cast(v.parkingPlaceID as string) like :parkingPlaceID)"
//			+ " AND (v.vanTypeID IS NULL or cast(v.vanTypeID as string) like :vanTypeID) "
//			+ " AND p.providerServiceMapID =:providerServiceMapID")
//	List<Objects[]> getAvailableVans(@Param("districtID")String districtID, 
//			@Param("parkingPlaceID")String parkingPlaceID, @Param("vanTypeID")String vanTypeID,@Param("providerServiceMapID") Integer providerServiceMapID);

	@Transactional
	@Modifying
	@Query("update M_Van v set v.deleted=:deleted, v.modifiedBy=:modifiedBy where v.vanID =:vanID")
	int updateVanStatus(@Param("vanID")Integer vanID, @Param("deleted")Boolean deleted, @Param("modifiedBy")String modifiedBy);
	
	
	@Query("SELECT v FROM M_Van v where v.vanID =:vanID")
	M_Van getVanById(@Param("vanID")Integer vanID);
	
	@Transactional
	@Modifying
	@Query("update M_Van pp set pp.facilityID=:facilityID, pp.isFacility=:deleted, pp.modifiedBy=:modifiedBy where pp.vanID =:vanID")
	Integer updateVanMap(@Param("vanID")Integer vanID,@Param("facilityID")Integer facilityID,@Param("modifiedBy")String modifiedBy,@Param("deleted")Boolean deleted);
	
	
	List<M_Van> findByProviderServiceMapIDAndParkingPlaceID(Integer providerServiceMapID,Integer pp);
	
	List<M_Van> findByParkingPlaceIDAndFacilityIDIsNotNull(Integer pp);
	
	List<M_Van> findByFacilityIDAndDeleted(Integer fac,Boolean delete);
	
	@Query("SELECT v.vanID, v.vanName, v.vehicalNo, v.vanTypeID, vt.vanType, v.deleted, v.providerServiceMapID, v.countryID, "
			+ "c.countryName, v.stateID, s.stateName, v.parkingPlaceID, pp.parkingPlaceName,pp.districtBlockID,v.swymedDomain,v.swymedID,v.swymedEmail,v.vanSpokeMapped "
			+ " FROM M_Van v "
			+ " LEFT JOIN v.m_vanType vt "
			+ " LEFT JOIN v.m_parkingplace pp"
			+ " LEFT JOIN v.m_country c"
			+ " LEFT JOIN v.state s"
			+ " LEFT JOIN v.m_providerServiceMapping p "
			+ " where (v.parkingPlaceID IS NULL or cast(v.parkingPlaceID as string) like :parkingPlaceID)"
			+ " AND (v.vanTypeID IS NULL or cast(v.vanTypeID as string) like :vanTypeID) "
			+ " AND p.providerServiceMapID =:providerServiceMapID")
	List<Objects[]> getAvailableVans(@Param("parkingPlaceID")String parkingPlaceID, @Param("vanTypeID")String vanTypeID,@Param("providerServiceMapID") Integer providerServiceMapID);

	/***
	 * 
	 * @param vanID
	 * @param deleted
	 * @param modifiedBy
	 * @return
	 */
	@Transactional
	@Modifying
	@Query("update M_Van v set v.vanSpokeMapped=:vanSpokeMapped, v.modifiedBy=:modifiedBy where v.vanID =:vanID")
	int updateVanSpokeMapping(@Param("vanID")Integer vanID, @Param("vanSpokeMapped")Boolean vanSpokeMapped, @Param("modifiedBy")String modifiedBy);
//	
//	@Query("SELECT v.vanID, v.vanName, v.vehicalNo, v.vanTypeID, vt.vanType, v.deleted, v.providerServiceMapID, v.countryID, "
//			+ "c.countryName, v.stateID, s.stateName, v.parkingPlaceID, pp.parkingPlaceName,pp.districtBlockID,v.swymedDomain,v.swymedID,v.swymedEmail "
//			+ " FROM M_Van v "
//			+ " LEFT JOIN v.m_vanType vt "
//			+ " LEFT JOIN v.m_parkingplace pp"
//			+ " LEFT JOIN v.m_country c"
//			+ " LEFT JOIN v.state s"
//			+ " LEFT JOIN v.m_providerServiceMapping p "
//			+ " where (v.parkingPlaceID IS NULL or cast(v.parkingPlaceID as string) like :parkingPlaceID)"
//			+ " AND (v.vanTypeID IS NULL or cast(v.vanTypeID as string) like :vanTypeID) "
//			+ " AND p.providerServiceMapID =:providerServiceMapID and v.vanSpokeMapped is false")
//	List<Objects[]> getNonMappedAvailableVans(@Param("parkingPlaceID")String parkingPlaceID, @Param("vanTypeID")String vanTypeID,@Param("providerServiceMapID") Integer providerServiceMapID);

	/***
	 * @author DU20091017
	 * @param vanfetosenseIDmapped
	 * @param vanID
	 * @return
	 * created to update the van and fetosenseDeviceID mapping 
	 */
	@Modifying
	@Transactional
	@Query("UPDATE M_Van mv SET mv.vanfetosenseIDmapped = :vanfetosenseIDmapped WHERE mv.vanID = :vanID ")
	public int updateVanFetosenesmapping(@Param("vanfetosenseIDmapped") Boolean vanfetosenseIDmapped, @Param("vanID") Integer vanID);
	
	/***
	 * @author DU20091017
	 * @param providerServiceMapID
	 * @return
	 */
	@Query("Select mv.vanID, mv.vehicalNo,mv.vanName from M_Van mv WHERE mv.providerServiceMapID = :providerServiceMapID "
			+ " and mv.vanTypeID = :vanTypeID and mv.parkingPlaceID = :parkingPlaceID and mv.vanfetosenseIDmapped = false")
	public ArrayList<Object[]> getVanIDNotMappedWithDevice(@Param("vanTypeID") Integer vanTypeID,
			@Param("parkingPlaceID") Integer parkingPlaceID,@Param("providerServiceMapID") Integer providerServiceMapID);
	
}
