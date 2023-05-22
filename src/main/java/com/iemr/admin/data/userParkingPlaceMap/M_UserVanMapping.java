package com.iemr.admin.data.userParkingPlaceMap;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.google.gson.annotations.Expose;
import com.iemr.admin.data.provideronboard.M_ProviderServiceMapping;
import com.iemr.admin.data.vanMaster.M_Van;
import com.iemr.admin.utils.mapper.OutputMapper;

import lombok.Data;

@Data
@Entity
@Table(name = "m_uservanmapping")
public class M_UserVanMapping {
	
	@Expose
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "UserVanMapID")
	private Integer userVanMapID;

	@Expose
	@Column(name = "UserParkingPlaceMapID")
	private Integer userParkingPlaceMapID;
	
	@Expose
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(updatable = false, insertable = false, name = "userParkingPlaceMapID")
	private M_UserParkingPlaceMap userParkingPlaceMap;

	@Expose
	@Column(name = "VanID")
	private Integer vanID;
	
	@Expose
	@Transient
	private String vanName;
	
	@Expose
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(updatable = false, insertable = false, name = "vanID")
	private M_Van van;


	@Expose
	@Column(name = "ProviderServiceMapID")
	private Integer providerServiceMapID;
	
	@Expose
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(updatable = false, insertable = false, name = "ProviderServiceMapID")
	private M_ProviderServiceMapping m_providerServiceMapping;

	
	@Expose
	@Column(name = "Deleted", insertable = false, updatable = true)
	private Boolean deleted;
	@Expose
	@Column(name = "Processed", insertable = false, updatable = true)
	private String processed;
	@Expose
	@Column(name = "CreatedBy")
	private String createdBy;
	@Expose
	@Column(name = "CreatedDate", insertable = false, updatable = false)
	private Date createdDate;
	@Expose
	@Column(name = "ModifiedBy")
	private String modifiedBy;
	@Expose
	@Column(name = "LastModDate", insertable = false, updatable = false)
	private Date lastModDate;

	public M_UserVanMapping() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Transient
	private OutputMapper outputMapper = new OutputMapper();

	@Override
	public String toString() {
		return outputMapper.gson().toJson(this);
	}

}
