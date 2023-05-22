package com.iemr.admin.service.uptsu;

import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;

import com.iemr.admin.data.uptsu.M_FacilityMapping;
import com.iemr.admin.data.uptsu.UploadRequest;
import com.iemr.admin.utils.exception.IEMRException;

public interface FacilityService {

	Iterable<M_FacilityMapping> saveFacility(UploadRequest request) throws EncryptedDocumentException, IOException, IEMRException;

}
