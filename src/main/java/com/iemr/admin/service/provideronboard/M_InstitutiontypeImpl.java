package com.iemr.admin.service.provideronboard;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iemr.admin.data.provideronboard.M_Institutiontype;
import com.iemr.admin.repository.provideronboard.M_InstitutiontypeRepo;

@Service
public class M_InstitutiontypeImpl implements M_InstitutiontypeInter{
	
	
	
 @Autowired	
 private M_InstitutiontypeRepo m_InstitutiontypeRepo;

@Override
public ArrayList<M_Institutiontype> createInstuteType(List<M_Institutiontype> instuteType) {
	ArrayList<M_Institutiontype> data=(ArrayList<M_Institutiontype>) m_InstitutiontypeRepo.save(instuteType);
	return data;
}

@Override
public ArrayList<M_Institutiontype> getInstuteType(Integer providerServiceMapID) {
	ArrayList<M_Institutiontype> data=m_InstitutiontypeRepo.getInstuteType(providerServiceMapID);
	return data;
}

@Override
public M_Institutiontype editInstuteType(Integer institutionTypeID) {
	 M_Institutiontype data=m_InstitutiontypeRepo.editdata(institutionTypeID);
	return data;
}

@Override
public M_Institutiontype saveEditdata(M_Institutiontype editInstuteType1) {
	M_Institutiontype data=m_InstitutiontypeRepo.save(editInstuteType1);
	return data;
}	
/*
 * Created BY Du20091017
 */
@Override
public ArrayList<M_Institutiontype> createInstuteTypeByDist(List<M_Institutiontype> instuteType) {
	ArrayList<M_Institutiontype> data=(ArrayList<M_Institutiontype>) m_InstitutiontypeRepo.save(instuteType);
	return data;
}	

/*
 * Created BY Du20091017
 */
@Override
public ArrayList<M_Institutiontype> getInstuteTypeByDist(Integer providerServiceMapID, Integer districtId,
		Integer subDistrictId,Integer villageId) {
	
	ArrayList<M_Institutiontype> data = new ArrayList<>();
	if(subDistrictId==null && villageId == null ){
		  
		data=m_InstitutiontypeRepo.getInstuteTypeByDist(providerServiceMapID,districtId);
	   }else if (subDistrictId!=null && villageId == null){
		   data=m_InstitutiontypeRepo.getInstutionTypeByBlock(providerServiceMapID,districtId,subDistrictId);
	   }else if(subDistrictId==null && villageId != null) {
		   data=m_InstitutiontypeRepo.getInstutionTypeByVillage(providerServiceMapID,districtId,villageId);
	   }else {
		   data=m_InstitutiontypeRepo.getInstutionByBlockAndVillage(providerServiceMapID,districtId,subDistrictId,villageId);
	   }
	
	return data;
}	

}
