package com.iemr.admin.service.provideronboard;

import java.util.ArrayList;
import java.util.List;

import com.iemr.admin.data.provideronboard.M_Institutedirectory;

public interface InstuteDirectoryInter {

	ArrayList<M_Institutedirectory> createInstuteDirectory(List<M_Institutedirectory> instuteDiractoty);

	ArrayList<M_Institutedirectory> getInstuteDirectory(Integer providerServiceMapId);

	M_Institutedirectory editInstuteDirectory(Integer instituteDirectoryID);

	M_Institutedirectory editdata(M_Institutedirectory getinstuteDirectorydata);

	

}
