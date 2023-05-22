package com.iemr.admin.data.emailconfig;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.google.gson.annotations.Expose;
import com.iemr.admin.data.employeemaster.M_Designation;
import com.iemr.admin.data.employeemaster.M_ProviderServiceMap1;
import com.iemr.admin.data.locationmaster.DistrictBlock;
import com.iemr.admin.data.locationmaster.DistrictBranchMapping;
import com.iemr.admin.data.locationmaster.M_District;
import com.iemr.admin.data.locationmaster.State;
import com.iemr.admin.utils.mapper.OutputMapper;

import lombok.Data;

@Data
@Entity(name = "m_AuthorityEmail")
public class AuthorityEmail
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Expose
	@Column(name = "AuthorityEmailID")
	private Integer authorityEmailID;
	// @Column(name = "InstitutionTypeID", insertable = true, updatable = false)
	// private Integer institutionTypeID;
	// @JoinColumn(name = "institutionTypeID", insertable=false, updatable=false)
	// @OneToOne(fetch = FetchType.EAGER)
	// private M_Institutiontype instituteType;
	@Column(name = "StateID", insertable = true, updatable = false)
	private Integer stateID;
	@JoinColumn(name = "stateID", insertable = false, updatable = false)
	@OneToOne(fetch = FetchType.EAGER)
	private State state;
	@Column(name = "DistrictID", insertable = true, updatable = false)
	private Integer districtID;
	@JoinColumn(name = "districtID", insertable = false, updatable = false)
	@OneToOne(fetch = FetchType.EAGER)
	private M_District district;
	@Column(name = "BlockID", insertable = true, updatable = false)
	private Integer blockID;
	@JoinColumn(name = "blockID", insertable = false, updatable = false)
	@OneToOne(fetch = FetchType.EAGER)
	private DistrictBlock districtBlock;
	@Column(name = "DistrictBranchMappingID", insertable = true, updatable = false)
	private Integer districtBranchMappingID;
	@JoinColumn(name = "districtBranchMappingID", insertable = false, updatable = false)
	@OneToOne(fetch = FetchType.EAGER)
	private DistrictBranchMapping districtBranch;

	@Column(name = "DesignationID", insertable = true, updatable = true)
	private Integer designationID;
	@JoinColumn(name = "designationID", insertable = false, updatable = false)
	@OneToOne(fetch = FetchType.EAGER)
	private M_Designation designation;
	@Column(name = "AuthorityName", insertable = true, updatable = true)
	private String authorityName;
	@Column(name = "EmailID", insertable = true, updatable = true)
	private String emailID;
	@Column(name = "ContactNo", insertable = true, updatable = true)
	private String contactNo;
	@Column(name = "ProviderServiceMapID", insertable = true, updatable = false)
	private Integer providerServiceMapID;
	@JoinColumn(name = "providerServiceMapID", insertable = false, updatable = false)
	@OneToOne(fetch = FetchType.EAGER)
	private M_ProviderServiceMap1 providerService;
	@Column(name = "mobileno", insertable = true, updatable = true)
	private String mobileNo;
	@Column(name = "Deleted", insertable = false, updatable = true)
	private Boolean deleted;
	@Column(name = "Processed", insertable = false, updatable = false)
	private String processed;
	@Column(name = "CreatedBy", insertable = true, updatable = false)
	private String createdBy;
	@Column(name = "CreatedDate", insertable = false, updatable = false)
	private Timestamp createdDate;
	@Column(name = "ModifiedBy", insertable = false, updatable = true)
	private String modifiedBy;
	@Column(name = "LastModDate", insertable = false, updatable = false)
	private Timestamp lastModDate;
	

	@Override
	public String toString()
	{
		String output = OutputMapper.gson().toJson(this);
		return output;
	}
}
