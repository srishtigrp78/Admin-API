package com.iemr.admin.to;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Example {

	@SerializedName("callGroupType")
	@Expose
	private String callGroupType;
	
	CallType2[] callType1;
	
	private String createdBy;
	
	
	
	

	public String getCallGroupType() {
		return callGroupType;
	}

	public void setCallGroupType(String callGroupType) {
		this.callGroupType = callGroupType;
	}

	public CallType2[] getCallType1() {
		return callType1;
	}

	public void setCallType1(CallType2[] callType1) {
		this.callType1 = callType1;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
}
