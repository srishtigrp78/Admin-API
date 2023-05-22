package com.iemr.admin.service.rolemaster;

import java.util.ArrayList;
import java.util.List;

import com.iemr.admin.data.rolemaster.M_Role;
import com.iemr.admin.data.rolemaster.M_Role104;
import com.iemr.admin.data.rolemaster.M_Screen;
import com.iemr.admin.data.rolemaster.M_UserservicerolemappingForRoleProviderAdmin;
import com.iemr.admin.data.rolemaster.RoleScreenMapping;
import com.iemr.admin.data.rolemaster.StateServiceMapping;

public interface Role_MasterInter {

	ArrayList<StateServiceMapping> getStateByServiceProviderId(Integer serviceProviderID);

	ArrayList<StateServiceMapping> getServiceByServiceProviderIdAndStateId(Integer serviceProviderID, Integer stateID);

	List<M_Role> getAllRoleByMapId();

	ArrayList<StateServiceMapping> getAllByMapId(Integer serviceProviderID, Integer stateID, Integer serviceID,Boolean isNational);

	public ArrayList<M_Role> getProStateServRoles(int pssmID);

	public List<M_Role> addRole(List<M_Role> mRole);

	public M_Role getRoleByRoleId(Integer roleID);

	public M_Role  modifydata(M_Role editdata);

	public String deletedata(M_Role deleteData);

	ArrayList<M_Screen> getAllFeature(Integer serviceID);

	List<RoleScreenMapping> mapScreen(RoleScreenMapping mRoles2);

	String settingScreenId(Integer sRSMappingID, Integer screenID);
	
	public ArrayList<M_Role> getProStateServRoles1(int pssmID);

	List<RoleScreenMapping> mapfeature(List<RoleScreenMapping> mRoles3);

	ArrayList<M_UserservicerolemappingForRoleProviderAdmin> getServiceByServiceProviderIds(Integer userID);

	ArrayList<M_UserservicerolemappingForRoleProviderAdmin> getStateByServiceProviderIdAndServiceLines(Integer userID,
			Integer serviceID,Boolean isNational);

	ArrayList<StateServiceMapping> getAllByMapId(Integer serviceProviderID, Integer serviceID);

	ArrayList<M_Role> getProStateServRolesV1(int pssmID);

	List<M_Role> getRoleMasterTM(Integer providerServiceMapID);

	ArrayList<M_Role> getProStateServRolesActive(Integer providerServiceMapID);

	M_Role configWrapUpTime(M_Role role) throws Exception;


	


}
