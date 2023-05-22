package com.iemr.admin.service.telemedicine;

import java.util.List;

import com.iemr.admin.data.telemedicine.M_UserTemp;
import com.iemr.admin.data.telemedicine.SwymedDomain;
import com.iemr.admin.data.telemedicine.UserSwymed;
import com.iemr.admin.utils.exception.SwyMedException;

public interface SwymedInter {

	List<M_UserTemp> getunmappedUser(Integer serviceproviderID, Integer designationID);

	UserSwymed createUser(UserSwymed userSwymed) throws SwyMedException;

	List<UserSwymed> fetchmappedUser(Integer serviceproviderID);

	UserSwymed editUser(UserSwymed userSwymed) throws SwyMedException;

	UserSwymed deleteUser(Long userSwymedMapID, Boolean deletedflag, String modifiedBy) throws SwyMedException;

	List<SwymedDomain> getdomain(Integer serviceproviderID);


}
