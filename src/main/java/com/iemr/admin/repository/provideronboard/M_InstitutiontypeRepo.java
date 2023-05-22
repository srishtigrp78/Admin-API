package com.iemr.admin.repository.provideronboard;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.admin.data.provideronboard.M_Institutiontype;

@Repository
@RestResource(exported = false)
public interface M_InstitutiontypeRepo extends CrudRepository<M_Institutiontype, Integer> {

	@Query("SELECT u FROM M_Institutiontype u where u.providerServiceMapID=:providerServiceMapID")
	ArrayList<M_Institutiontype> getInstuteType(@Param("providerServiceMapID") Integer providerServiceMapID);

	@Query("SELECT u FROM M_Institutiontype u where u.institutionTypeID=:institutionTypeID")
	M_Institutiontype editdata(@Param("institutionTypeID") Integer institutionTypeID);

	/*
	 * Created BY Du20091017
	 */
	@Query("SELECT u FROM M_Institutiontype u where u.providerServiceMapID=:providerServiceMapID AND u.districtId=:districtId")
	ArrayList<M_Institutiontype> getInstuteTypeByDist(@Param("providerServiceMapID") Integer providerServiceMapID,
			@Param("districtId") Integer districtId);

	@Query("SELECT u FROM M_Institutiontype u where u.providerServiceMapID=:providerServiceMapID AND u.districtId=:districtId AND u.subDistrictId=:subDistrictId")
	ArrayList<M_Institutiontype> getInstutionTypeByBlock(@Param("providerServiceMapID") Integer providerServiceMapID,
			@Param("districtId") Integer districtId, @Param("subDistrictId") Integer subDistrictId);

	@Query("SELECT u FROM M_Institutiontype u where u.providerServiceMapID=:providerServiceMapID AND u.districtId=:districtId AND u.villageId=:villageId")
	ArrayList<M_Institutiontype> getInstutionTypeByVillage(@Param("providerServiceMapID") Integer providerServiceMapID,
			@Param("districtId") Integer districtId, @Param("villageId") Integer villageId);

	@Query("SELECT u FROM M_Institutiontype u where u.providerServiceMapID=:providerServiceMapID AND u.districtId=:districtId AND u.subDistrictId=:subDistrictId AND u.villageId=:villageId")
	ArrayList<M_Institutiontype> getInstutionByBlockAndVillage(
			@Param("providerServiceMapID") Integer providerServiceMapID, @Param("districtId") Integer districtId,
			@Param("subDistrictId") Integer subDistrictId, @Param("villageId") Integer villageId);

}
