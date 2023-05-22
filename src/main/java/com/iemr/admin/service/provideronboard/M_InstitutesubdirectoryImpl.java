package com.iemr.admin.service.provideronboard;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iemr.admin.data.provideronboard.M_Institutedirectory;
import com.iemr.admin.data.provideronboard.M_Institutesubdirectory;
import com.iemr.admin.repository.provideronboard.M_InstitutesubdirectoryRepo;

@Service
public class M_InstitutesubdirectoryImpl implements M_InstitutesubdirectoryInter  {
	
	@Autowired
	private M_InstitutesubdirectoryRepo m_InstitutesubdirectoryRepo;

	
	
	@Override
	public ArrayList<M_Institutesubdirectory> getInstutesubDirectory(Integer instituteDirectoryID,
			Integer providerServiceMapId) {
		ArrayList<M_Institutesubdirectory> data=m_InstitutesubdirectoryRepo.getInstutesubDirectory(instituteDirectoryID,providerServiceMapId);
		return data;
	}



	@Override
	public ArrayList<M_Institutesubdirectory> CreateInstutesubDirectory(
			List<M_Institutesubdirectory> instuteSubDiractoty) {
		ArrayList<M_Institutesubdirectory> data=(ArrayList<M_Institutesubdirectory>) m_InstitutesubdirectoryRepo.save(instuteSubDiractoty);
		return data;
	}



	@Override
	public M_Institutesubdirectory editInstutesubDirectory(Integer instituteSubDirectoryID) {
		M_Institutesubdirectory data=m_InstitutesubdirectoryRepo.editInstutesubDirectory(instituteSubDirectoryID);
		return data;
	}



	@Override
	public M_Institutesubdirectory saveEditedData(M_Institutesubdirectory getinstutesubDirectoryediteddata) {
		M_Institutesubdirectory data=m_InstitutesubdirectoryRepo.save(getinstutesubDirectoryediteddata);
		return data;
	}

	

}
