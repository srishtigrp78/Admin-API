package com.iemr.admin.service.provideronboard;

import java.util.ArrayList;
import java.util.List;

import com.iemr.admin.data.provideronboard.M_Institutedirectory;
import com.iemr.admin.data.provideronboard.M_Institutesubdirectory;

public interface M_InstitutesubdirectoryInter {


	ArrayList<M_Institutesubdirectory> getInstutesubDirectory(Integer instituteDirectoryID,
			Integer providerServiceMapId);

	ArrayList<M_Institutesubdirectory> CreateInstutesubDirectory(List<M_Institutesubdirectory> instuteSubDiractoty);

	M_Institutesubdirectory editInstutesubDirectory(Integer instituteSubDirectoryID);

	M_Institutesubdirectory saveEditedData(M_Institutesubdirectory getinstutesubDirectoryediteddata);
	
	

}
