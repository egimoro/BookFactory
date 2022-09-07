package com.book.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public interface Validator {
	public static boolean isDate(String date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		
		try {
			dateFormat.parse(date.trim());
			
		}catch(ParseException pe) {
			pe.printStackTrace();
		}
		return true;
	}
	
	static boolean onlineOrBrick(String storeType) {
		if(storeType.contains("Brick".toLowerCase()) || storeType.contains("online".toLowerCase()))
				return true;
		else
			return false;
				
	}
	

}
