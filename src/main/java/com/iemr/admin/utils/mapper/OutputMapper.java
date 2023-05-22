package com.iemr.admin.utils.mapper;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.LongSerializationPolicy;

public class OutputMapper
{
	static GsonBuilder builder;
	static GsonBuilder builderV1;

	public OutputMapper()
	{
		if (builder == null)
		{
			builder = new GsonBuilder();
			builder.setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
			builder.excludeFieldsWithoutExposeAnnotation().setLongSerializationPolicy(LongSerializationPolicy.STRING);
			builder.serializeNulls();
		}
		if (builderV1 == null)
		{
			builderV1 = new GsonBuilder();
			builderV1.setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
			builderV1.setLongSerializationPolicy(LongSerializationPolicy.STRING);
			builderV1.serializeNulls();
		}
	}

	public static Gson gson()
	{
		return builder.create();
	}
	
	public static Gson gsonWithoutExpose()
	{
		return builderV1.create();
	}
}