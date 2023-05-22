package com.iemr.admin.apiman.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.iemr.admin.data.apiman.ApimanClient;
import com.iemr.admin.service.apiman.ApimanService;
import com.iemr.admin.utils.exception.IEMRException;

@RunWith(MockitoJUnitRunner.class)
public class ApimanTest {

	@Mock
	ApimanService apimanService;

	@Test
	public void createClient() {
		// add the behavior of calc service to add two numbers
		ApimanClient apimanClient=new ApimanClient();
		
		apimanClient.setDescription("testing");
		apimanClient.setInitialVersion("1.0");
		apimanClient.setName("Test User");
		try {
			apimanService.createClient( apimanClient);
		} catch (IEMRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// test the add functionality
//		Assert.assertEquals(mathApplication.add(10.0, 20.0), 30.0, 0);
	}
}
