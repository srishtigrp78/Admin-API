package com.iemr.admin.service.provideronboard;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iemr.admin.data.provideronboard.M_Calltype;
import com.iemr.admin.repository.provideronboard.CalltypeRepo;



@Service
public class CalltypeServiceImpl implements Calltypeinter{
	@Autowired
	private CalltypeRepo calltypeRepo;

	@Override
	public ArrayList<M_Calltype> saveCallList(List<M_Calltype> resList) {
		ArrayList<M_Calltype> data=(ArrayList<M_Calltype>) calltypeRepo.save(resList);
		return data;
	}

	/*@Override
	public ArrayList<M_Calltype> getCalltypeData() {
		ArrayList<M_Calltype> data=(ArrayList<M_Calltype>) calltypeRepo.getCalltypeData();
		return data;
	}
*/
	@Override
	public M_Calltype updateCallType(Integer callTypeID) {
		M_Calltype data2=calltypeRepo.updateCallType(callTypeID);
		return data2;
	}

	@Override
	public M_Calltype saveupdatedData(M_Calltype updateData) {
		M_Calltype data3=calltypeRepo.save(updateData);
		return data3;
	}

	@Override
	public ArrayList<M_Calltype> getCalltypeData(Integer providerServiceMapID) {
		ArrayList<M_Calltype> data=(ArrayList<M_Calltype>) calltypeRepo.getCalltypeData(providerServiceMapID);
		return data;
	}

	@Override
	public ArrayList<M_Calltype> createCalltype(List<M_Calltype> callMaster) {
		ArrayList<M_Calltype> calltypedata=(ArrayList<M_Calltype>) calltypeRepo.save(callMaster);
		return calltypedata;
	}
	
	

}
