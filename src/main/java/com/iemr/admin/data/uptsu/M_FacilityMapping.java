package com.iemr.admin.data.uptsu;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.gson.annotations.Expose;

import lombok.Data;

@Data
@Entity
@Table(name = "m_blocksubcentermapping")
public class M_FacilityMapping {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Expose
	@Column(name = "Id")
	private Integer id;
	
	@Column(name = "Employee_Code")
	private String employeeCode;
	
	@Column(name = "Employee_Name")
	private String employeeName;
	
	@Column(name = "Survey_Facility_Code")
	private String surveyFacility;
	
	@Column(name = "Office_Type")
	private String officeType;
	
	@Column(name = "Office_Category")
	private String officeCategory;
	
	@Column(name = "Posting_Office")
	private String postingOffice;
	
	@Column(name = "Post_District")
	private String postDistrict;
	
	@Column(name = "Designationid")
	private int designationId;
	
	@Column(name = "Designation")
	private String designation;
	
	@Column(name = "Des_Category")
	private String desCategory;
	
	@Column(name = "Des_SubCategory")
	private String desSubCategory;
	
	@Column(name = "Employee_Type")
	private String employeeType;
	
	@Column(name = "Cadre")
	private String cadre;
	
	@Column(name = "ActiveStatus")
	private String activeStatus;
	
	@Column(name = "FacilityType")
	private String facilityType;
	
	@Column(name = "Present_MobileNo")
	private String presentMoboleNo;
	
	@Column(name = "DivisionName")
	private String divisionName;
	
	@Column(name = "DivisionCode")
	private int divisionCode;
	
	@Column(name = "DistrictName")
	private String districtName;
	
	@Column(name = "D_LGD")
	private int dlgd;
	
	@Column(name = "TehsilName")
	private String tehsilName;
	
	@Column(name = "T_LGD")
	private int tlgd;
	
	@Column(name = "BlockName")
	private String blockName;
	
	@Column(name = "B_LGD")
	private int blgd;
	
	@Column(name = "GramPanchayatName")
	private String gramPanchayatName;
	
	@Column(name = "G_LGD")
	private int glgd;
	
	@Column(name = "VillageName")
	private String villageName;
	
	@Column(name = "VillageCode")
	private int villageCode;
	
	@Column(name = "FacilityName")
	private String facilityName;
	
	@Column(name = "FacilityCode")
	private String facilityCode;
	
	
	
	@Column(name = "FC_Status")
	private String fcStatus;
	
	@Column(name = "FacilityClassification")
	private String facilityClassification;
	
	@Column(name = "FacilityCategory")
	private String facilityCategory;
	
	@Column(name = "Longitude")
	private String longitude;
	
	@Column(name = "Latitude")
	private String latitude;
	
	@Column(name = "HIMSCode")
	private String himsCode;
	
	@Column(name = "HWCStatus")
	private String hwcStatus;
	
	@Column(name = "FRUStatus")
	private String fruStatus;
	
	@Column(name = "HFRID")
	private String hfrCode;
	
	@Column(name = "HPR_Code")
	private String hprCode;
	
	@Column(name= "ProviderServiceMapID")
	private int providerServiceMapID;
	
	@Column(name= "createdBy")
	private String createdBy;
	
	@Column(name= "CreatedDate")
	private Timestamp createdDate;
	
	@Column(name= "LastModDate")
	private Timestamp lastModDate;
	
	@Column(name= "ModifiedBy")
	private String modifiedBy;
	
	@Column(name= "Deleted")
	private boolean deleted;
	
	@Column(name= "Processed")
	private char processed;
	

}
