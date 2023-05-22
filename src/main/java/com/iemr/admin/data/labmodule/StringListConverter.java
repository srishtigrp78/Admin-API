package com.iemr.admin.data.labmodule;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class StringListConverter implements AttributeConverter<List<String>, String> {

  @Override
  public String convertToDatabaseColumn(List<String> list) {
    // Java 8
	  StringBuilder strbul  = new StringBuilder();
	  if(list!=null && list.size()>0){
		  Iterator<String> iter = list.iterator();
		     while(iter.hasNext())
		     {
		         strbul.append(iter.next());
		        if(iter.hasNext()){
		         strbul.append("\\|\\|");
		        }
		     } 
	  }else{
		  return null;
	  }
	     
	 return strbul.toString();
//    return String.join(",", list);
  }

  @Override
  public List<String> convertToEntityAttribute(String joined) {
	  List<String> list=new ArrayList();
	  if(joined!=null){
		  String[] strArray = joined.split("\\|\\|"); // split by "||"

		  for(int i = 0; i < strArray.length; i++) {
			  list.add( strArray[i]);
		  }  
	  }
	  
    return list;
  }

}