package com.iemr.admin.service.provideronboard;

import java.util.ArrayList;
import java.util.List;

import com.iemr.admin.data.provideronboard.M_Institutiontype;

public interface M_InstitutiontypeInter {

	ArrayList<M_Institutiontype> createInstuteType(List<M_Institutiontype> instuteType);

	ArrayList<M_Institutiontype> getInstuteType(Integer providerServiceMapID);

	M_Institutiontype editInstuteType(Integer institutionTypeID);

	M_Institutiontype saveEditdata(M_Institutiontype editInstuteType1);

	/*
	 * Created BY Du20091017
	 */
	ArrayList<M_Institutiontype> createInstuteTypeByDist(List<M_Institutiontype> instuteType);

	ArrayList<M_Institutiontype> getInstuteTypeByDist(Integer providerServiceMapID, Integer districtId,
			Integer subDistrictId,Integer villageId);

}
