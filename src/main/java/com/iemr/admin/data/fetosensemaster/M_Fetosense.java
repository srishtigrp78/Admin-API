package com.iemr.admin.data.fetosensemaster;

import java.sql.Timestamp;
import java.util.ArrayList;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import com.google.gson.annotations.Expose;

@Entity
@Table(name = "m_fetosensetests")
public class M_Fetosense {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Expose
	@Column(name = "fetosensetestid")
	private Integer fetosenseTestID;
	@Expose
	@Column(name = "TestName")
	private String testName;
	@Expose
	@Column(name = "TestDesc")
	private String testDesc;
	@Expose
	@Column(name = "Deleted", insertable = false, updatable = true)
	private Boolean deleted;
	@Expose
	@Column(name = "Processed", insertable = false)
	private String processed;
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
	@Expose
	@Column(name = "ProviderServiceMapID")
	private Integer providerServiceMapID;
	
	public Integer getFetosenseTestID() {
		return fetosenseTestID;
	}
	public void setFetosenseTestID(Integer fetosenseTestID) {
		this.fetosenseTestID = fetosenseTestID;
	}
	public String getTestName() {
		return testName;
	}
	public void setTestName(String testName) {
		this.testName = testName;
	}
	public String getTestDesc() {
		return testDesc;
	}
	public void setTestDesc(String testDesc) {
		this.testDesc = testDesc;
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
	public Timestamp getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}
	public String getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	public Timestamp getLastModDate() {
		return lastModDate;
	}
	public void setLastModDate(Timestamp lastModDate) {
		this.lastModDate = lastModDate;
	}
	public Integer getProviderServiceMapID() {
		return providerServiceMapID;
	}
	public void setProviderServiceMapID(Integer providerServiceMapID) {
		this.providerServiceMapID = providerServiceMapID;
	}
	
	public M_Fetosense() {
		
	}
	
	public M_Fetosense(Integer fetosenseTestID, String testName, String testDesc, 
			Integer providerServiceMapID, Boolean deleted, String processed, String createdBy,
			Timestamp createdDate, String modifiedBy, Timestamp lastModDate) {
		super();
		this.fetosenseTestID = fetosenseTestID;
		this.testName = testName;
		this.testDesc = testDesc;
		this.providerServiceMapID = providerServiceMapID;
		this.deleted = deleted;
		this.processed = processed;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.modifiedBy = modifiedBy;
		this.lastModDate = lastModDate;
	}
	
	public static M_Fetosense getFetosenseTestsMaster(ArrayList<Object[]> obj) {
		if (obj != null && obj.size() > 0) {
			Object[] obj1 = obj.get(0);
			M_Fetosense tmpOBJ = new M_Fetosense((Integer) obj1[0], (String) obj1[1], (String) obj1[2],
					(Integer) obj1[3], (Boolean) obj1[4], (String) obj1[5],
					(String) obj1[6], (Timestamp) obj1[7], (String) obj1[8], (Timestamp) obj1[9]);
			return tmpOBJ;
		} else {
			return null;
		}
	}
}
