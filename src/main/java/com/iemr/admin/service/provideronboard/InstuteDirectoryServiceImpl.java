package com.iemr.admin.service.provideronboard;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iemr.admin.data.provideronboard.M_Institutedirectory;
import com.iemr.admin.repository.provideronboard.InstuteDirectoryRepo;


@Service
public class InstuteDirectoryServiceImpl implements InstuteDirectoryInter{
	@Autowired
	private InstuteDirectoryRepo instuteDirectoryRepo;

	@Override
	public ArrayList<M_Institutedirectory> createInstuteDirectory(List<M_Institutedirectory> instuteDiractoty) {
		ArrayList<M_Institutedirectory> data=(ArrayList<M_Institutedirectory>) instuteDirectoryRepo.save(instuteDiractoty);
		return data;
	}

	@Override
	public ArrayList<M_Institutedirectory> getInstuteDirectory(Integer providerServiceMapId) {
		ArrayList<M_Institutedirectory> data=instuteDirectoryRepo.getInstuteDirectory(providerServiceMapId);
		return data;
	}

	@Override
	public M_Institutedirectory editInstuteDirectory(Integer instituteDirectoryID) {
		M_Institutedirectory data=instuteDirectoryRepo.editInstuteDirectory(instituteDirectoryID);
		return data;
	}

	@Override
	public M_Institutedirectory editdata(M_Institutedirectory getinstuteDirectorydata) {
		M_Institutedirectory data=instuteDirectoryRepo.save(getinstuteDirectorydata);
		return data;
	}


 
}
