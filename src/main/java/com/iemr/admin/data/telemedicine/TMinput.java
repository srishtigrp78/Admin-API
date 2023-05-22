package com.iemr.admin.data.telemedicine;

import javax.persistence.Transient;

import com.google.gson.annotations.Expose;
import com.iemr.admin.utils.mapper.OutputMapper;

import lombok.Data;

@Data
public class TMinput {
	
	@Expose
	private Integer serviceproviderID;
	
	@Expose
	private String screenName;
	
		
	@Transient
	private OutputMapper outputMapper = new OutputMapper();

	@Override
	public String toString() {
		return outputMapper.gson().toJson(this);
	}
	
	

}
