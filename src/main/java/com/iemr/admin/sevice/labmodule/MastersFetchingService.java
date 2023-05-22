package com.iemr.admin.sevice.labmodule;

public interface MastersFetchingService {
	public String getProcedureMaster(Integer psmID) throws Exception;

	public String getComponentMaster(Integer psmID) throws Exception;

	public String getProcedureMasterDelFalse(Integer psmID) throws Exception;

	public String getComponentMasterDelFalse(Integer psmID) throws Exception;
}
