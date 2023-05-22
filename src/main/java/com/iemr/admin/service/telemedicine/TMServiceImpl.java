package com.iemr.admin.service.telemedicine;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iemr.admin.data.telemedicine.M_UserTemp;
import com.iemr.admin.data.telemedicine.Specialization;
import com.iemr.admin.data.telemedicine.TMinput;
import com.iemr.admin.data.telemedicine.UserSpecializationMapping;
import com.iemr.admin.repo.telemedicine.SpecializationRepo;
import com.iemr.admin.repo.telemedicine.UserRepo;
import com.iemr.admin.repo.telemedicine.UserSpecializationMappingRepo;

@Service
public class TMServiceImpl implements TMInter {

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private SpecializationRepo specializationRepo;
	
	@Autowired
	private UserSpecializationMappingRepo userSpecializationMappingRepo;

	@Override
	public ArrayList<M_UserTemp> getUser(TMinput tminput) {
		// TODO Auto-generated method stub
		return userRepo.getUserTM(tminput.getServiceproviderID(), tminput.getScreenName());
	}

	@Override
	public ArrayList<Specialization> getSpecialization() {
		// TODO Auto-generated method stub
		return specializationRepo.findByDeleted(false);
	}

	@Override
	public ArrayList<UserSpecializationMapping> getUserSpecialization(Integer data) {
		// TODO Auto-generated method stub
		return userSpecializationMappingRepo.findByServiceprovider(data);
	}

	@Override
	public ArrayList<UserSpecializationMapping> saveUserSpecialization(
			ArrayList<UserSpecializationMapping> usrspecmapp) {
		// TODO Auto-generated method stub
		return (ArrayList<UserSpecializationMapping>) userSpecializationMappingRepo.save(usrspecmapp);
	}

	@Override
	public UserSpecializationMapping findUserSpecialization(UserSpecializationMapping userSpecializationMapping) {
		// TODO Auto-generated method stub
		return userSpecializationMappingRepo.findOne(userSpecializationMapping.getUserSpecializationMapID());
	}

	@Override
	public UserSpecializationMapping saveoneUserSpecialization(UserSpecializationMapping userSpecializationMapping) {
		// TODO Auto-generated method stub
		return userSpecializationMappingRepo.save(userSpecializationMapping);
	}

}
