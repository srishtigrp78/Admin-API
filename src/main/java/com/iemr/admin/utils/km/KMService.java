package com.iemr.admin.utils.km;

public interface KMService
{
	String getDocumentRoot();
	
	String createDocument(String documentPath, String filepath);
}
