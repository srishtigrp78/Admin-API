package com.iemr.admin.mapper.parkingplacetalukmapping;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.iemr.admin.data.parkingPlace.ParkingplaceTalukMapping;
import com.iemr.admin.data.parkingPlace.ParkingplaceTalukMappingTO;

@Mapper(componentModel = "spring")
public interface ParkingPlaceTalukMappingMapper {

	ParkingPlaceTalukMappingMapper INSTANCE = Mappers.getMapper(ParkingPlaceTalukMappingMapper.class);

	@Mappings({ @Mapping(target = "ppSubDistrictMapID", source = "parkingplaceTalukMapping.ppSubDistrictMapID"),
			@Mapping(target = "parkingPlaceID", source = "parkingplaceTalukMapping.parkingPlaceID"),
			@Mapping(target = "districtID", source = "parkingplaceTalukMapping.districtID"),
			@Mapping(target = "districtBlockID", source = "parkingplaceTalukMapping.districtBlockID"),
			@Mapping(target = "parkingPlaceName", source = "parkingplaceTalukMapping.parkingplace.parkingPlaceName"),
			@Mapping(target = "districtName", source = "parkingplaceTalukMapping.m_district.districtName"),
			@Mapping(target = "districtBlockName", source = "parkingplaceTalukMapping.districtBlock.blockName"), 
			@Mapping(target = "providerServiceMapID", source = "parkingplaceTalukMapping.providerServiceMapID"),
			@Mapping(target = "parkingPlaceDeleted", source = "parkingplaceTalukMapping.parkingplace.deleted"),
			@Mapping(target = "districtDeleted", source = "parkingplaceTalukMapping.m_district.deleted"),
			@Mapping(target = "districtBlockDeleted", source = "parkingplaceTalukMapping.districtBlock.deleted"),
			@Mapping(target = "deleted", source = "parkingplaceTalukMapping.deleted"),
			@Mapping(target = "processed", source = "parkingplaceTalukMapping.processed"),
			@Mapping(target = "createdBy", source = "parkingplaceTalukMapping.createdBy"),
			@Mapping(target = "createdDate", source = "parkingplaceTalukMapping.createdDate"),
			@Mapping(target = "modifiedBy", source = "parkingplaceTalukMapping.modifiedBy"),
			@Mapping(target = "lastModDate", source = "parkingplaceTalukMapping.lastModDate"),})
	ParkingplaceTalukMappingTO getParkingplaceTalukMappingMap(ParkingplaceTalukMapping parkingplaceTalukMapping);

	List<ParkingplaceTalukMappingTO> getParkingplaceTalukMappingMapList(
			List<ParkingplaceTalukMapping> parkingplaceTalukMappingList);
}
