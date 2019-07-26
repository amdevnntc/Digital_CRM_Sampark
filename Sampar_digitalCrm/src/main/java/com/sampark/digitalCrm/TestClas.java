package com.sampark.digitalCrm;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class TestClas {
	public static void main(String[] args) throws ParseException {
		 String sDate6 = "11-30";  
		 SimpleDateFormat formatter6=new SimpleDateFormat("MM-dd");  
		  Date date6=formatter6.parse(sDate6);  
		  
		  System.out.println(date6);
		  System.out.println(new Date());
		  
		   long diff = new Date().getTime() - date6.getTime();
		    System.out.println ("Days: " + TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS));
	}

}
