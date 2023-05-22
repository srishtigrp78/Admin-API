package com.iemr.admin.sevice.labmodule;

public interface MasterStatusUpdate {
	public String updateProcedureStatus(Integer procedureID, Boolean deleted) throws Exception;

	public String updateComponentStatus(Integer componentID, Boolean deleted) throws Exception;
}
