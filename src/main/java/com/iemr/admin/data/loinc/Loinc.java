package com.iemr.admin.data.loinc;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.google.gson.annotations.Expose;

@Entity
@Table(name = "m_loinc")
public class Loinc {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	@Expose
	@Column(name = "loinc_num")
	private String lionicNum;
	
	@Expose
	@Column(name = "component")
	private String component;
	
	@Expose
	@Column(name = "system")
	private String system;
	
	@Expose
	@Column(name = "class")
	private String class1;
	
	@Expose
	@Column(name = "long_common_name")
	private String long_common_name;
	
	
	public String getLionicNum() {
		return lionicNum;
	}

	public void setLionicNum(String lionicNum) {
		this.lionicNum = lionicNum;
	}

	@Column(name = "status")
	private String status;

	@Transient
	private Integer pageNo;


	public String getComponent() {
		return component;
	}

	public void setComponent(String component) {
		this.component = component;
	}

	public String getSystem() {
		return system;
	}

	public void setSystem(String system) {
		this.system = system;
	}

	public String getClass1() {
		return class1;
	}

	public void setClass1(String class1) {
		this.class1 = class1;
	}

	public String getLong_common_name() {
		return long_common_name;
	}

	public void setLong_common_name(String long_common_name) {
		this.long_common_name = long_common_name;
	}

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}

