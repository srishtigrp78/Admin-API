package com.iemr.admin.repository.vanType;

import java.util.List;
import java.util.Objects;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.admin.data.vanType.M_VanType;

@Repository
@RestResource(exported = false)
public interface VanTypeRepository extends CrudRepository<M_VanType, Integer>{
	
	@Query("SELECT v.vanTypeID, v.vanType, v.vanTypeDesc, v.deleted " 
			+ "from M_VanType v  where v.deleted = false")
	List<Objects[]> getVanTypes();
	
	@Transactional
	@Modifying
	@Query("update M_VanType v set v.deleted=:deleted, v.modifiedBy=:modifiedBy where v.vanTypeID =:vanTypeID")
	int updateVanTypeStatus(@Param("vanTypeID")Integer vanTypeID, @Param("deleted")Boolean deleted, @Param("modifiedBy")String modifiedBy);
}
