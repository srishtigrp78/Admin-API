package com.iemr.admin.service.drugstrangth;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iemr.admin.data.drugstrangth.M_104DrugStrength;
import com.iemr.admin.repo.blocking.DrugStrangthRepo;

@Service
public class DrugStrangthService implements DrugStrangthInter{

	@Autowired
	private DrugStrangthRepo drugStrangthRepo;

	@Override
	public ArrayList<M_104DrugStrength> createDrugStrangth(List<M_104DrugStrength> saveDrugStrangth) {
		ArrayList<M_104DrugStrength> data=(ArrayList<M_104DrugStrength>) drugStrangthRepo.save(saveDrugStrangth);
		return data;
	}

	@Override
	public ArrayList<M_104DrugStrength> getDrugStrangth() {
		ArrayList getdata=(ArrayList) drugStrangthRepo.findAll();
		return getdata;
	}

	@Override
	public M_104DrugStrength updateDrugStrangth(Integer drugStrengthID) {
		M_104DrugStrength getdataforupdate=drugStrangthRepo.findOne(drugStrengthID);
		return getdataforupdate;
	}

	@Override
	public M_104DrugStrength saveupdatedData(M_104DrugStrength getdata) {
		M_104DrugStrength savedataforupdate=drugStrangthRepo.save(getdata);
		return savedataforupdate;
	}
	
	
}
