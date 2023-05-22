package com.iemr.admin.service.employeemaster;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iemr.admin.data.employeemaster.M_Designation;
import com.iemr.admin.repo.employeemaster.M_DesignationRepo;

@Service
public class M_DesignationImpl  implements M_DesignationInter{
	@Autowired
	private M_DesignationRepo  m_DesignationRepo;

	@Override
	public ArrayList<M_Designation> getDesinationlist() {
		ArrayList<M_Designation> getlist=m_DesignationRepo.getDesinationlist();
		return getlist ;
	}

}
