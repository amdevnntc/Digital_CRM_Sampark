package com.sampark.digitalCrm.message;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.Map;

import com.sampark.digitalCrm.digitalCrmConstant;

public class SendMessage {
	
	static	String authkey ="263478ANyGFSyKgUQ5c6a5c3b";
	static	String senderId = "ssplsz";
	static String route = "4";
	public static void otp(String number, String otppass) {
	
		URLConnection myURLConnection = null;
		URL myURL = null;
		BufferedReader reader = null;


		@SuppressWarnings("deprecation")
		String encoded_message = URLEncoder.encode(otppass);

//Send SMS API
		String mainUrl = "http://api.msg91.com/api/sendhttp.php?";

//Prepare parameter string
		StringBuilder sbPostData = new StringBuilder(mainUrl);
		sbPostData.append("authkey=" + authkey);
		sbPostData.append("&mobiles=" + number);
		sbPostData.append("&message=" + encoded_message);
		sbPostData.append("&route=" + route);
		sbPostData.append("&sender=" + senderId);

//final string
		mainUrl = sbPostData.toString();
		try {
//prepare connection
			myURL = new URL(mainUrl);
			myURLConnection = myURL.openConnection();
			myURLConnection.connect();
			reader = new BufferedReader(new InputStreamReader(myURLConnection.getInputStream()));
//reading response
			String response;
			while ((response = reader.readLine()) != null)
//print response
				System.out.println(response);

//finally close connection
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void msg(String number, String msg) {
	
		URLConnection myURLConnection = null;
		URL myURL = null;
		BufferedReader reader = null;


		@SuppressWarnings("deprecation")
		String encoded_message = URLEncoder.encode(msg);

//Send SMS API
		String mainUrl = "http://api.msg91.com/api/sendhttp.php?";

//Prepare parameter string
		StringBuilder sbPostData = new StringBuilder(mainUrl);
		sbPostData.append("authkey=" + authkey);
		sbPostData.append("&mobiles=" + number);
		sbPostData.append("&message=" + encoded_message);
		sbPostData.append("&route=" + route);
		sbPostData.append("&sender=" + senderId);

//final string
		mainUrl = sbPostData.toString();
		try {
//prepare connection
			myURL = new URL(mainUrl);
			myURLConnection = myURL.openConnection();
			myURLConnection.connect();
			reader = new BufferedReader(new InputStreamReader(myURLConnection.getInputStream()));
//reading response
			String response;
			while ((response = reader.readLine()) != null)
//print response
				System.out.println(response);

//finally close connection
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		SendMessage.otp("8271693632" + "" + "", "test msg");
		/* SendOtp.otp("8130741641", 789654); */

	}

}
