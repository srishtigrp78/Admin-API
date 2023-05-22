package com.iemr.admin.data.labmodule;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.gson.annotations.Expose;
import com.iemr.admin.utils.mapper.OutputMapper;

import lombok.Data;

@Entity
@Data
@Table(name = "m_iotprocedure")
public class IOTProcedure {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Expose
	@Column(name = "IOTProcedureID")
	private Integer iotProcedureID;
	
	@Expose
	@Column(name = "ProcedureName")
	private String procedureName;
	
	@Expose
	@Column(name = "ProcedureCode")
	private String procedureCode;
	
	@Expose
	@Column(name = "ProcedureStartAPI")
	private String procedureStartAPI;
	
	@Expose
	@Column(name = "ProcedureEndAPI")
	private String procedureEndAPI;
	
	@Expose
	@Column(name = "ProcedureStatusAPI")
	private String procedureStatusAPI;
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
	@Column(name = "CalibrationCode")
	private String calibrationCode;
	@Expose
	@Column(name = "isLabProcedure")
	private Boolean isLabProcedure;
	
	@Expose
	@Column(name = "DiscoveryCode")
	private String discoveryCode;
	
	@Expose
	@Column(name = "Deleted")
	private Boolean deleted;
	
	@Expose
	@Column(name = "Processed")
	private String processed;
	
	@Expose
	@Column(name = "CreatedBy")
	private String createdBy;
	
	@Expose
	@Column(name = "CreatedDate")
	private Timestamp createdDate;
	
	@Expose
	@Column(name = "ModifiedBy")
	private String modifiedBy;
	
	@Expose
	@Column(name = "LastModDate")
	private Timestamp lastModDate;
	
	private static OutputMapper outputMapper = new OutputMapper();

	@Override
	public String toString() {
		return outputMapper.gson().toJson(this);
	}
	
	
	
}
