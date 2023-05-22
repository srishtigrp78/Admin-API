package com.iemr.admin.data.apiman;

import javax.persistence.Transient;

import com.google.gson.annotations.Expose;
import com.iemr.admin.utils.mapper.OutputMapper;

import lombok.Data;

@Data
public class ApimanClient {

//	@Expose
	private String id;
	@Expose
	private String name;
	@Expose
	private String description;
	@Expose
	private String initialVersion;
//	@Expose
	private String createdBy;

	
	@Transient
	private OutputMapper outputMapper = new OutputMapper();

	@Override
	public String toString() {
		return outputMapper.gson().toJson(this);
	}
}
