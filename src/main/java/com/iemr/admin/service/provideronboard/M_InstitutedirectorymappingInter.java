package com.iemr.admin.service.provideronboard;

import java.util.ArrayList;
import java.util.List;

import com.iemr.admin.data.provideronboard.M_Institutedirectorymapping;

public interface M_InstitutedirectorymappingInter {

	ArrayList<M_Institutedirectorymapping> createInstituteDirectoryData(
			List<M_Institutedirectorymapping> instuteDiractoty);
	M_Institutedirectorymapping deleteInstituteDirectoryData(Integer instituteDirMapID);

	M_Institutedirectorymapping setdeletedData(M_Institutedirectorymapping deleteinstutesubDirectorydata);
	
	
	
	
	ArrayList<M_Institutedirectorymapping> getInstituteDirectoryData(Integer instituteSubDirectoryID);
	

}
