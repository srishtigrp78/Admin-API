package com.iemr.admin.service.provideronboard;

import java.util.ArrayList;
import java.util.List;

import com.iemr.admin.data.provideronboard.M_Subservice;
import com.iemr.admin.data.provideronboard.M_SubservicemasterPA;



public interface SubServiceInter {

	ArrayList<M_Subservice> saveSubList(List<M_Subservice> resList);

	//ArrayList<M_Subservice> getServiceNameByProviderMapId(Integer providerServiceMapID);

	ArrayList<M_Subservice> getsubServiceName(Integer providerServiceMapID);

	M_Subservice getsubServiceNameById(Integer subServiceID);

	M_Subservice saveupdatedData(M_Subservice getSubService);

	ArrayList<M_SubservicemasterPA> getServiceNameByServiceID(Integer serviceID);

	//ArrayList<M_Subservice> getsubServiceName(Integer providerServiceMapID);

}
