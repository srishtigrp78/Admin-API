package com.iemr.admin.repository.uptsu;

import java.sql.Timestamp;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.admin.data.uptsu.M_FacilityMapping;
import com.mysql.jdbc.Connection;

@Repository
@RestResource(exported = false)
public interface FacilityRepository extends CrudRepository<M_FacilityMapping, Integer>{
	
	@Transactional
	@Modifying
	@Query("UPDATE M_FacilityMapping b SET b.deleted = true,"
			+ "b.lastModDate = :lastModDate,b.modifiedBy = :modifiedBy WHERE b.providerServiceMapID = :providerServiceMapID")
	Integer updatedeleteStatus(@Param("providerServiceMapID") int providerServiceMapID,
			@Param("lastModDate") Timestamp lastModDate,@Param("modifiedBy") String modifiedBy);

}
