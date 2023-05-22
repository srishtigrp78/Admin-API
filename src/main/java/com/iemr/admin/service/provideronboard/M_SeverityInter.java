package com.iemr.admin.service.provideronboard;

import java.util.ArrayList;
import java.util.List;

import com.iemr.admin.data.provideronboard.M_Severity;

public interface M_SeverityInter {

	ArrayList<M_Severity> getServerity(Integer providerServiceMapID);

	ArrayList<M_Severity> saveServerity(List<M_Severity> serveritydata);

	M_Severity getDataByServId(Integer severityID);

	M_Severity deletedataser(M_Severity getDAta);

}
