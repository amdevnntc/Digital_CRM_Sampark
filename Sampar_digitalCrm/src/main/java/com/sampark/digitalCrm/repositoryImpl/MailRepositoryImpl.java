package com.sampark.digitalCrm.repositoryImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Store;

import org.springframework.stereotype.Repository;

import com.sampark.digitalCrm.entity.MailEntity;
import com.sampark.digitalCrm.repository.MailRepository;

@Repository
public class MailRepositoryImpl implements MailRepository {

	@Override
	public List<MailEntity> getmailList() {
		 
		List<MailEntity> list=new ArrayList<MailEntity>();
		try {
			 // mail server connection parameters
	        String host = "mail.samparksolutions.com";
	        String user = "ankit.kumar@samparksolutions.com";
	        String password = "sspl@2018";

	        // connect to my pop3 inbox
	        Properties properties = System.getProperties();
	        Session session = Session.getDefaultInstance(properties);
	        Store store = session.getStore("pop3");
	        store.connect(host, user, password);
	        Folder inbox = store.getFolder("Inbox");
	        inbox.open(Folder.READ_ONLY);
        
	        // get the list of inbox messages
	        Message[] messages = inbox.getMessages();

	        if (messages.length == 0) System.out.println("No messages found.");

	        for (int i = 0; i <10; i++) {
	          // stop after listing ten messages
	          if (i > 10) {
	            System.exit(0);
	            inbox.close(true);
	            store.close();
	          }

	        MailEntity mailentity=new MailEntity();
		    	mailentity.setDescription(messages[i].getDescription());
		    	mailentity.setFilename(messages[i].getFileName());
		    	mailentity.setSentDate(messages[i].getSentDate());
		    	mailentity.setFilename(messages[i].getFileName());
		    	mailentity.setSubject( messages[i].getSubject());
		    	mailentity.setFrom( messages[i].getFrom()[0]);
		    	mailentity.setRecieveDate(messages[i].getReceivedDate());
		    	mailentity.setContenttype(messages[i].getContentType());
		    	System.out.println(mailentity);
		    	list.add(mailentity);
	        }
   
		
	     
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	
 
}
}
