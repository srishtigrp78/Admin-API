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
@Table(name="m_gender")
public class M_Gender {
	
	@Id
	   @GeneratedValue(strategy = GenerationType.AUTO)
	   @Expose
	   @Column(name="GenderID")
	   private Integer genderID;
	   @Expose
	   @Column(name="GenderName")
	   private String  genderName;
	   @Expose
	   @Column(name="Deleted",insertable = false, updatable = true)
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
	   private Timestamp lastModDate;
	   /*
	   @OneToOne(mappedBy="m_Gender")
		private M_User1 m_User;*/
	   
	   public M_Gender() {
		// TODO Auto-generated constructor stub
	}
	   public M_Gender(Integer genderID,String genderName){
		   
		   this.genderID=genderID;
		   this.genderName=genderName;
		   
	   }
	   
	   
	   

	public Integer getGenderID() {
		return genderID;
	}

	public void setGenderID(Integer genderID) {
		this.genderID = genderID;
	}

	
	public String getGenderName() {
		return genderName;
	}




	public void setGenderName(String genderName) {
		this.genderName = genderName;
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
