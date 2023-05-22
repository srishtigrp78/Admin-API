package com.iemr.admin.service.employeemaster;

import com.iemr.admin.data.employeemaster.EmployeeSignature;

public interface EmployeeSignatureService {
	
	public EmployeeSignature fetchSignature(Long userID);

	Long uploadSignature(EmployeeSignature empSign);

}
