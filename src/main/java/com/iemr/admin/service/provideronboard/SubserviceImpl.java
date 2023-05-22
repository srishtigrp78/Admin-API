package com.iemr.admin.service.provideronboard;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iemr.admin.data.provideronboard.M_Subservice;
import com.iemr.admin.data.provideronboard.M_SubservicemasterPA;
import com.iemr.admin.repository.provideronboard.M_SubservicemasterPArepo;
import com.iemr.admin.repository.provideronboard.SubserviceMasterRepo;


@Service
public class SubserviceImpl implements SubServiceInter {
	
	@Autowired
	private M_SubservicemasterPArepo m_SubservicemasterPArepo;
	
	@Autowired
	private SubserviceMasterRepo  subserviceMasterRepo;

	@Override
	public ArrayList<M_Subservice> saveSubList(List<M_Subservice> resList) {
		ArrayList<M_Subservice> data=(ArrayList<M_Subservice>) subserviceMasterRepo.save(resList);
		return data;
	}

	/*@Override
	public ArrayList<M_SubservicemasterPA> getServiceNameByServiceID(Integer providerServiceMapID) {
		ArrayList<M_Subservice> data2=subserviceMasterRepo.getServiceNameByProviderMapId(providerServiceMapID);
		return data2;
	}*/

	@Override
	public ArrayList<M_Subservice> getsubServiceName(Integer providerServiceMapID) {
		ArrayList<M_Subservice> data4=subserviceMasterRepo.getsubServiceName(providerServiceMapID);
		return data4;
	}

	@Override
	public M_Subservice getsubServiceNameById(Integer subServiceID) {
		M_Subservice data5=subserviceMasterRepo.getsubServiceNameById(subServiceID);
		return data5;
	}

	@Override
	public M_Subservice saveupdatedData(M_Subservice getSubService) {
		M_Subservice data3=subserviceMasterRepo.save(getSubService);
		return data3;
	}

	@Override
	public ArrayList<M_SubservicemasterPA> getServiceNameByServiceID(Integer serviceID) {
		
		ArrayList<M_SubservicemasterPA> data=m_SubservicemasterPArepo.getServiceNameByServiceID(serviceID);
		
		return data;
	}

	/*@Override
	public ArrayList<M_Subservice> getsubServiceName(Integer providerServiceMapID) {
		ArrayList<M_Subservice> data4=subserviceMasterRepo.getsubServiceName(providerServiceMapID);
		return data4;*/
	//}
	

}
