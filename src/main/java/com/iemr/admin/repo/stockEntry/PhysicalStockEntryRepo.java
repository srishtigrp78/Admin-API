package com.iemr.admin.repo.stockEntry;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.admin.data.stockentry.PhysicalStockEntry;

@Repository
@RestResource(exported = false)
public interface PhysicalStockEntryRepo  extends CrudRepository<PhysicalStockEntry, Integer> {
	
	@Transactional
	@Modifying
	@Query("UPDATE PhysicalStockEntry c SET c.deleted = :bool WHERE c.phyEntryID = :id")
	Integer updateDelete(@Param("id")Integer id,@Param("bool")Boolean bool);

}
