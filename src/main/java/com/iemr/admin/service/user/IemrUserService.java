package com.iemr.admin.service.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.iemr.admin.data.user.M_UserServiceRoleMapping;

public interface IemrUserService {
	/**
	 * @Author Neeraj
	 * @param userDetails
	 * @param createdBy
	 * @return
	 * @Date 10-july-2017
	 */
	public int createUser(ArrayList<Map<String, Object>> userDetails, String createdBy);

	int createUserServiceRoleMapping(List<Integer> proSerStatMapIdList, int userID, String createdBy);
}
