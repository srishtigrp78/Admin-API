package com.iemr.admin.service.provideronboard;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.iemr.admin.data.employeemaster.M_User1;
import com.iemr.admin.data.user.M_User;
import com.iemr.admin.utils.config.ConfigProperties;
import com.iemr.admin.utils.http.HttpUtils;
import com.iemr.admin.utils.mapper.InputMapper;
import com.iemr.admin.utils.response.OutputResponse;

@Service
public class EncryptUserPassword123 {
	private static HttpUtils utils = new HttpUtils();
	private static String commonBaseURL = ConfigProperties.getPropertyByName("common-url");
	private static String encryptPasswordURL = commonBaseURL
			+ ConfigProperties.getPropertyByName("encrypt-password-url");

	private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	@Async
	public OutputResponse encryptUserCredentials(M_User data) {
		JSONObject request = new JSONObject();
		request.put("password", data.getPassword());
		request.put("userName", data.getUserName());
		logger.info("Calling " + encryptPasswordURL + " to set password for user " + data.getUserName());
		OutputResponse response = InputMapper.gson().fromJson(utils.post(encryptPasswordURL, request.toString()),
				OutputResponse.class);
		logger.info(encryptPasswordURL + " returned response " + response);
		return response;
	}

}
