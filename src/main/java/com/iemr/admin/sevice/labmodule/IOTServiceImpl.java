package com.iemr.admin.sevice.labmodule;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iemr.admin.data.labmodule.IOTComponent;
import com.iemr.admin.data.labmodule.IOTProcedure;
import com.iemr.admin.repo.labmodule.IOTRepo;

@Service
public class IOTServiceImpl implements IOTService{

	@Autowired
	IOTRepo iotRepo;
	
	@Override
	public String getIOTProcedure()
	{
		ArrayList<IOTProcedure> list = iotRepo.getIOTProcedure();
		return list.toString();
	}
	
	@Override
	public String getIOTComponent()
	{
		ArrayList<IOTComponent> list = iotRepo.getIOTComponent();
		return list.toString();
	}
}
