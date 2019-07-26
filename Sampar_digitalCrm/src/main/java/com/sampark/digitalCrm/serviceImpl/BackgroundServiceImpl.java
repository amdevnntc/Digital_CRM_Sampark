package com.sampark.digitalCrm.serviceImpl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.sampark.digitalCrm.digitalCrmConstant;
import com.sampark.digitalCrm.common.TimezoneConverter;
import com.sampark.digitalCrm.entity.BadgeEntity;
import com.sampark.digitalCrm.entity.ClientEntity;
import com.sampark.digitalCrm.entity.CommercialEntity;
import com.sampark.digitalCrm.entity.EmployeeTask;
import com.sampark.digitalCrm.entity.EnquiryEntity;
import com.sampark.digitalCrm.entity.EnquiryMeetingEntity;
import com.sampark.digitalCrm.entity.MeetingEntity;
import com.sampark.digitalCrm.entity.PropertyClientMapping;
import com.sampark.digitalCrm.entity.ResidentialEntity;
import com.sampark.digitalCrm.entity.TokenBean;
import com.sampark.digitalCrm.mail.SendMail;
import com.sampark.digitalCrm.message.SendMessage;
import com.sampark.digitalCrm.push.AndroidPushNotification;
import com.sampark.digitalCrm.push.ApplePushNotifications;
import com.sampark.digitalCrm.repository.ClientRepository;
import com.sampark.digitalCrm.repository.CommercialRepository;
import com.sampark.digitalCrm.repository.EmployeeRepository;
import com.sampark.digitalCrm.repository.EnquiryRepository;
import com.sampark.digitalCrm.repository.Meetingrepository;
import com.sampark.digitalCrm.repository.ResidentialRepository;
import com.sampark.digitalCrm.repository.TokenRepository;
import com.sampark.digitalCrm.service.BackgroundService;
import com.sampark.digitalCrm.service.TokenService;

@Service
public class BackgroundServiceImpl implements BackgroundService {

	@Autowired
	Meetingrepository meetingrepo;

	@Autowired
	TokenService tokenservice;

	@Autowired
	ClientRepository clientrepo;

	@Autowired
	EmployeeRepository employeeRepo;

	@Autowired
	TokenRepository tokenrepo;

	@Autowired
	ResidentialRepository residentialRepository;
	
	@Autowired
	CommercialRepository commercialRepository;
	
	@Autowired
	EnquiryRepository enquiryRepository;

	SimpleDateFormat formatterdate = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat formattertime = new SimpleDateFormat("HH:mm:ss");

	private static final Logger logger = Logger.getLogger(BackgroundServiceImpl.class);

	Calendar calanni = Calendar.getInstance();
	Calendar caladob = Calendar.getInstance();
	Calendar currendatecalender = Calendar.getInstance();

	Date converteddate = TimezoneConverter.getDate(new Date());

