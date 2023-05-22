package com.iemr.admin.service.apiman;

import com.iemr.admin.data.apiman.ApimanClient;
import com.iemr.admin.data.apiman.ApimanContract;
import com.iemr.admin.data.apiman.ApimanRegister;
import com.iemr.admin.utils.exception.IEMRException;

public interface ApimanService {

	ApimanClient createClient(ApimanClient apimanClient) throws IEMRException;
	
	void createClientContract(Integer integer,String clientID );
	
	String registerClient(ApimanRegister apimanRegister);

	String getClientKey(String clientID);
}