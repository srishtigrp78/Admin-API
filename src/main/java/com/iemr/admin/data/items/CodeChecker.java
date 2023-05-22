package com.iemr.admin.data.items;

import javax.persistence.Transient;

import com.google.gson.annotations.Expose;
import com.iemr.admin.utils.mapper.OutputMapper;

import lombok.Data;

@Data
public class CodeChecker {

	@Expose
	private String name;
	
	@Expose
	private String code;
	
	@Expose
	private Integer providerServiceMapID;
	
	
	@Transient
	private OutputMapper outputMapper = new OutputMapper();

	@Override
	public String toString() {
		return outputMapper.gson().toJson(this);
	}
}
