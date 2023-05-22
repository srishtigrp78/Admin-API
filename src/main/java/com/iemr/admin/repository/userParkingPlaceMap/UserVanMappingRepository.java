package com.iemr.admin.repository.userParkingPlaceMap;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.admin.data.userParkingPlaceMap.M_UserVanMapping;

@Repository
@RestResource(exported = false)
public interface UserVanMappingRepository extends CrudRepository<M_UserVanMapping, Integer> {

	@Transactional
	@Modifying
	@Query("update M_UserVanMapping m set m.deleted=true,m.modifiedBy=:modifiedby where m.userParkingPlaceMapID=:userParkingPlaceMapID ")
	void deactivatebyuserparkingplaceid(@Param("userParkingPlaceMapID") Integer userParkingPlaceMapID,
			@Param("modifiedby") String modifiedBy);

	@Query("select u as vanName from M_UserVanMapping u join FETCH  u.van van where u.userParkingPlaceMapID=:userParkingPlacesID and u.deleted=false and van.deleted=false ")
	List<M_UserVanMapping> findByUserParkingPlaceMapIDAndDeleted(@Param("userParkingPlacesID")Integer userParkingPlacesID);

	@Transactional
	@Modifying
	@Query("update M_UserVanMapping m set m.deleted=true,m.modifiedBy=:modifiedby where m.userVanMapID=:userVanMapID ")
	void deleteUservanMap(@Param("userVanMapID") Integer userVanMapID,
			@Param("modifiedby") String modifiedBy);
}
