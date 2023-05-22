package com.iemr.admin.data.uptsu;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UploadRequest {
	private String createdBy;
	private int providerServiceMapID;
	private String fileName;
	private String fileExtension;
	private String fileContent;
}
