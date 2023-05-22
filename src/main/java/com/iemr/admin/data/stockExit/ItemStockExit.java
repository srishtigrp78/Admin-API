package com.iemr.admin.data.stockExit;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.google.gson.annotations.Expose;
import com.iemr.admin.utils.mapper.OutputMapper;

import lombok.Data;

@Entity
@Table(name="t_itemstockexit")
@Data
public class ItemStockExit {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Expose
	@Column(name="ItemStockExitID")
	private Integer itemStockExitID;
	
	@Expose
	@Column(name="ItemStockEntryID")
	private Integer itemStockEntryID;
	
	@Expose
	@Transient
	private Integer itemID;
	
	@Expose
	@Transient
	private Integer quantityInHand;
		
	@Expose
	@Column(name="Quantity")
	private Integer quantity;
		
	@Expose
	@Column(name="ExitTypeID")
	private Integer exitTypeID;
		
	@Expose
	@Column(name="ExitType")
	private String exitType;
	
	@Expose
	@Column(name="Deleted", insertable = false, updatable = true)
	private Boolean deleted;
	
	@Expose
	@Column(name="Processed", insertable = false, updatable = true)
	private Character processed;
	
	@Expose
	@Column(name="CreatedBy")
	private String createdBy;
	
	@Expose
	@Column(name="CreatedDate", insertable = false, updatable = false)
	private Date createdDate;
	
	@Expose
	@Column(name="ModifiedBy")
	private String modifiedBy;
	
	@Expose
	@Column(name="LastModDate", insertable = false, updatable = false)
	private Date lastModDate;
	
	@Transient
	private OutputMapper outputMapper = new OutputMapper();

	@Override
	public String toString() {
		return outputMapper.gson().toJson(this);
	}
}
