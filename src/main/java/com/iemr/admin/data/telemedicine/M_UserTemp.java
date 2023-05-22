package com.iemr.admin.data.telemedicine;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.google.gson.annotations.Expose;
import com.iemr.admin.data.employeemaster.M_Designation;
import com.iemr.admin.utils.mapper.OutputMapper;

import lombok.Data;

@Data
@Entity
@Table(name = "M_User")
public class M_UserTemp {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Expose
	@Column(name = "UserID")
	private Long userID;
	private Integer TitleID;
	@Expose
	private String FirstName;
	@Expose
	private String MiddleName;
	@Expose
	private String LastName;
	private Integer GenderID;
	private Integer MaritalStatusID;
	private String AadhaarNo;
	private String PAN;
	private Timestamp DOB;
	private Timestamp DOJ;
	private Integer QualificationID;
	@Expose
	@Column(name = "UserName")
	private String UserName;
	@Expose
	private String EmailID;
	private Integer StatusID;
	private String EmergencyContactPerson;
	private String EmergencyContactNo;
	private Boolean IsSupervisor;
	@Expose
	@Column(name = "DesignationID")
	private Integer designationID;
	@Expose
	@Column(name = "ServiceProviderID")
	private Integer ServiceProviderID;
	@Expose
	@Column(name = "Deleted", insertable = false, updatable = false)
	private Boolean Deleted;
	private String CreatedBy;
	@Column(name = "CreatedDate", insertable = false, updatable = false)
	private Timestamp CreatedDate;
	private String ModifiedBy;
	@Column(name = "LastModDate", insertable = false, updatable = false)
	private Timestamp LastModDate;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "UserID", insertable = false, updatable = false)
	@Expose
	private UserSwymed userSwymed;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DesignationID", insertable = false, updatable = false)
	@Expose
	private M_Designation designation;

	@Transient
	private OutputMapper outputMapper = new OutputMapper();

	@Transient
	@Expose
	private Long userSwymedMapID;

	@Override
	public String toString() {
		return outputMapper.gson().toJson(this);
	}

	public M_UserTemp() {

	}

	public M_UserTemp(M_UserTemp user, Long userSwymedMapID) {
		this.userID = user.userID;
		this.FirstName = user.FirstName;
		this.LastName = user.LastName;
		this.UserName = user.UserName;
		this.EmailID = user.EmailID;
		this.designationID = user.designationID;
		this.ServiceProviderID = user.ServiceProviderID;
		this.Deleted = user.Deleted;
		this.userSwymedMapID = userSwymedMapID;
	}
}
