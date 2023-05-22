package com.iemr.admin.service.drugstrangth;

import java.util.ArrayList;
import java.util.List;

import com.iemr.admin.data.drugstrangth.M_104DrugStrength;

public interface DrugStrangthInter {

	ArrayList<M_104DrugStrength> createDrugStrangth(List<M_104DrugStrength> saveDrugStrangth);

	ArrayList<M_104DrugStrength> getDrugStrangth();

	M_104DrugStrength updateDrugStrangth(Integer drugStrengthID);

	M_104DrugStrength saveupdatedData(M_104DrugStrength getdata);

}
