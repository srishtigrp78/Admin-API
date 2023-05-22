package com.iemr.admin.data.stockExit;

import javax.persistence.Transient;

import com.iemr.admin.utils.mapper.OutputMapper;

import lombok.Data;

@Data
public class ItemIssue {
	
	private Integer itemID; 
	
	private Integer itemStockEntryID;

	private Integer issueQty;
	
	private Integer quantity;
	
	@Transient
	private OutputMapper outputMapper = new OutputMapper();

	@Override
	public String toString() {
		return outputMapper.gson().toJson(this);
	}

}
