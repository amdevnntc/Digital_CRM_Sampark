package com.sampark.digitalCrm.message;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class TestClass {
	
	public static void main(String[] args) throws ParseException {
		Date date = new Date();
		DateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd");
	DateFormat formatter = new SimpleDateFormat("dd MMM yyyy HH:mm:ss z");
	formatter.setTimeZone(TimeZone.getTimeZone("CET"));
	  
	// Prints the date in the CET timezone
	System.out.println(formatter.format(date));
	  
	// Set the formatter to use a different timezone
	formatter.setTimeZone(TimeZone.getTimeZone("IST"));
	  
	// Prints the date in the IST timezone
	System.out.println(formatter.format(date));
	
	System.out.println(formatter1.format(date));
	 SimpleDateFormat format1=new SimpleDateFormat("yyyy-MM-dd");
	 Date dt1=format1.parse(formatter1.format(date));
	  DateFormat format2=new SimpleDateFormat("EEEE"); 
	  String finalDay=format2.format(dt1);
	  System.out.println(finalDay);
	}
		
}


