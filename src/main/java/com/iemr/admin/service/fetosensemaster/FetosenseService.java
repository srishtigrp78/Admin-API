package com.iemr.admin.service.fetosensemaster;

import java.util.ArrayList;

import com.iemr.admin.data.fetosensemaster.FetosenseDeviceID;
import com.iemr.admin.utils.exception.IEMRException;


public interface FetosenseService {

	String createFetosenseTestMaster(String requestOBJ) throws Exception;

	String getFetosenseTestMaster(Integer psmID);

	String updateFetosenseTestMaster(String requestOBJ);

	String updateFetosenseTestMasterStatus(Integer fetosenseTestID, Boolean deleted) throws Exception;
	
	int saveFetosenseDeviceID(ArrayList<FetosenseDeviceID> fetosenseRequest) throws IEMRException;

	int updateFetosenseDeviceID(FetosenseDeviceID fetosenseData) throws IEMRException;

	String getFetosenseDeviceID(FetosenseDeviceID fetosenseData) throws IEMRException;

	int deleteFetosenseDeviceID(FetosenseDeviceID fetosenseData) throws IEMRException;

	String getvanIDAndFetosenseDeviceID(FetosenseDeviceID fetosenseData) throws IEMRException;

	int vanIDAndDeviceIDMapping(FetosenseDeviceID fetosenseData) throws IEMRException;

	String getVanIDMappingWorklist(FetosenseDeviceID fetosenseData) throws IEMRException;

	int updatingvanIDAndDeviceIDMapping(FetosenseDeviceID fetosenseData) throws IEMRException;

	int deleteVanIDAndDeviceIDMapping(FetosenseDeviceID fetosenseData) throws IEMRException;

}
