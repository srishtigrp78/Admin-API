package com.iemr.admin.data.rolemaster;

import javax.persistence.Transient;

import com.google.gson.annotations.Expose;
import com.iemr.admin.utils.mapper.OutputMapper;

import lombok.Data;

@Data
public class UserRole {
	@Expose
	private Integer UserID;
	@Expose
	private Integer roleID;
	@Expose
	private String rolename;
	@Expose
	private Boolean roleDeleted;
	@Expose
	private Integer screenID;
	@Expose
	private String screenName;
	@Expose
	private Boolean screenDeleted;
	
	@Transient
	private OutputMapper outputMapper = new OutputMapper();

	@Override
	public String toString() {
		return outputMapper.gson().toJson(this);
	}

	public UserRole(){
		
	}
	
	public UserRole(Integer userID, Integer roleID, String rolename, Boolean roleDeleted, Integer screenID, String screenName,
			Boolean screenDeleted) {
		super();
		UserID = userID;
		this.roleID = roleID;
		this.rolename = rolename;
		this.roleDeleted = roleDeleted;
		this.screenID = screenID;
		this.screenName = screenName;
		this.screenDeleted = screenDeleted;
	}
	
	
}
