package com.iemr.admin.repository.item;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.admin.data.items.M_Route;

@Repository
@RestResource(exported = false)
public interface RouteRepo extends CrudRepository<M_Route, Integer> {
	
	@Query("select u from M_Route u")
	List<M_Route> getAll();
	
	List<M_Route> findByDeletedOrderByRouteName(Boolean deleted);
	
	List<M_Route> findByProviderServiceMapIDOrderByRouteName(Integer providerServiceMapID);

	@Transactional
	@Modifying
	@Query("UPDATE M_Route c SET c.routeDesc = :routeDesc, c.modifiedBy = :modifiedBy WHERE c.routeID = :routeID")
	Integer updateRouteDetails(@Param("routeID") Integer routeID,
			@Param("routeDesc") String routeDesc, @Param("modifiedBy") String modifiedBy);

	@Transactional
	@Modifying
	@Query("UPDATE M_Route c SET c.deleted = :flag, c.modifiedBy = :modifiedBy WHERE c.routeID = :routeID")
	Integer blockRoute(@Param("routeID") Integer routeID, @Param("flag") Boolean flag,
			@Param("modifiedBy") String modifiedBy);

	List<M_Route> findByRouteCodeAndProviderServiceMapID(String routeCode, Integer providerServiceMapID);

}
