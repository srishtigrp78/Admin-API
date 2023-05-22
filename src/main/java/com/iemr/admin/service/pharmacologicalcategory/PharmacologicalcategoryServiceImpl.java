package com.iemr.admin.service.pharmacologicalcategory;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iemr.admin.data.manufacturer.M_Manufacturer;
import com.iemr.admin.data.pharmacologicalcategory.M_Pharmacologicalcategory;
import com.iemr.admin.repo.pharmacologicalcategory.PharmacologicalcategoryRepo;

@Service
public class PharmacologicalcategoryServiceImpl implements PharmacologicalcategoryInter {
	
	@Autowired
	private PharmacologicalcategoryRepo pharmacologicalcategoryRepo;

	@Override
	public ArrayList<M_Pharmacologicalcategory> createPharmacologicalcategory(
			List<M_Pharmacologicalcategory> createPharmacologicaldata) {
		ArrayList<M_Pharmacologicalcategory> data=(ArrayList<M_Pharmacologicalcategory>) pharmacologicalcategoryRepo.save(createPharmacologicaldata);
		if(data.size()>0)
			return data;
		else	
		return null;
	}

	@Override
	public ArrayList<M_Pharmacologicalcategory> getPharmacologicalcategory(Integer providerServiceMapID) {
		ArrayList<M_Pharmacologicalcategory> getData=pharmacologicalcategoryRepo.getPhormacologicalData(providerServiceMapID);
		return getData;
	}

	@Override
	public M_Pharmacologicalcategory editPharmacologicalcategory(Integer pharmCategoryID) {
		M_Pharmacologicalcategory editData=pharmacologicalcategoryRepo.editPhamacologicalData(pharmCategoryID);
		
		return editData;
	}

	@Override
	public M_Pharmacologicalcategory saveEditedPharData(M_Pharmacologicalcategory saveData) {
		M_Pharmacologicalcategory saveDataphar=pharmacologicalcategoryRepo.save(saveData);
		return saveDataphar;
	}

	@Override
	public Boolean checkPharmacologicalcategoryCode(M_Pharmacologicalcategory pharmacologicalcategory) {
		// TODO Auto-generated method stub
		List<M_Pharmacologicalcategory> manuList=pharmacologicalcategoryRepo.findByPharmCategoryCodeAndProviderServiceMapID(pharmacologicalcategory.getPharmCategoryCode() ,pharmacologicalcategory.getProviderServiceMapID());
		if(manuList.size()>0)
			return true;
		return false;
	}

}
