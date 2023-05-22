package com.iemr.admin.service.provideronboard;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iemr.admin.data.provideronboard.M_Severity;
import com.iemr.admin.repository.provideronboard.M_SeverityRepo;



@Service
public class M_SeverityImpl implements M_SeverityInter{
	
   @Autowired
   private 	M_SeverityRepo M_ServerityRepo;

@Override
public ArrayList<M_Severity> getServerity(Integer providerServiceMapID) {
	ArrayList<M_Severity>	data=M_ServerityRepo.getAllServerity(providerServiceMapID);
	return data;
}

@Override
public ArrayList<M_Severity> saveServerity(List<M_Severity> serveritydata) {
	ArrayList<M_Severity> saveSerdata=(ArrayList<M_Severity>) M_ServerityRepo.save(serveritydata);
	return saveSerdata;
}

@Override
public M_Severity getDataByServId(Integer severityID) {
	M_Severity editdata=M_ServerityRepo.editServerity(severityID);
	return editdata;
}

@Override
public M_Severity deletedataser(M_Severity getDAta) {
	M_Severity deleted=M_ServerityRepo.save(getDAta);
	return deleted;
}


}

