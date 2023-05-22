package com.iemr.admin.data.calibration;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.gson.annotations.Expose;
@Entity
@Table(name="m_calibration")
public class Calibration {
	
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		@Expose
		@Column(name="calibrationID")
		private Long calibrationID;
		
		
		@Expose
		@Column(name="ProviderServiceMapID")
		private Integer providerServiceMapID;
		@Expose
		@Column(name = "CalibrationStartAPI")
		private String calibrationStartAPI;
		@Expose
		@Column(name = "CalibrationStatusAPI")
		private String calibrationStatusAPI;
		@Expose
		@Column(name = "CalibrationEndAPI")
		private String calibrationEndAPI;
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

		public Long getCalibrationID() {
			return calibrationID;
		}

		public void setCalibrationID(Long calibrationID) {
			this.calibrationID = calibrationID;
		}

		public Integer getProviderServiceMapID() {
			return providerServiceMapID;
		}

		public void setProviderServiceMapID(Integer providerServiceMapID) {
			this.providerServiceMapID = providerServiceMapID;
		}

		public String getCalibrationStartAPI() {
			return calibrationStartAPI;
		}

		public void setCalibrationStartAPI(String calibrationStartAPI) {
			this.calibrationStartAPI = calibrationStartAPI;
		}

		public String getCalibrationStatusAPI() {
			return calibrationStatusAPI;
		}

		public void setCalibrationStatusAPI(String calibrationStatusAPI) {
			this.calibrationStatusAPI = calibrationStatusAPI;
		}

		public String getCalibrationEndAPI() {
			return calibrationEndAPI;
		}

		public void setCalibrationEndAPI(String calibrationEndAPI) {
			this.calibrationEndAPI = calibrationEndAPI;
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

}
