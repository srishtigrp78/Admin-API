package com.iemr.admin.data.apiman;

import javax.persistence.Transient;

import com.google.gson.annotations.Expose;
import com.iemr.admin.utils.mapper.OutputMapper;

import lombok.Data;

@Data
public class ApimanRegister {

	@Expose
	private String type;
	@Expose
	private String entityId;
	@Expose
	private String entityVersion;
	@Expose
	private String organizationId;

	
	@Transient
	private OutputMapper outputMapper = new OutputMapper();

	@Override
	public String toString() {
		return outputMapper.gson().toJson(this);
	}
}
