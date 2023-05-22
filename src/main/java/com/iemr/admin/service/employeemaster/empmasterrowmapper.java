package com.iemr.admin.service.employeemaster;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class empmasterrowmapper implements RowMapper {

	@Override
	public Object mapRow(ResultSet rs, int line) throws SQLException {
		// TODO Auto-generated method stub
		empMastersetExtract extract=new empMastersetExtract();
		return extract.extractData(rs);
	}

}
