package com.iemr.admin.controller.emailconfig;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iemr.admin.model.emailconfig.CreateAuthEmailRequestModel;
import com.iemr.admin.model.emailconfig.AuthEmailRequest;
import com.iemr.admin.model.emailconfig.UpdateAuthEmailRequest;
import com.iemr.admin.service.emailconfig.EmailConfigService;
import com.iemr.admin.utils.mapper.OutputMapper;
import com.iemr.admin.utils.response.OutputResponse;

@RestController
@ApplicationPath("/email")
public class EmailConfigController
{
	private Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	@Autowired
	EmailConfigService emailConfigService;

	@CrossOrigin()
	@RequestMapping(value = "/saveConfig", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON,
			headers = "Authorization")
	public String saveConfig(@RequestBody List<CreateAuthEmailRequestModel> createEmailRequests, HttpServletRequest request)
	{
		OutputResponse response = new OutputResponse();
		try
		{
			logger.info("saveConfig received request");
			logger.debug("saveConfig received request");
			response.setResponse(
					OutputMapper.gsonWithoutExpose().toJson(emailConfigService.saveEmailConfigs(createEmailRequests)));
		} catch (Exception e)
		{
			response.setError(e);
		}

		logger.debug("saveConfig sending response " + response.toString());
		logger.info("saveConfig sending response");
		return response.toString();

	}

	@CrossOrigin()
	@RequestMapping(value = "/getEmailConfigs", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON,
			headers = "Authorization")
	public String getEmailConfigs(@RequestBody AuthEmailRequest authEmailRequest, HttpServletRequest request)
	{
		OutputResponse response = new OutputResponse();
		try
		{
			logger.info("getEmailConfigs received request");
			logger.debug("getEmailConfigs received request");
			response.setResponse(OutputMapper.gsonWithoutExpose()
					.toJson(emailConfigService.getAllEmailConfigs(authEmailRequest)));
		} catch (Exception e)
		{
			response.setError(e);
		}

		logger.debug("getEmailConfigs sending response " + response.toString());
		logger.info("getEmailConfigs sending response");
		return response.toString();

	}

	@CrossOrigin()
	@RequestMapping(value = "/updateEmailConfig", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON,
			headers = "Authorization")
	public String updateEmailConfig(@RequestBody UpdateAuthEmailRequest updateEmailRequest,
			HttpServletRequest request)
	{
		OutputResponse response = new OutputResponse();
		try
		{
			logger.info("updateEmailConfig received request");
			logger.debug("updateEmailConfig received request");
			response.setResponse(
					OutputMapper.gsonWithoutExpose().toJson(emailConfigService.updateEmailConfigs(updateEmailRequest)));
		} catch (Exception e)
		{
			response.setError(e);
		}

		logger.debug("updateEmailConfig sending response " + response.toString());
		logger.info("updateEmailConfig sending response");
		return response.toString();

	}

}