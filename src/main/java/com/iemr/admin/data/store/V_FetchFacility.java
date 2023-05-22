package com.iemr.admin.data.store;

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

@Data
@Entity
@Table(name="v_fetchfacility")
public class V_FetchFacility {

	@Id
	@Expose
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "FacilityID")
	private Integer facilityID;

	@Expose
	@Column(name = "FacilityName")
	private String facilityName;

	@Expose
	@Column(name = "FacilityDesc")
	private String facilityDesc;

	@Expose
	@Column(name = "FacilityCode")
	private String facilityCode;

	@Expose
	@Column(name = "FacilityTypeID")
	private Integer facilityTypeID;

	@Expose
	@Column(name = "Location")
	private String location;

	@Expose
	@Column(name = "PhysicalLocation")
	private String physicalLocation;

	@Expose
	@Column(name = "StoreType")
	private String storeType;

	@Expose
	@Column(name = "Status")
	private String status;

	@Expose
	@Column(name = "ProviderServiceMapID")
	private Integer providerServiceMapID;

	@Expose
	@Column(name = "IsMainFacility")
	private Boolean isMainFacility;

	@Expose
	@Column(name = "MainFacilityID")
	private Integer mainFacilityID;

	@Expose
	@Column(name = "FacilityDeleted")
	private Boolean facilityDeleted;

	@Expose
	@Column(name = "FacilityCreatedBy")
	private String facilityCreatedBy;

	@Expose
	@Column(name = "FacilityCreatedDate")
	private Date facilityCreatedDate;

	@Expose
	@Column(name = "FacilityModifiedBy")
	private String facilityModifiedBy;

	@Expose
	@Column(name = "FacilityLastModDate")
	private Date facilityLastModDate;

	@Expose
	@Column(name = "ParkingPlaceID")
	private Integer parkingPlaceID;

	@Expose
	@Column(name = "ParkingPlaceName")
	private String parkingPlaceName;

	@Expose
	@Column(name = "ParkingPlaceDesc")
	private String parkingPlaceDesc;

	@Expose
	@Column(name = "AreaHQAddress")
	private String areaHQAddress;

	@Expose
	@Column(name = "PPDeleted")
	private Boolean pPDeleted;

	@Expose
	@Column(name = "VanID")
	private Integer vanID;

	@Expose
	@Column(name = "VanName")
	private String vanName;

	@Expose
	@Column(name = "VehicalNo")
	private String vehicalNo;

	@Expose
	@Column(name = "VanTypeID")
	private Integer vanTypeID;

	@Expose
	@Column(name = "VanParkingPlaceID")
	private Integer vanParkingPlaceID;

	@Expose
	@Column(name = "VanDeleted")
	private Boolean vanDeleted;

	@Transient
	private OutputMapper outputMapper = new OutputMapper();

	@Override
	public String toString() {
		return outputMapper.gson().toJson(this);
	}

}
