package com.iemr.admin.data.provideronboard;

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
@Table(name="m_instituteroutedirectory")
public class M_Instituteroutedirectory {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Expose
	@Column(name = "InstituteRouteDirectoryID")
	private Integer instituteRouteDirectoryID;
	@Expose
	@Column(name = "InstituteSubDirectoryID")
	private Integer instituteSubDirectoryID;
	@Expose
	@Column(name = "InstituteRouteDirectoryName")
	private String instituteRouteDirectoryName;
	@Expose
	@Column(name = "InstituteRouteDirectoryDesc")
	private String instituteRouteDirectoryDesc; 
	@Expose
	@Column(name = "Deleted", insertable = false, updatable = true)
	private Boolean deleted;
	@Expose
	@Column(name = "CreatedBy")
	private String createdBy;
	@Expose
	@Column(name = "CreatedDate", insertable = false, updatable = false)
	private Timestamp createdDate;
	@Expose
	@Column(name = "ModifiedBy")
	private String modifiedBy;
	@Expose
	@Column(name = "LastModDate", insertable = false, updatable = false)
	private Timestamp lastModDate;
	
	
	public M_Instituteroutedirectory() {
		// TODO Auto-generated constructor stub
	}


	public Integer getInstituteRouteDirectoryID() {
		return instituteRouteDirectoryID;
	}


	public void setInstituteRouteDirectoryID(Integer instituteRouteDirectoryID) {
		this.instituteRouteDirectoryID = instituteRouteDirectoryID;
	}


	public Integer getInstituteSubDirectoryID() {
		return instituteSubDirectoryID;
	}


	public void setInstituteSubDirectoryID(Integer instituteSubDirectoryID) {
		this.instituteSubDirectoryID = instituteSubDirectoryID;
	}


	public String getInstituteRouteDirectoryName() {
		return instituteRouteDirectoryName;
	}


	public void setInstituteRouteDirectoryName(String instituteRouteDirectoryName) {
		this.instituteRouteDirectoryName = instituteRouteDirectoryName;
	}


	public String getInstituteRouteDirectoryDesc() {
		return instituteRouteDirectoryDesc;
	}


	public void setInstituteRouteDirectoryDesc(String instituteRouteDirectoryDesc) {
		this.instituteRouteDirectoryDesc = instituteRouteDirectoryDesc;
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
