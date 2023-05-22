package com.iemr.admin.service.telemedicine;

import java.util.ArrayList;

import com.iemr.admin.data.telemedicine.M_UserTemp;
import com.iemr.admin.data.telemedicine.Specialization;
import com.iemr.admin.data.telemedicine.TMinput;
import com.iemr.admin.data.telemedicine.UserSpecializationMapping;

public interface TMInter {

	ArrayList<M_UserTemp> getUser(TMinput tminput);

	ArrayList<Specialization> getSpecialization();

	ArrayList<UserSpecializationMapping> getUserSpecialization(Integer data);

	ArrayList<UserSpecializationMapping> saveUserSpecialization(ArrayList<UserSpecializationMapping> usrspecmapp);

	UserSpecializationMapping findUserSpecialization(UserSpecializationMapping userSpecializationMapping);

	UserSpecializationMapping saveoneUserSpecialization(UserSpecializationMapping userSpecializationMapping);



}
