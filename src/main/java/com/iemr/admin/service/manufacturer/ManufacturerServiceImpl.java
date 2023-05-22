package com.iemr.admin.service.manufacturer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iemr.admin.data.manufacturer.M_Manufacturer;
import com.iemr.admin.data.supplier.M_Supplier;
import com.iemr.admin.repo.manufacturer.ManufacturerRepo;

@Service
public class ManufacturerServiceImpl implements ManufacturerInter {
	
	@Autowired
	private ManufacturerRepo manufacturerRepo;

	@Override
	public ArrayList<M_Manufacturer> createManufacturer(List<M_Manufacturer> manufacturerData) {
		ArrayList<M_Manufacturer> createData=(ArrayList<M_Manufacturer>) manufacturerRepo.save(manufacturerData);
		if(createData.size()>0)
		return createData;
		else
			return null;
	}

	@Override
	public ArrayList<M_Manufacturer> createManufacturer(Integer providerServiceMapID) {
		ArrayList<M_Manufacturer> getData=manufacturerRepo.getManufacturerData(providerServiceMapID);
		
//		if(getData.size()>0)	
		return getData;
	}

	@Override
	public M_Manufacturer editManufacturer(Integer manufacturerID) {
		
		M_Manufacturer edit=manufacturerRepo.getEditData(manufacturerID);
		return edit;
	}

	@Override
	public M_Manufacturer saveEditedData(M_Manufacturer editData) {
		M_Manufacturer data=manufacturerRepo.save(editData);
		
		return data;
	}

	@Override
	public Boolean checkManufacturerCode(M_Manufacturer manufacturer) {
		// TODO Auto-generated method stub
		List<M_Manufacturer> manuList=manufacturerRepo.findByManufacturerCodeAndProviderServiceMapID(manufacturer.getManufacturerCode() ,manufacturer.getProviderServiceMapID());
		if(manuList.size()>0)
			return true;
		return false;
	}

}
