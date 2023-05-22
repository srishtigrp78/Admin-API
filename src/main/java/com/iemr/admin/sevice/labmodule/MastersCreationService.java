package com.iemr.admin.sevice.labmodule;

import com.iemr.admin.utils.exception.IEMRException;

/***
 * 
 * @author Rajeev Tripathi
 * @date 15-02-2018
 *
 */
public interface MastersCreationService {
	public String createProcedureMaster(String requestOBJ) throws IEMRException;

	public String createComponentMaster(String requestOBJ) throws Exception;
}
