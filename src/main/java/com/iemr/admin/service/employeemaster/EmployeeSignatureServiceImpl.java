package com.iemr.admin.service.employeemaster;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iemr.admin.data.employeemaster.EmployeeSignature;
import com.iemr.admin.repo.employeemaster.EmployeeSignatureRepo;

@Service
public class EmployeeSignatureServiceImpl implements EmployeeSignatureService {

	@Autowired
	EmployeeSignatureRepo employeeSignatureRepo;

	@Override
	public Long uploadSignature(EmployeeSignature empSign) {
		// TODO Auto-generated method stub
		EmployeeSignature usrsignID = employeeSignatureRepo.findOneByUserID(empSign.getUserID());

//		if(usrsignID==null) {
//			employeeSignatureRepo.save(empSign);
//			usrsignID=empSign.getUserSignatureID();
//		}else {
//			employeeSignatureRepo.updateFile(usrsignID,empSign.getFileName(),empSign.getFileType(),empSign.getSignature(),createdBy);
//		}
		if (usrsignID != null) {
			usrsignID.setSignature(empSign.getSignature());
			usrsignID.setFileName(empSign.getFileName());
			usrsignID.setFileType(empSign.getFileType());
			usrsignID.setModifiedBy(empSign.getCreatedBy());
		} else {
			usrsignID = empSign;
		}
		usrsignID = employeeSignatureRepo.save(usrsignID);
		return usrsignID.getUserSignatureID();
	}

	@Override
	public EmployeeSignature fetchSignature(Long userSignID) {
		// TODO Auto-generated method stub
		return employeeSignatureRepo.findOneByUserID(userSignID);
	}

	public Boolean existSignature(Long userID) {
		// TODO Auto-generated method stub
		return employeeSignatureRepo.countByUserIDAndSignatureNotNull(userID)>0;
	}

}
