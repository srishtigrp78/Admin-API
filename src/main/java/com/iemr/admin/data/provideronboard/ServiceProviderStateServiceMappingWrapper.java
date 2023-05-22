package com.iemr.admin.data.provideronboard;

import java.util.ArrayList;
import java.util.Map;

import com.google.gson.annotations.Expose;

public class ServiceProviderStateServiceMappingWrapper {

	@Expose
	private ArrayList<Map<String, Object>> stateAndServiceMapList;

	public ServiceProviderStateServiceMappingWrapper() {

	}

	public ServiceProviderStateServiceMappingWrapper(ArrayList<Map<String, Object>> stateAndServiceMapList) {
		super();
		this.stateAndServiceMapList = stateAndServiceMapList;
	}

	public ArrayList<Map<String, Object>> getStateAndServiceMapList() {
		return stateAndServiceMapList;
	}

	public void setStateAndServiceMapList(ArrayList<Map<String, Object>> stateAndServiceMapList) {
		this.stateAndServiceMapList = stateAndServiceMapList;
	}

}
