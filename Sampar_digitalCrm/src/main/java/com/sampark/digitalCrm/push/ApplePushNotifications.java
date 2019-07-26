package com.sampark.digitalCrm.push;

import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.json.JSONException;

import javapns.Push;
import javapns.communication.exceptions.CommunicationException;
import javapns.communication.exceptions.KeystoreException;
import javapns.notification.PushNotificationPayload;
import javapns.notification.PushedNotification;
import javapns.notification.ResponsePacket;

public class ApplePushNotifications {
	
	public static void main(String[] args) {
		ApplePushNotifications.sendNotification("ba5441fce61c316d5dd26d4a15f77e94284f71e47d60904b0b54ccd8c5b7acff","Test Notificiation",9);
	}
	
	public static void sendNotification(String deviceToken,String message,Integer badge)
	{
             BasicConfigurator.configure();
        try {
            PushNotificationPayload payload = PushNotificationPayload.complex();
            payload.addAlert(message);
            payload.addBadge(badge);
            payload.addSound("default");
            payload.addCustomDictionary("id", "1");
            System.out.println(payload.toString());
            String certPath = ApplePushNotifications.class.getResource("LeadKey.p12").getPath();
            List < PushedNotification > NOTIFICATIONS = Push.payload(payload,certPath,"",false,deviceToken);
            for (PushedNotification NOTIFICATION: NOTIFICATIONS) {
                if (NOTIFICATION.isSuccessful()) {
                    /* APPLE ACCEPTED THE NOTIFICATION AND SHOULD DELIVER IT */
                    System.out.println("PUSH NOTIFICATION SENT SUCCESSFULLY TO: " +
                        NOTIFICATION.getDevice().getToken());
                    /* STILL NEED TO QUERY THE FEEDBACK SERVICE REGULARLY */
                } else {
                    String INVALIDTOKEN = NOTIFICATION.getDevice().getToken();
                    /* ADD CODE HERE TO REMOVE INVALIDTOKEN FROM YOUR DATABASE */
                    /* FIND OUT MORE ABOUT WHAT THE PROBLEM WAS */
                    Exception THEPROBLEM = NOTIFICATION.getException();
                    THEPROBLEM.printStackTrace();
                    /* IF THE PROBLEM WAS AN ERROR-RESPONSE PACKET RETURNED BY APPLE, GET IT */
                    ResponsePacket THEERRORRESPONSE = NOTIFICATION.getResponse();
                    if (THEERRORRESPONSE != null) {
                        System.out.println(THEERRORRESPONSE.getMessage());
                    }
                }
            }
        } catch (CommunicationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (KeystoreException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    
	}
}
