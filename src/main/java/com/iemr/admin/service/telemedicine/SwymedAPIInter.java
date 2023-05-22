package com.iemr.admin.service.telemedicine;

import java.util.HashMap;

import com.iemr.admin.utils.exception.SwyMedException;

public interface SwymedAPIInter {

	Long createUser(HashMap<String,String> obj) throws SwyMedException;

	Long editUser(HashMap<String, String> obj, Long long1, String string) throws SwyMedException;

//	Long activateUser(HashMap<String, String> obj) throws SwyMedException;

}
