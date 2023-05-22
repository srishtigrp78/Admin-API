package com.iemr.admin.repo.fetosensemaster;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.admin.data.fetosensemaster.FetosenseDeviceID;

@Repository
@RestResource(exported = false)
public interface FetosenseDeviceIDRepo extends CrudRepository<FetosenseDeviceID, Integer>  {

	/***
	 * @author DU20091017
	 * @param providerServiceMapID
	 * @return
	 */
	@Query("SELECT f FROM FetosenseDeviceID f WHERE f.providerServiceMapID = :providerServiceMapID ")
	public ArrayList<FetosenseDeviceID> getFetoseneDeviceID(@Param("providerServiceMapID") Integer providerServiceMapID);
	
	/***
	 * @author DU20091017
	 * @param providerServiceMapID
	 * @return
	 */
	@Query("SELECT f FROM FetosenseDeviceID f WHERE f.providerServiceMapID = :providerServiceMapID AND f.deleted = false "
			+ "AND (f.vanID is null OR f.deactivated = true)")
	public ArrayList<FetosenseDeviceID> getFetoseneDeviceIDNotMapped(@Param("providerServiceMapID") Integer providerServiceMapID);
	
	/***
	 * @author DU20091017
	 * @param vanID
	 * @param deviceID
	 * @return
	 */
	@Transactional
	@Modifying
	@Query("UPDATE FetosenseDeviceID f SET f.vanID = :vanID,f.vanTypeID = :vanTypeID,f.parkingPlaceID = :parkingPlaceID "
			+ " ,f.vanName = :vanName,f.deactivated = false,f.modifiedBy = :modifiedBy WHERE f.deviceID = :deviceID")
	public int createMappingOfVanIDAndDeviceID(@Param("vanID") Integer vanID,@Param("vanTypeID") Integer vanTypeID,
			@Param("parkingPlaceID") Integer parkingPlaceID,@Param("vanName") String vanName,@Param("modifiedBy") String modifiedBy,
			@Param("deviceID") String deviceID);
	
	/***
	 * @author DU20091017
	 * @param vanTypeID
	 * @param parkingPlaceID
	 * @param providerServiceMapID
	 * @return
	 */
	@Query("SELECT f FROM FetosenseDeviceID f WHERE f.vanTypeID = :vanTypeID AND f.parkingPlaceID = :parkingPlaceID "
			+ " AND f.providerServiceMapID = :providerServiceMapID ")
	public ArrayList<FetosenseDeviceID> getMappedWorklist(@Param("vanTypeID") Integer vanTypeID,
			@Param("parkingPlaceID") Integer parkingPlaceID,@Param("providerServiceMapID") Integer providerServiceMapID);
	
	/***
	 * @author DU20091017
	 * @param VfdID
	 * @return
	 */
	@Transactional
	@Modifying
	@Query("UPDATE FetosenseDeviceID f SET f.vanID = null,f.parkingPlaceID = null,f.vanTypeID = null,f.vanName = null,f.deactivated = false "
			+ " WHERE f.VfdID = :VfdID")
	public int updateVanDetailsToNull(@Param("VfdID") Long VfdID);
	
	@Transactional
	@Modifying
	@Query("UPDATE FetosenseDeviceID f SET f.deactivated = :deactivated WHERE f.VfdID = :VfdID")
	public int deleteMapping(@Param("deactivated") Boolean deactivated,@Param("VfdID") Long VfdID);
	
	
	@Query("SELECT count(f.VfdID) FROM FetosenseDeviceID f WHERE f.vanID = :vanID AND f.deactivated = false ")
	public int getMappedVanDetails(@Param("vanID") Integer vanID);
	
}
