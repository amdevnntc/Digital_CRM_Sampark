package com.sampark.digitalCrm.push;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import org.json.simple.JSONObject;
import com.google.android.gcm.server.Message;
import com.google.android.gcm.server.MulticastResult;
import com.google.android.gcm.server.Result;
import com.google.android.gcm.server.Sender;
public class AndroidPushNotification {
	
	

	public final static String AUTH_KEY_FCM = "AAAACJPiaxU:APA91bHBdZhlO5Mu30m-5ydKdrcNBnOBNnmutAwM_Rpz-lvAIJ1IEDH3dQ62WBGdzKjMknrFTULjrTgPOfkvIByd8xzAUdEIsh45RyugiGjwPxpJD7OJvgDW_ReL1c2dX41f6K95pWGsVfMEQ2ifDVAEH_PhepHLZg";
	public final static String API_URL_FCM = "https://fcm.googleapis.com/fcm/send";	 
	    @SuppressWarnings("unchecked")
		public static String sendPushNotification(String deviceToken,String messsage)
	            throws IOException {
	        String result = "";
	        URL url = new URL(API_URL_FCM);
	        HttpURLConnection conn = (HttpURLConnection) url.openConnection(); 
	        conn.setUseCaches(false);
	        conn.setDoInput(true);
	        conn.setDoOutput(true);	 
	        conn.setRequestMethod("POST");
	        conn.setRequestProperty("Authorization", "key="+AUTH_KEY_FCM);
	        conn.setRequestProperty("Content-Type", "application/json");	 
	        JSONObject json = new JSONObject();	 
	        json.put("to", deviceToken.trim());
	        JSONObject info = new JSONObject();
	        info.put("title", "digitalCrm"); // Notification title
	        info.put("body", messsage); // Notification	                                                                // body
	        json.put("notification", info);
	        try {
	            OutputStreamWriter wr = new OutputStreamWriter(
	                    conn.getOutputStream());
	            wr.write(json.toString());
	            wr.flush();	 
	            BufferedReader br = new BufferedReader(new InputStreamReader(
	                    (conn.getInputStream())));
	 
	            String output;
	            System.out.println("Output from Server .... \n");
	            while ((output = br.readLine()) != null) {
	                System.out.println(output);
	            }
	            result = "success";
	        } catch (Exception e) {
	            e.printStackTrace();
	            result = "Fail";
	        }
	        System.out.println("GCM Notification is sent successfully");
			return result;
	    }
	public static void main(String[] args) {	
		try {
			AndroidPushNotification.sendPushNotification("c7OD5y2Bm0U:APA91bFigoR3KsfWeMC6B9WIGpcQdY2ZwtS1WNRYaq-eXYEE5DJ_to6hT6eMux4VxReyN5pRGnOjWwo9FY9-fBY54z2QGG2DrhEeuaSOs6voHf8gq_Pb2I9S6FJcs9Zl5EDCMerNpVx7","Test Push Notification");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
