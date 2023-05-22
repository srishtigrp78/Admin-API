package com.iemr.admin.data.apiman;

import javax.persistence.Transient;

import com.google.gson.annotations.Expose;
import com.iemr.admin.utils.mapper.OutputMapper;

import lombok.Data;

@Data
public class ApimanContract {

	@Expose
	private String planId;
	@Expose
	private String apiOrgId;
	@Expose
	private String apiId;
	@Expose
	private String apiVersion;
	
	
	
	@Transient
	private OutputMapper outputMapper = new OutputMapper();

	@Override
	public String toString() {
		return outputMapper.gson().toJson(this);
	}

	public ApimanContract(){
		
	}
	
	public ApimanContract(String planId, String apiOrgId, String apiId, String apiVersion) {
		super();
		this.planId = planId;
		this.apiOrgId = apiOrgId;
		this.apiId = apiId;
		this.apiVersion = apiVersion;
	}
}
