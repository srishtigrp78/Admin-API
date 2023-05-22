package com.iemr.admin.model.provider;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class ProviderServiceMapModelResponse
{
	private Integer providerServiceMapID;
	private Integer serviceProviderID;
	private Integer serviceID;
	private Integer countryID;
	private Integer stateID;
	private Integer districtID;
	private Integer cityID;
	private Integer districtBlockID;
	private String address;
	private Integer statusID;
	private Timestamp validFrom;
	private Timestamp validTill;
	private Boolean deleted;
}