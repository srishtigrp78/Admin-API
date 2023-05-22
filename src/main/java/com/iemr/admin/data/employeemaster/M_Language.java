package com.iemr.admin.data.employeemaster;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.google.gson.annotations.Expose;
import com.iemr.admin.utils.mapper.OutputMapper;

@Entity
@Table(name="m_Language")
public class M_Language {
	
	   @Id
	   @GeneratedValue(strategy = GenerationType.AUTO)
	   @Expose
	   @Column(name="LanguageID")
	   private Integer languageID; 
	   @Expose
	   @Column(name="LanguageName")
	   private String languageName;
	   @Expose
	   @Column(name="LanguageDesc")
	   private String languageDesc;
	   @Expose
	   @Column(name="PropertyFilePath")
	   private String propertyFilePath;
	   @Expose
	   @Column(name="IVRFilePath")
	   private String iVRFilePath;
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
	   
	   @OneToOne(mappedBy="m_Language")
		private M_UserLangMapping m_UserLangMapping;
	   
	   @OneToOne(mappedBy="m_Language1")
		private M_UserLangMapping m_UserLangMapping1;
	   
	   
	   
	   public M_Language() {
		// TODO Auto-generated constructor stub
	}



	public Integer getLanguageID() {
		return languageID;
	}



	public void setLanguageID(Integer languageID) {
		this.languageID = languageID;
	}



	public String getLanguageName() {
		return languageName;
	}



	public void setLanguageName(String languageName) {
		this.languageName = languageName;
	}



	public String getLanguageDesc() {
		return languageDesc;
	}



	public void setLanguageDesc(String languageDesc) {
		this.languageDesc = languageDesc;
	}



	public String getPropertyFilePath() {
		return propertyFilePath;
	}



	public void setPropertyFilePath(String propertyFilePath) {
		this.propertyFilePath = propertyFilePath;
	}



	public String getiVRFilePath() {
		return iVRFilePath;
	}



	public void setiVRFilePath(String iVRFilePath) {
		this.iVRFilePath = iVRFilePath;
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



	public M_UserLangMapping getM_UserLangMapping() {
		return m_UserLangMapping;
	}



	public void setM_UserLangMapping(M_UserLangMapping m_UserLangMapping) {
		this.m_UserLangMapping = m_UserLangMapping;
	}
	
	
	
	

	
	public M_UserLangMapping getM_UserLangMapping1() {
		return m_UserLangMapping1;
	}



	public void setM_UserLangMapping1(M_UserLangMapping m_UserLangMapping1) {
		this.m_UserLangMapping1 = m_UserLangMapping1;
	}






	@Transient
	private OutputMapper outputMapper = new OutputMapper();

	@Override
	public String toString() {
		return outputMapper.gson().toJson(this);
	}
	   
	   
}
