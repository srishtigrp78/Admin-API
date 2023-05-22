package com.iemr.admin.service.provideronboard;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.JsonObject;
import com.iemr.admin.data.provideronboard.M_Institution;
import com.iemr.admin.repository.provideronboard.M_InstitutionRepo;

@Service
public class M_InstitutionImpl implements  M_InstitutionInter{
  
	
	@Autowired
	private M_InstitutionRepo m_InstitutionRepo;

	@Override
	public ArrayList<M_Institution> getInstution(Integer providerServiceMapID, Integer stateID, Integer districtID,
			Integer blockID) {
		
		ArrayList<M_Institution> data;
		
	   if(blockID==null){
		  
		data=m_InstitutionRepo.getInstution(providerServiceMapID,stateID,districtID);
	   }else{
		   data=m_InstitutionRepo.getInstution(providerServiceMapID,stateID,districtID,blockID);
	   }
		
		return data;
	}

	@Override
	public ArrayList<M_Institution> createInstution(List<M_Institution> createinstute) {
		ArrayList<M_Institution> data=(ArrayList<M_Institution>) m_InstitutionRepo.save(createinstute);
		return data;
	}

	@Override
	public M_Institution editInstution(Integer institutionID) {
		M_Institution data=m_InstitutionRepo.geteditedData(institutionID);
		return data;
	}

	@Override
	public M_Institution saveEditData(M_Institution createInstutionData) {
		M_Institution data=m_InstitutionRepo.save(createInstutionData);
		return data;
	}
	
	/*
	 * created BY DU20091017
	 */
	@Override
	public ArrayList<M_Institution> createInstutionByVillage(List<M_Institution> createinstute) {
		ArrayList<M_Institution> data=(ArrayList<M_Institution>) m_InstitutionRepo.save(createinstute);
		return data;
	}
	/*
	 * created BY DU20091017
	 */
	@Override
	public ArrayList<M_Institution> getInstutionByVillage(Integer providerServiceMapID, Integer stateID, Integer districtID,
			Integer blockID,Integer villageID) {
		
		ArrayList<M_Institution> data;
		
	   if(blockID==null && villageID == null ){
		  
		data=m_InstitutionRepo.getInstution(providerServiceMapID,stateID,districtID);
	   }else if (blockID!=null && villageID == null){
		   data=m_InstitutionRepo.getInstutionByBlock(providerServiceMapID,stateID,districtID,blockID);
	   }else if(blockID==null && villageID != null) {
		   data=m_InstitutionRepo.getInstutionByVillage(providerServiceMapID,stateID,districtID,villageID);
	   }else {
		   data=m_InstitutionRepo.getInstutionByBlockAndVillage(providerServiceMapID,stateID,districtID,blockID,villageID);
	   }
		
		return data;
	}
	
	/*
	 * Created by Du20091017
	 */
	
	@Override
	public String createInstitutionByFile(JsonObject getInstitutionDetails) {
		
		String fileData = getInstitutionDetails.toString();		
		String createdBy = getInstitutionDetails.get("createdBy").toString();		
		Integer userID = Integer.parseInt(getInstitutionDetails.get("userID").toString());
		Integer providerID = Integer.parseInt(getInstitutionDetails.get("serviceProviderID").toString());
		ArrayList<Object[]> dataSaved = m_InstitutionRepo.institutionByFile(fileData,createdBy,userID,providerID);
		String response = null;

		if(dataSaved != null) {
			if(dataSaved.size() > 0) {
				if(Integer.parseInt(dataSaved.get(0)[0].toString()) > 0) {
					response = "Data Saved Successfully";
				}
				if(Integer.parseInt(dataSaved.get(0)[0].toString()) == 0 && Integer.parseInt(dataSaved.get(0)[1].toString()) >= 0) {
					response = "Data is already present";
				}
				if(Integer.parseInt(dataSaved.get(0)[0].toString()) == -1) {
					response = "The Data in file is not appropriate";
				}
			}
		}
		return response;
	}

}
