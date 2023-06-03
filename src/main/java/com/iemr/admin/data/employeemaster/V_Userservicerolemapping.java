package com.iemr.admin.data.employeemaster;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.google.gson.annotations.Expose;
import com.iemr.admin.utils.mapper.OutputMapper;

@Entity
@Table(name="v_userservicerolemapping")
public class V_Userservicerolemapping {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Expose
	@Column(name="uSRMappingID")
	private Integer uSRMappingID;
	
	@Expose
	@Column(name="UserID")
	private Integer userID;
	@Expose
    @Column(name="Name")
	private String name;
	@Expose
	@Column(name="UserName")
	private String userName; 
	@Expose
	@Column(name="ServiceID")
	private Integer serviceID;
	@Expose
	@Column(name="ServiceName")
	private String serviceName;
	@Expose
	@Column(name="StateID")
	private Integer stateID;
	@Expose
	@Column(name="StateName")
	private String  stateName;
	@Expose
	@Column(name="WorkingDistrictID")
	private String workingDistrictID;
	@Expose
	@Column(name="WorkingDistrictName")
	private String workingDistrictName;
	@Expose
	@Column(name="WorkingLocationID")
	private String workingLocationID;
	@Expose
	@Column(name="LocationName")
	private String locationName;
	@Expose
	@Column(name="WorkingLocationAddress")
	private String workingLocationAddress;
	@Expose
	@Column(name="RoleID")
	private Integer roleID;
	@Expose
	@Column(name="RoleName")
	private String roleName;
	@Expose
	@Column(name="AgentID")
	private String agentID;
	@Expose
	@Column(name="PSMStatusID")
	private Integer pSMStatusID;
	@Expose
	@Column(name="PSMStatus")
	private String pSMStatus;
	@Expose
	@Column(name="UserServciceRoleDeleted")
	private Boolean userServciceRoleDeleted;
	@Expose
	@Column(name="UserDeleted")
	private Boolean userDeleted;
	@Expose
	@Column(name="ServiceProviderDeleted")
	private Boolean serviceProviderDeleted;
	@Expose
	@Column(name="RoleDeleted")
	private Boolean roleDeleted;
	@Expose
	@Column(name="ProviderServiceMappingDeleted")
	private Boolean providerServiceMappingDeleted;
	

	
	@Expose
	@Column(name="ProviderServiceMapID")
	private Integer providerServiceMapID;
	
    @Expose
	@Column(name="ServiceProviderID")
	private Integer serviceProviderID;
    
    @Expose
	@Column(name="isInbound")
	private Boolean inbound;
    
    @Expose
	@Column(name="isOutbound")
	private Boolean outbound;
	   
	   
	   
	   
	
	
	public Integer getProviderServiceMapID() {
		return providerServiceMapID;
	}

	public void setProviderServiceMapID(Integer providerServiceMapID) {
		this.providerServiceMapID = providerServiceMapID;
	}

	public V_Userservicerolemapping() {
		// TODO Auto-generated constructor stub
	}
	
	public Integer getuSRMappingID() {
		return uSRMappingID;
	}

	public void setuSRMappingID(Integer uSRMappingID) {
		this.uSRMappingID = uSRMappingID;
	}

	public Integer getUserID() {
		return userID;
	}

	public void setUserID(Integer userID) {
		this.userID = userID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getServiceID() {
		return serviceID;
	}

	public void setServiceID(Integer serviceID) {
		this.serviceID = serviceID;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public Integer getStateID() {
		return stateID;
	}

	public void setStateID(Integer stateID) {
		this.stateID = stateID;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public String getWorkingDistrictID() {
		return workingDistrictID;
	}

	public void setWorkingDistrictID(String workingDistrictID) {
		this.workingDistrictID = workingDistrictID;
	}

	public String getWorkingDistrictName() {
		return workingDistrictName;
	}

	public void setWorkingDistrictName(String workingDistrictName) {
		this.workingDistrictName = workingDistrictName;
	}

	public String getWorkingLocationID() {
		return workingLocationID;
	}

	public void setWorkingLocationID(String workingLocationID) {
		this.workingLocationID = workingLocationID;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public String getWorkingLocationAddress() {
		return workingLocationAddress;
	}

	public void setWorkingLocationAddress(String workingLocationAddress) {
		this.workingLocationAddress = workingLocationAddress;
	}

	public Integer getRoleID() {
		return roleID;
	}

	public void setRoleID(Integer roleID) {
		this.roleID = roleID;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getAgentID() {
		return agentID;
	}

	public void setAgentID(String agentID) {
		this.agentID = agentID;
	}

	public Integer getpSMStatusID() {
		return pSMStatusID;
	}

	public void setpSMStatusID(Integer pSMStatusID) {
		this.pSMStatusID = pSMStatusID;
	}

	public String getpSMStatus() {
		return pSMStatus;
	}

	public void setpSMStatus(String pSMStatus) {
		this.pSMStatus = pSMStatus;
	}

	public Boolean getUserServciceRoleDeleted() {
		return userServciceRoleDeleted;
	}

	public void setUserServciceRoleDeleted(Boolean userServciceRoleDeleted) {
		this.userServciceRoleDeleted = userServciceRoleDeleted;
	}

	public Boolean getUserDeleted() {
		return userDeleted;
	}

	public void setUserDeleted(Boolean userDeleted) {
		this.userDeleted = userDeleted;
	}

	public Boolean getServiceProviderDeleted() {
		return serviceProviderDeleted;
	}

	public void setServiceProviderDeleted(Boolean serviceProviderDeleted) {
		this.serviceProviderDeleted = serviceProviderDeleted;
	}

	public Boolean getRoleDeleted() {
		return roleDeleted;
	}

	public void setRoleDeleted(Boolean roleDeleted) {
		this.roleDeleted = roleDeleted;
	}

	public Boolean getProviderServiceMappingDeleted() {
		return providerServiceMappingDeleted;
	}

	public void setProviderServiceMappingDeleted(Boolean providerServiceMappingDeleted) {
		this.providerServiceMappingDeleted = providerServiceMappingDeleted;
	}
	
	
	
	
	
	

	public Integer getServiceProviderID() {
		return serviceProviderID;
	}

	public void setServiceProviderID(Integer serviceProviderID) {
		this.serviceProviderID = serviceProviderID;
	}
	
	
	public Boolean getInbound() {
		return inbound;
	}

	public void setInbound(Boolean inbound) {
		this.inbound = inbound;
	}

	public Boolean getOutbound() {
		return outbound;
	}

	public void setOutbound(Boolean outbound) {
		this.outbound = outbound;
	}

	@Transient
	private OutputMapper outputMapper = new OutputMapper();

	@Override
	public String toString() {
		return outputMapper.gson().toJson(this);
	}
	
}