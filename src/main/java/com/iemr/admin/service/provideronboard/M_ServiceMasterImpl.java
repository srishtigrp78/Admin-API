package com.iemr.admin.service.provideronboard;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iemr.admin.data.provideronboard.M_ServiceMaster;
import com.iemr.admin.repository.provideronboard.M_ServiceMasterRepo;

@Service
public class M_ServiceMasterImpl implements M_ServiceMasterInter {
	@Autowired
	private M_ServiceMasterRepo mservicemasteRepo;

	@Override
	public List<M_ServiceMaster> getAllServiceLine() {
		
		return mservicemasteRepo.getAllServiceline();
	}

}