 // @Scheduled(fixedDelay =30000)
	public void meetingNotification() {
		List<MeetingEntity> list = new ArrayList<MeetingEntity>();
		
		
		try {
			MeetingEntity meeting = new MeetingEntity();
			list = meetingrepo.getAllMeetingList();
			
			
			
			if(list.isEmpty())
			{
				System.out.println("No Data Found");
			}
			else
			{
				Iterator<MeetingEntity> it = list.iterator();
				while (it.hasNext()) {
					Date converteddate1 = TimezoneConverter.getDate(new Date());
					meeting = it.next();
					Integer newbadge=null;
			    	String strDate = formatterdate.format(converteddate1);
					String newdates = String.valueOf(meeting.getMeetingdate()).substring(0, 10);
					if (newdates.equals(strDate)) {
						String currentime = formattertime.format(converteddate1);
						SimpleDateFormat format = new SimpleDateFormat("HH:mm");
						Date date1 = format.parse(meeting.getFromtime());
						Date date2 = format.parse(currentime);
						long difference = date1.getTime() - date2.getTime();
						long minutes = TimeUnit.MILLISECONDS.toMinutes(difference);
						System.out.println("meeting remianing time : - "+minutes);
						if (meeting.getReminder().equals(String.valueOf(minutes))) {
							
							 BadgeEntity badgeEntity=tokenrepo.badgeDetails(meeting.getDealerid(), meeting.getEmployeeid());
								
							
							meetingrepo.updateReminder(meeting);
							// ClientEntity client=new ClientEntity();
							// client=clientrepo.getDetails(meeting.getClientid());
							String pushmsg = "Your meeting is scheduled with" + " " + meeting.getClient().getName() + " "
									+ "at" + " " + meeting.getFromtime() + "." + meeting.getReminder() + " "
									+ "minutes  from now.";
							/*SendMessage.msg(meeting.getClient().getMobile(), pushmsg);*/
							List<TokenBean> tokenlist = new ArrayList<TokenBean>();
							List<Integer> employeeidList = new ArrayList<Integer>();
							employeeidList = meetingrepo.getEmployeeIdByMeetingId(meeting.getId());
							Iterator<Integer> it2 = employeeidList.iterator();
							while (it2.hasNext()) {
								Integer employeeid = it2.next();
								tokenlist = tokenservice.getTokenByEmployeeid(employeeid);
								TokenBean token = new TokenBean();
								Iterator<TokenBean> it1 = tokenlist.iterator();
								while (it1.hasNext()) {
									token = it1.next();
									if (token.getDeviceType().equals("android")) {
										AndroidPushNotification.sendPushNotification(token.getToken(), pushmsg);
										logger.info(pushmsg);
									} else {
										newbadge=badgeEntity.getBadgeCount()+1;
										ApplePushNotifications.sendNotification(token.getToken(), pushmsg,newbadge);
										badgeEntity.setBadgeCount(newbadge);
										tokenrepo.saveBadge(badgeEntity);
										
									}

								}

							}

						}
					} else {
						System.out.println(meeting.getMeetingdate());
						
					}

				}	
			}

		} catch (Exception e) {
			logger.info(e);// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		
	}

//	@Scheduled(cron = "0 01 00 * * ?",zone = "Asia/Kolkata")
	public void scheduleTaskUsingCronExpression() {

		try {
			List<ClientEntity> list = clientrepo.getClientList(null, null);
			Iterator<ClientEntity> it = list.iterator();
			ClientEntity clientEntity = null;

			while (it.hasNext()) {
				clientEntity = new ClientEntity();
				clientEntity = it.next();

				calanni.setTime(clientEntity.getAnniversary());
				int month = calanni.get(Calendar.MONTH);
				int newmonthanni = month + 1;
				int dayanni = calanni.get(Calendar.DAY_OF_MONTH);

				caladob.setTime(clientEntity.getDob());
				int monthdob = caladob.get(Calendar.MONTH);
				int newmonthdob = monthdob + 1;
				int daydob = caladob.get(Calendar.DAY_OF_MONTH);

				Date currentdate = new Date();
				currendatecalender.setTime(currentdate);
				int currentmonth = currendatecalender.get(Calendar.MONTH);
				int currentmonth1 = currentmonth + 1;
				int currentday = currendatecalender.get(Calendar.DAY_OF_MONTH);
				if (currentmonth1 == newmonthanni && currentday == dayanni) {
					/*SendMessage.msg(clientEntity.getMobile(),
							"Congratulations for another wonderful year of falling in love with each other. Happy Anniversary!"
									+ clientEntity.getName());*/
				} else if (currentmonth1 == newmonthdob && currentday == daydob) {
					/*SendMessage.msg(clientEntity.getMobile(), clientEntity.getName()
							+ ",Happy birthday! I hope all your birthday wishes and dreams come true.");*/
				}

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

 //  @Scheduled(fixedDelay =30000)
	public void taskScheduler() throws Exception {
    	
    	Date convertedtime = TimezoneConverter.getDate(new Date());
		SimpleDateFormat localDateFormat = new SimpleDateFormat("HH:mm");
		String time = localDateFormat.format(convertedtime);
		Date currenttime = localDateFormat.parse(time);
		List<TokenBean> tokenlist = null;
		TokenBean token = null;
		
		
		
		
		
		
		List<EmployeeTask> tasklist = employeeRepo.employeeTaskList(null, null);
		
		
		if(tasklist.isEmpty())
		{
			System.out.println("No task Found");
		}
		else
		{
		EmployeeTask employeeTask=null;
		Iterator<EmployeeTask> it=tasklist.iterator();
		while (it.hasNext()) {
			
			
			Integer badge=null;
			employeeTask=new EmployeeTask();
			employeeTask=it.next();
			
			
			Date tasktime = localDateFormat.parse(employeeTask.getTaskTime());
			long difference = tasktime.getTime() - currenttime.getTime();
			long minutes = TimeUnit.MILLISECONDS.toMinutes(difference);
			
			Date currentdate = new Date();
			currendatecalender.setTime(currentdate);
			int currentmonth = currendatecalender.get(Calendar.MONTH);
			int currentmonth1 = currentmonth + 1;
			int currentday = currendatecalender.get(Calendar.DAY_OF_MONTH);
			
			Date date1=new SimpleDateFormat("yyyy-MM-dd").parse(employeeTask.getTaskDate());  
			calanni.setTime(date1);
			int month = calanni.get(Calendar.MONTH);
			int taskmonth = month + 1;
			int taskday= calanni.get(Calendar.DAY_OF_MONTH);
        
			if (minutes == Long.valueOf(employeeTask.getReminder()).longValue()) 
			{
				BadgeEntity badgeEntity=tokenrepo.badgeDetails(employeeTask.getDealerid(), employeeTask.getEmployeeid());
				badge=badgeEntity.getBadgeCount()+1;
					
				if(employeeTask.getAllDays().equals(1))
				{
					
					if(employeeTask.getEmployeeid()==0)
					{
						tokenlist=tokenrepo.getTokenByDealrid(employeeTask.getDealerid());
						
						Iterator<TokenBean> tokenit = tokenlist.iterator();
						while (tokenit.hasNext()) {
							token = new TokenBean();
							token = tokenit.next();
							if (token.getDeviceType().equals("android")) {
								AndroidPushNotification.sendPushNotification(token.getToken(),
										employeeTask.getTaskTitle() + " Start time" + employeeTask.getTaskTime());
							} else {
								ApplePushNotifications.sendNotification(token.getToken(),
										employeeTask.getTaskTitle() + " Start time :" + employeeTask.getTaskTime(),badge);
								badgeEntity.setBadgeCount(badge);
								tokenrepo.saveBadge(badgeEntity);
							}
						}
						
					}
					
					else
					{
						 tokenlist = tokenrepo.getTokenByEmployeeid(employeeTask.getEmployeeid());
							Iterator<TokenBean> tokenit = tokenlist.iterator();
							while (tokenit.hasNext()) {
								token = new TokenBean();
								token = tokenit.next();
								if (token.getDeviceType().equals("android")) {
									AndroidPushNotification.sendPushNotification(token.getToken(),
											employeeTask.getTaskTitle() + " Start time" + employeeTask.getTaskTime());
								} else {
									ApplePushNotifications.sendNotification(token.getToken(),
											employeeTask.getTaskTitle() + " Start time" + employeeTask.getTaskTime(),badge);
									badgeEntity.setBadgeCount(badge);
									tokenrepo.saveBadge(badgeEntity);
								}
							}
					}
				}
				
				else
				{
					if(employeeTask.getRepeatType().equalsIgnoreCase("Yearly"))
					{
					 if (currentmonth1 == taskmonth && currentday == taskday) 
	                     {
						 if(employeeTask.getEmployeeid()==0)
						 {
							 tokenlist= tokenrepo.getTokenByDealrid(employeeTask.getDealerid());
							 Iterator<TokenBean> tokenit = tokenlist.iterator();

								while (tokenit.hasNext()) {
									token = new TokenBean();
									token = tokenit.next();
									if (token.getDeviceType().equals("android")) {
										AndroidPushNotification.sendPushNotification(token.getToken(),
												employeeTask.getTaskTitle() + " Start time" + employeeTask.getTaskTime());
									} else {

										ApplePushNotifications.sendNotification(token.getToken(),
												employeeTask.getTaskTitle() + " Start time" + employeeTask.getTaskTime(),badge);
										badgeEntity.setBadgeCount(badge);
										tokenrepo.saveBadge(badgeEntity);
									}
								}
						 }
						 
						 else
						 {
							 tokenlist = tokenrepo.getTokenByEmployeeid(employeeTask.getEmployeeid());
								Iterator<TokenBean> tokenit = tokenlist.iterator();

								while (tokenit.hasNext()) {
									token = new TokenBean();
									token = tokenit.next();
									if (token.getDeviceType().equals("android")) {
										AndroidPushNotification.sendPushNotification(token.getToken(),
												employeeTask.getTaskTitle() + " Start time" + employeeTask.getTaskTime());
									} else {

										ApplePushNotifications.sendNotification(token.getToken(),
												employeeTask.getTaskTitle() + " Start time" + employeeTask.getTaskTime(),badge);
										badgeEntity.setBadgeCount(badge);
										tokenrepo.saveBadge(badgeEntity);
									}
								}
						 }
						}
				}
				else if(employeeTask.getRepeatType().equalsIgnoreCase("Monthly"))
				{
					 if (currentday == taskday) 
	                    {
						 
						 if(employeeTask.getEmployeeid()==0)
						 {
							 tokenlist=tokenrepo.getTokenByDealrid(employeeTask.getDealerid());
							 Iterator<TokenBean> tokenit = tokenlist.iterator();

								while (tokenit.hasNext()) {
									token = new TokenBean();
									token = tokenit.next();
									if (token.getDeviceType().equals("android")) {
										AndroidPushNotification.sendPushNotification(token.getToken(),
												employeeTask.getTaskTitle() + " Start time" + employeeTask.getTaskTime());
									} else {
										ApplePushNotifications.sendNotification(token.getToken(),
												employeeTask.getTaskTitle() + " Start time" + employeeTask.getTaskTime(),badge);
										badgeEntity.setBadgeCount(badge);
										tokenrepo.saveBadge(badgeEntity);
										
									}
								}
						 }
						 else
						 {
							 tokenlist = tokenrepo.getTokenByEmployeeid(employeeTask.getEmployeeid());
								Iterator<TokenBean> tokenit = tokenlist.iterator();

								while (tokenit.hasNext()) {
									token = new TokenBean();
									token = tokenit.next();
									if (token.getDeviceType().equals("android")) {
										AndroidPushNotification.sendPushNotification(token.getToken(),
												employeeTask.getTaskTitle() + " Start time" + employeeTask.getTaskTime());
									} else {
										ApplePushNotifications.sendNotification(token.getToken(),
												employeeTask.getTaskTitle() + " Start time" + employeeTask.getTaskTime(),badge);
										badgeEntity.setBadgeCount(badge);
										tokenrepo.saveBadge(badgeEntity);
										
									}
								}
						 }
						}
				
				}
				else if(employeeTask.getRepeatType().equalsIgnoreCase("Weekly"))
				{
					SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
					Date dt1 = format1.parse(formatterdate.format(converteddate));
					DateFormat format2 = new SimpleDateFormat("EEEE");
					String finalDay = format2.format(dt1);
					List<String> daylist = employeeRepo.taskRepeatList(employeeTask.getId());

					Iterator<String> dayit = daylist.iterator();
					while (dayit.hasNext()) {

						String day = dayit.next();
						System.out.println(day);

						if (day.equalsIgnoreCase(finalDay) || day.equalsIgnoreCase("All")) {
							if (employeeTask.getEmployeeid() == 0) {
								tokenlist = tokenrepo.getTokenByDealrid(employeeTask.getDealerid());
								Iterator<TokenBean> tokenit = tokenlist.iterator();

								while (tokenit.hasNext()) {
									token = new TokenBean();
									token = tokenit.next();
									if (token.getDeviceType().equals("android")) {
										AndroidPushNotification.sendPushNotification(token.getToken(),
												employeeTask.getTaskTitle() + " Start time" + employeeTask.getTaskTime());
									} else {
										ApplePushNotifications.sendNotification(token.getToken(),
												employeeTask.getTaskTitle() + " Start time" + employeeTask.getTaskTime(),badge);
										badgeEntity.setBadgeCount(badge);
										tokenrepo.saveBadge(badgeEntity);
										
									}
								}
							} else {
								tokenlist = tokenrepo.getTokenByEmployeeid(employeeTask.getEmployeeid());
								Iterator<TokenBean> tokenit = tokenlist.iterator();
								while (tokenit.hasNext()) {
									token = new TokenBean();
									token = tokenit.next();
									if (token.getDeviceType().equals("android")) {
										AndroidPushNotification.sendPushNotification(token.getToken(),
												employeeTask.getTaskTitle() + " Start time" + employeeTask.getTaskTime());
									} else {
										ApplePushNotifications.sendNotification(token.getToken(),
												employeeTask.getTaskTitle() + " Start time" + employeeTask.getTaskTime(),badge);
										
										badgeEntity.setBadgeCount(badge);
										tokenrepo.saveBadge(badgeEntity);
									}
								}
							}

						} else {
							System.out.println("Not current Day");
							logger.info("Not current Day");
						}

					}
				}
				}
				
				
				
		}
			else
			{
				System.out.println(minutes+" minutes");
			}
			
		
		}
    	
    }
    	
    	
    	
    	
    	
    	
    	
    	
    	
    }

//	@Scheduled(fixedDelay = 60000)
	public void sendProrpertyNotification() throws Exception {		
		List<PropertyClientMapping> propertyListnotification = residentialRepository.getClientPropertyNotification();
		
		if(propertyListnotification.isEmpty())
		{
			System.out.println("No Property Found");
		}
		else
			
		{
		Iterator<PropertyClientMapping> propertyit = propertyListnotification.iterator();
		ResidentialEntity residentialEntity = null;
		CommercialEntity  commercialEntity;
		ClientEntity clientEntity = null;
		while (propertyit.hasNext()) {
			PropertyClientMapping propertyClientMapping = (PropertyClientMapping) propertyit.next();
			if (propertyClientMapping.getType().equalsIgnoreCase("Sms")) {
				residentialEntity = new ResidentialEntity();
				residentialEntity = residentialRepository.getDetails(propertyClientMapping.getProductId());
				clientEntity = clientrepo.getDetails(propertyClientMapping.getClientId());

			} else if (propertyClientMapping.getType().equalsIgnoreCase("Email")) {
				
				
				if(propertyClientMapping.getProductType().equalsIgnoreCase("residential"))
				{
					residentialEntity = new ResidentialEntity();
					residentialEntity = residentialRepository.getDetails(propertyClientMapping.getProductId());
					String template = "<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"600\"><tr><td align=\"center\" bgcolor=\"white\" style=\"padding: 0px 0 0px 0;\"><img src=\"http://103.240.91.180:8009/digitalCrm/images?image="+residentialEntity.getImage()+"&folder="+propertyClientMapping.getProductType()+"\" alt=\"Template Image\" width=\"100%\" height=\"230\" style=\"display: block;\"></td></tr><tr><td style=\"padding: 20px 0 30px 0;\"><table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"550\"><tr><td colspan=\"4\" style=\"padding: 10px 0 10px 0;font-size:36px;\">~~Propertyname~~</td></tr><tr><td colspan=\"4\" style=\"padding: 20px 0 30px 0;font-size:24px;text-decoration:underline;\">~~description~~</tr><tr><tr style=\"text-align:center;\"><td style=\"padding: 10px 0 10px 0;\">~~bed~~</td><td style=\"padding: 10px 0 10px 0;\">~~bath~~</td><td style=\"padding: 10px 0 10px 0;\">~~area~~</td><td style=\"padding: 10px 0 10px 0;\">~~property~~</td></tr></table></td></tr></table>";
					String template1 = template.replace("~~Propertyname~~", residentialEntity.getPropertyname());
					String template2 = template1.replace("~~description~~", residentialEntity.getDescription());
					String template3 = template2.replace("~~bed~~", residentialEntity.getBedroom() + " Bedrooms,");
					String template4 = template3.replace("~~bath~~", residentialEntity.getBathroom() + " Bathroom,");
					String template5 = template4.replace("~~area~~","Area :" + residentialEntity.getArea() + " " + residentialEntity.getAreatype() + ",");
					String template6 = template5.replace("~~property~~","Prorperty Type : " + residentialEntity.getPropertytype());
					
					if(propertyClientMapping.getEnquiryFor().equalsIgnoreCase("enquiry"))
					{
						EnquiryEntity  enquiryEntity=  enquiryRepository.getEnquiryDetails(propertyClientMapping.getClientId());
						SendMail.send(enquiryEntity.getEmail(), template6, "Residential Property Details");
					}
					
					else
					{
						clientEntity = clientrepo.getDetails(propertyClientMapping.getClientId());
						SendMail.send(clientEntity.getEmail(), template6, "Residential Property Details");	
					}
					
				}
				else if(propertyClientMapping.getProductType().equalsIgnoreCase("commercial"))
				{
					
					try {

						commercialEntity=new CommercialEntity();
						commercialEntity=commercialRepository.getDetails(propertyClientMapping.getProductId());
						
						String template = "<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"600\"><tr><td align=\"center\" bgcolor=\"white\" style=\"padding: 0px 0 0px 0;\"><img src=\"http://95.216.153.174:8080/Lead/images?image="+commercialEntity.getImage()+"&folder="+propertyClientMapping.getProductType()+"\" alt=\"Template Image\" width=\"100%\" height=\"230\" style=\"display: block;\"></td></tr><tr><td style=\"padding: 20px 0 30px 0;\"><table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"550\"><tr><td colspan=\"4\" style=\"padding: 10px 0 10px 0;font-size:36px;\">~~Propertyname~~</td></tr><tr><td colspan=\"4\" style=\"padding: 20px 0 30px 0;font-size:24px;text-decoration:underline;\">~~description~~</tr><tr><tr style=\"text-align:center;\"><td style=\"padding: 10px 0 10px 0;\">~~bed~~</td><td style=\"padding: 10px 0 10px 0;\">~~bath~~</td><td style=\"padding: 10px 0 10px 0;\">~~area~~</td><td style=\"padding: 10px 0 10px 0;\">~~property~~</td></tr></table></td></tr></table>";

						String template1 = template.replace("~~Propertyname~~", commercialEntity.getProjectname());
						String template2 = template1.replace("~~description~~", commercialEntity.getDescription());
						String template3 = template2.replace("~~bed~~", "Maintainence : "+commercialEntity.getMaintenance()+"Rs, " + commercialEntity.getMaintenancetype()+", ");
						String template4 = template3.replace("~~bath~~", "Locality: "+commercialEntity.getLocality()+","+commercialEntity.getCity()+", ");
						String template5 = template4.replace("~~area~~","Area :" + commercialEntity.getArea() + " " + commercialEntity.getAreatype() + ", ");
						String template6 = template5.replace("~~property~~","Prorperty Type : " + commercialEntity.getPropertytype());
					
						if(propertyClientMapping.getEnquiryFor().equalsIgnoreCase("enquiry"))
						{
							EnquiryEntity  enquiryEntity=  enquiryRepository.getEnquiryDetails(propertyClientMapping.getClientId());
							SendMail.send(enquiryEntity.getEmail(), template6, "Commercial Property Details");
						}
						
						else
						{
							clientEntity = clientrepo.getDetails(propertyClientMapping.getClientId());
							SendMail.send(clientEntity.getEmail(), template6, "Commercial Property Details");	
						}
						
					} catch (Exception e) {
						// TODO: handle exception
						
						e.printStackTrace();
					}
					

					
				}
				else
				{
					
					if(propertyClientMapping.getEnquiryFor().equalsIgnoreCase("enquiry"))
					{
						EnquiryEntity  enquiryEntity=  enquiryRepository.getEnquiryDetails(propertyClientMapping.getClientId());
						SendMail.send(enquiryEntity.getEmail(), "Project Details", "Project  Details");
					}
					
					else
					{
						clientEntity = clientrepo.getDetails(propertyClientMapping.getClientId());
						SendMail.send(clientEntity.getEmail(), "Project Details", "Project  Details");	
					}
					
					
				}
				propertyClientMapping.setStatus(1);
				residentialRepository.saveClientPropertyNotification(propertyClientMapping, "update");
			} else 
			{
				/*residentialEntity = new ResidentialEntity();
				residentialEntity = residentialRepository.getDetails(propertyClientMapping.getProductId());
				clientEntity = clientrepo.getDetails(propertyClientMapping.getClientId());
*/
			}

		}
	}
	}
	
	
	
	
	//@Scheduled(fixedDelay =5000)
	private void enquiryMeetingNotification() throws Exception
	{
	List<EnquiryMeetingEntity> list=enquiryRepository.getAllEnquiryMeeting();
	
	if(list.isEmpty())
	{
		System.out.println("No meeting Found");
	}
	else
	{
		Iterator<EnquiryMeetingEntity> it=list.iterator();
		while (it.hasNext()) {
			Integer newbage=null;
			EnquiryMeetingEntity enquiryMeetingEntity = (EnquiryMeetingEntity) it.next();
			
			
			Date convertedtime = TimezoneConverter.getDate(new Date());
			SimpleDateFormat localDateFormat = new SimpleDateFormat("HH:mm");
			String time = localDateFormat.format(convertedtime);
			Date currenttime = localDateFormat.parse(time);
			List<TokenBean> listtoken=null;
			String msg="Title : "+enquiryMeetingEntity.getTitle()+", Date : "+enquiryMeetingEntity.getMeetingDate()+", Start time :"+enquiryMeetingEntity.getFromTime()+", Location :"+enquiryMeetingEntity.getLocation();
			
			TokenBean token;
			Date tasktime = localDateFormat.parse(enquiryMeetingEntity.getFromTime());
			long difference = tasktime.getTime() - currenttime.getTime();
			long minutes = TimeUnit.MILLISECONDS.toMinutes(difference);
			
			if(minutes==enquiryMeetingEntity.getReminder())
			{
				if(enquiryMeetingEntity.getEmployeeId()==0)
				{
					 listtoken=tokenrepo.getTokenByDealrid(enquiryMeetingEntity.getDealerId());
				
					Iterator<TokenBean> tokenit = listtoken.iterator();
					while (tokenit.hasNext()) {
						token = new TokenBean();
						token = tokenit.next();
						if (token.getDeviceType().equals("android")) {
							AndroidPushNotification.sendPushNotification(token.getToken(),msg);
						} else {
							BadgeEntity badgeEntity=tokenrepo.badgeDetails(enquiryMeetingEntity.getDealerId(), enquiryMeetingEntity.getEmployeeId());
							
							newbage=badgeEntity.getBadgeCount()+1;
							ApplePushNotifications.sendNotification(token.getToken(),msg,newbage);
							badgeEntity.setBadgeCount(newbage);
							tokenrepo.saveBadge(badgeEntity);
						}
					}
					enquiryMeetingEntity.setReminderStatus(digitalCrmConstant.STATUS_ACTIVE);
					enquiryRepository.saveEnquiryMeeting(enquiryMeetingEntity);
				
				}
				else
				{
					listtoken = tokenrepo.getTokenByEmployeeid(enquiryMeetingEntity.getEmployeeId());
					Iterator<TokenBean> tokenit = listtoken.iterator();
					while (tokenit.hasNext()) {
						token = new TokenBean();
						token = tokenit.next();
						if (token.getDeviceType().equals("android")) {
							AndroidPushNotification.sendPushNotification(token.getToken(),msg);
						} else {
							BadgeEntity badgeEntity=tokenrepo.badgeDetails(enquiryMeetingEntity.getDealerId(), enquiryMeetingEntity.getEmployeeId());
							
							newbage=badgeEntity.getBadgeCount()+1;
							ApplePushNotifications.sendNotification(token.getToken(),msg,newbage);
							badgeEntity.setBadgeCount(newbage);
							tokenrepo.saveBadge(badgeEntity);
						}
					}
					enquiryMeetingEntity.setReminderStatus(digitalCrmConstant.STATUS_ACTIVE);
				enquiryRepository.saveEnquiryMeeting(enquiryMeetingEntity);
				
				}
			}
			else
			{
				System.out.println("Extra Time"+minutes);
			}
				
			
			
			
			
			
			
			
			
			
			
			
			
		}
	}
	}
	
	

	public static void main(String[] args) {
		System.out.println(new Date());
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String strDate = formatter.format(new Date());
		System.out.println(strDate);
	}

	@Override
	public void calculateData() {
		// TODO Auto-generated method stub

	}
}