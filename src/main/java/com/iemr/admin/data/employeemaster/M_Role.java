package com.iemr.admin.data.employeemaster;

import java.sql.Date;
import java.sql.Timestamp;

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
@Table(name="m_role")
public class M_Role {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Expose
	@Column(name="RoleID")
	private Integer roleID;
	@Expose
	@Column(name="RoleName")
	private String roleName;
	@Expose
	@Column(name="RoleDesc")
	private String roleDesc;
	@Expose
	@Column(name="Deleted" ,insertable=false,updatable=true)
	private Boolean deleted;
	@Expose
	@Column(name="CreatedBy")
	private String createdBy;
	@Expose
	@Column(name="CreatedDate",insertable = false, updatable = false)
	private Timestamp createdDate; 
	@Expose
	@Column(name="ModifiedBy")
	private String modifiedBy; 
	@Expose
	@Column(name="LastModDate",insertable = false, updatable = false)
	private Timestamp LastModDate;
	
	@Expose
	@Column(name="RoleFor")
	private Integer roleFor;
	
	
	@Expose
	@Column(name="ProviderServiceMapID")
	private Integer providerServiceMapID;
	
	/*@OneToOne(mappedBy="mRole")
	private M_UserServiceRoleMapping2 m_UserServiceRoleMapping;*/
	
	
	
	public M_Role() {
	}
	
	public M_Role(Integer roleID,String roleName,Integer providerServiceMapID){
		this.roleID=roleID;
		this.roleName=roleName;
		this.providerServiceMapID=providerServiceMapID;
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

	public String getRoleDesc() {
		return roleDesc;
	}

	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}




	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public Timestamp getLastModDate() {
		return LastModDate;
	}

	public void setLastModDate(Timestamp lastModDate) {
		LastModDate = lastModDate;
	}

	public Integer getProviderServiceMapID() {
		return providerServiceMapID;
	}

	public void setProviderServiceMapID(Integer providerServiceMapID) {
		this.providerServiceMapID = providerServiceMapID;
	}
	
	public Integer getRoleFor() {
		return roleFor;
	}

	public void setRoleFor(Integer roleFor) {
		this.roleFor = roleFor;
	}

	@Transient
	private OutputMapper outputMapper = new OutputMapper();

	@Override
	public String toString() {
		return outputMapper.gson().toJson(this);
	}
}
