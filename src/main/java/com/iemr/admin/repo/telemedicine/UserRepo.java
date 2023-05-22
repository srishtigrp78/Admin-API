package com.iemr.admin.repo.telemedicine;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.admin.data.telemedicine.M_UserTemp;

@Repository
@RestResource(exported = false)
public interface UserRepo extends CrudRepository<M_UserTemp, Long> {

	/** Get the list of users for supervisor or tc specialist or doctor in TM service line
	 for that provider not providerservicemapid
	 **/
	@Query(value = "select * from m_user usr "
			+ "join m_userservicerolemapping usrm on usrm.UserID=usr.UserID "
			+ "join m_role role on role.RoleID=usrm.RoleID "
			+ "join m_servicerolescreenmapping srm on srm.RoleID=usrm.RoleID "
			+ "join m_screen scrn on scrn.ScreenID=srm.ScreenID "
			+ "where usr.ServiceProviderID=:serviceproviderID and scrn.ServiceID=4 "
			+ " and scrn.ScreenName=:screenName group by usr.UserID ", nativeQuery = true)
	ArrayList<M_UserTemp> getUserTM(@Param("serviceproviderID")Integer serviceproviderID,@Param("screenName") String screenName);

	@Query("select new M_UserTemp( u,swy.userSwymedMapID) from M_UserTemp u left join u.userSwymed swy where swy.userSwymedMapID is null "
			+ " and u.ServiceProviderID=:serviceproviderID and u.designationID=:designationID and u.Deleted=false")
	ArrayList<M_UserTemp> getunmappedSwymedUser(@Param("serviceproviderID")Integer serviceproviderID,@Param("designationID")Integer designationID);
}
