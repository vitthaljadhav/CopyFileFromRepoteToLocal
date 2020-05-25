package com.info.batch.policy;

import static org.hamcrest.CoreMatchers.nullValue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.batch.item.file.separator.SimpleRecordSeparatorPolicy;

public class BlankLineRecordSeparatorPolicy extends SimpleRecordSeparatorPolicy {
//public class BlankLineRecordSeparatorPolicy implements RecordSeparatorPolicy {
	@Override
	public boolean isEndOfRecord(String record) {
		/*
		 * String dateTime = record.trim().substring(2, 18);
		 * System.out.println(dateTime.trim()); String validate =
		 * validateJavaDate(dateTime.trim(), record); if (validate != null) { return
		 * true; } else { return false; }
		 */
		if(false) {			
			//System.out.println("IsEndOfRecord() "+record);
		}
		return true;
	}

	@Override
	public String postProcess(String record) {
		//System.out.println("postProcess() "+record);
		return record;
	}

	@Override
	public String preProcess(String record) {
		//System.out.println("preProcess() "+record);
		//String finalRecord = record.substring(record.trim().length()-1,record.trim().length()+1);		
		
		return record;
	}

	public static String validateJavaDate(String strDate, String record) {
		if (strDate.trim().equals("")) {
			// return false;
			return null;
		} else {
			SimpleDateFormat sdfrmt = new SimpleDateFormat("ddMMM hh:mm:ss");
			sdfrmt.setLenient(false);

			try {
				Date javaDate = sdfrmt.parse(strDate);
				//System.out.println(strDate + " is valid date format");
				return record;
			} catch (ParseException e) {
				//System.out.println(strDate + " is Invalid Date format");
				// return false;
				return null;
			}
		}
	}
}
