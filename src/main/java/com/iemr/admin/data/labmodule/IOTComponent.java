package com.iemr.admin.data.labmodule;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.google.gson.annotations.Expose;
import com.iemr.admin.utils.mapper.OutputMapper;

import lombok.Data;
@Entity
@Data
@Table(name = "m_iotcomponent")
public class IOTComponent {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Expose
	@Column(name = "IOTComponentId")
	private Integer iotComponentID;
	
	@Expose
	@Column(name = "ComponentName")
	private String componentName;
	
	@Expose
	@Column(name = "ComponentCode")
	private String componentCode;
	
	@Expose
	@Column(name = "IOTProcedureID")
	private Integer iotProcedureID;
	
	@Expose
	@Column(name = "ComponentUnit")
	private String componentUnit;
	
	@Expose
	@Column(name = "InputType")
	private String inputType;
	
	@Expose
	@Column(name = "IsDecimal")
	private Boolean isDecimal;
	
	@Expose
	@Column(name = "Options")
	@Convert(converter = StringListConverter.class)
	private List<String> options;
	
	
	
	
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
