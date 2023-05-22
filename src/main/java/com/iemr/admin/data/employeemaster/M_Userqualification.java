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
@Table(name="m_userqualification")
public class M_Userqualification {
	   @Id
	   @GeneratedValue(strategy = GenerationType.AUTO)
	   @Expose
	   @Column(name="QualificationID")
	   private Integer qualificationID;
	   @Expose
	   @Column(name="Name")
	   private String name;
	   @Expose
	   @Column(name="UserQualificationDesc")
	   private String userQualificationDesc; 
	   @Expose
	   @Column(name="Deleted" ,insertable=false,updatable=true)
	   private Boolean deleted;
	   @Expose
	   @Column(name="CreatedBy")
	   private String createdBy; 
	   @Expose
	   @Column(name="CreatedDate" , insertable = false, updatable = false)
	   private Timestamp createdDate;
	   @Expose
	   @Column(name="ModifiedBy")
	   private String modifiedBy;
	   @Expose
	   @Column(name="LastModDate", insertable = false, updatable = false)
	   private Timestamp lastModDate;
	   /*
	   @OneToOne(mappedBy="m_Userqualification")
		private M_User1 m_User;
	   */
	   public M_Userqualification() {
		// TODO Auto-generated constructor stub
	}

	public Integer getQualificationID() {
		return qualificationID;
	}

	public void setQualificationID(Integer qualificationID) {
		this.qualificationID = qualificationID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserQualificationDesc() {
		return userQualificationDesc;
	}

	public void setUserQualificationDesc(String userQualificationDesc) {
		this.userQualificationDesc = userQualificationDesc;
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
	
	
	

	/*public M_User1 getM_User() {
		return m_User;
	}

	public void setM_User(M_User1 m_User) {
		this.m_User = m_User;
	}*/
	     
	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public Timestamp getLastModDate() {
		return lastModDate;
	}

	public void setLastModDate(Timestamp lastModDate) {
		this.lastModDate = lastModDate;
	}




	@Transient
	private OutputMapper outputMapper = new OutputMapper();

	@Override
	public String toString() {
		return outputMapper.gson().toJson(this);
	}
	
	
	   

}
