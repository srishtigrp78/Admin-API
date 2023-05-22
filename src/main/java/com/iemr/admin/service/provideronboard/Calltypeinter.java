package com.iemr.admin.service.provideronboard;

import java.util.ArrayList;
import java.util.List;

import com.iemr.admin.data.provideronboard.M_Calltype;



public interface Calltypeinter {

	ArrayList<M_Calltype> saveCallList(List<M_Calltype> resList);

	

	M_Calltype updateCallType(Integer callTypeID);

	M_Calltype saveupdatedData(M_Calltype updateData);



	ArrayList<M_Calltype> getCalltypeData(Integer providerServiceMapID);



	ArrayList<M_Calltype> createCalltype(List<M_Calltype> callMaster);

}
