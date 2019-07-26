package com.sampark.digitalCrm;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sampark.digitalCrm.object.MenuItem;
import com.sampark.digitalCrm.service.BackgroundService;
import com.sampark.digitalCrm.util.CommonUtils;



 /* Handles requests for the application home page.
 */
@Controller
@EnableScheduling
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
    private static ResourceBundle messages = ResourceBundle.getBundle("messages");
   
     @Autowired
     BackgroundService bgservice;
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("[home] Welcome home! The client locale is {}.", locale);
		try {
		
//			auditUserAction(new UserAction(CommonUtils.getCurrentUserName(), "home", READ));
		} catch (Exception e) {
			return loginPage();
		}
		Date date = CommonUtils.getCurrentTime();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate);
		model.addAttribute("userName", CommonUtils.getCurrentUserName());
		model.addAttribute("userRoleName", CommonUtils.getCurrentUserRole());
//		model.addAttribute("appVersion", DatabaseUtils.getApplicationVersion());
		logger.debug("model attributes >> " + model);
		
		return "home";
	}
	
	

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage() {
		
//		// Check if user is already logged in, redirect to home page
//		try {
//			String loggedUser = CommonUtils.getCurrentUserName();
//			if (loggedUser != null) {
////				if (CommonUtils.isCurrentUserschoolUser()) {
//					logger.debug("[login] Logged user [" + loggedUser + "] is trying to login again, redirecting to home page...");
//					return "redirect:/";
////				} else {
////					logger.debug("[login] Logged user [" + loggedUser + "] is not an school user, redirecting to login page...");
////				}
//			}
//		} catch (Exception e) {
//			logger.debug("[login] New user request, redirecting to login page...");
//		}
		return "lead/pages/login/login";
	}

	@RequestMapping(value = "/accessDenied", method = RequestMethod.GET)
	public String accessDeniedPage(ModelMap model) {
		logger.debug("[Access_Denied] page shown to user > [" + CommonUtils.getCurrentUserName() + "]");
//		auditUserAction(new UserAction(CommonUtils.getCurrentUserName(), "accessDenied", ALERT));
		model.addAttribute("user", CommonUtils.getCurrentUserName());
		return "lead/accessDenied";
	}

	@RequestMapping(value="/logouttrack", method = RequestMethod.GET)
	public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
		try {
			logMessage("logoutschool", "Logging out school user... ");
//			auditUserAction(new UserAction(CommonUtils.getCurrentUserName(), "logout", READ));
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			if (auth != null){    
				new SecurityContextLogoutHandler().logout(request, response, auth);
			}
		} catch (Exception e) {
			logger.error("[logoutschool] Exception while logging out school user... " + e);
		}
		return "redirect:/login?logouttrack";
	}

	@RequestMapping(value="/logoutdigitalCrm", method = RequestMethod.GET)
	public String logoutNonSchoolPage (HttpServletRequest request, HttpServletResponse response) {
		try {
			
			logMessage("logoutnonschool", "Logging out non-school user... ");
//			auditUserAction(new UserAction(CommonUtils.getCurrentUserName(), "logoutnonschool", ALERT));
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			if (auth != null){    
				new SecurityContextLogoutHandler().logout(request, response, auth);
			}
		} catch (Exception e) {
			logger.error("[logoutlead] Exception while logging out non-lead user... " + e);
		}
		return "redirect:/login?logoutlead";
	}
	
	@RequestMapping(value = "/get-menu-items", method = RequestMethod.GET)
	@ResponseBody
	public MenuItem[] getMenuItems(Locale locale, Model model) {
		logMessage("get-menu-items", "");
//		auditUserAction(new UserAction(CommonUtils.getCurrentUserName(),0. "get-menu-items", READ));
		List<MenuItem> menuItem = new ArrayList<MenuItem>();
		CommonUtils.getCurrentUserRole();
		if (CommonUtils.isCurrentUserAdmin()) {
			menuItem.add(new MenuItem("home", "#/main", "glyphicon glyphicon-th text-red", messages.getString("menu.dashboard")));
			menuItem.add(new MenuItem("Bulk Sms", "#/bulk_sms", "fa fa-envelope text-yellow", messages.getString("menu.BulkSms")));
			menuItem.add(new MenuItem("Create Template", "#/template", "fa fa-envelope text-aqua", messages.getString("menu.template")));
			/*menuItem.add(new MenuItem("Mail Sync", "#/view_mail", "fa fa-envelope", messages.getString("menu.mail")));*/
			menuItem.add(new MenuItem("Sector", "#/sector", "glyphicon glyphicon-th text-red", "Sector"));
			menuItem.add(new MenuItem("City", "#/city", "glyphicon glyphicon-th text-red", "City"));
			menuItem.add(new MenuItem("Enquiry", "#/enquiry", "fa fa-envelope text-yellow", messages.getString("menu.enquiry")));
			menuItem.add(new MenuItem("employee", "#/employee", "fa fa-user-plus text-red", messages.getString("menu.employee")));
			menuItem.add(new MenuItem("Campaign", "#/campaign", "fa fa-user-plus text-yellow", messages.getString("menu.campaign")));
			menuItem.add(new MenuItem("", "", "glyphicon glyphicon-calendar text-aqua", "Meeting",
					new MenuItem[] {new MenuItem("view Meeting", "#/view_meeting","fa fa-eye text-yellow", "View Meeting")
							,new MenuItem("enquiry Meeting", "#/view_enqMeeting","fa fa-file-text-o", "Enquiry Meeting")
							,new MenuItem("view Notes", "#/view_notes","fa fa-file-text-o text-red", "View Notes")}));
			menuItem.add(new MenuItem("", "", "fa fa-users text-red", "Client",new MenuItem[] {new MenuItem("client", "#/client","fa fa-user-plus text-yellow", "Add Client"),new MenuItem("view Client", "#/view_client","fa fa-eye  text-red", "View Client"),new MenuItem("client_bulk", "#/client_bulk", "fa fa-upload  text-aqua", "Client Bulk") }));
			/*menuItem.add(new MenuItem("", "", "fa fa-building", "Property",new MenuItem[] {new MenuItem("Add Property", "#/add_inventory","fa fa-plus", "Add Property"),new MenuItem("view Property", "#/view_inventory","fa fa-eye", "View Property")}));
			*/
			menuItem.add(new MenuItem("", "", "fa fa-building text-aqua", "Inventory",new MenuItem[] {new MenuItem("Residential Property", "#/residential","fa fa-plus text-yellow", "Add Residential"),new MenuItem("view Residential", "#/view_residential","fa fa-eye text-red", "View Residential"),new MenuItem("Commercial Property", "#/commercial","fa fa-plus text-yellow", "Add Commercial"),new MenuItem("view Commercial", "#/view_commercial","fa fa-eye text-red", "View Commercial")}));
			
			menuItem.add(new MenuItem("", "", "fa fa-building text-red", "Projects",new MenuItem[] {new MenuItem("Add Projects", "#/project","fa fa-plus text-yellow", "Add Projects"),new MenuItem("view Projects", "#/view_project","fa fa-eye  text-red", "View Projects")}));
			
			
		} else if (CommonUtils.isCurrentUserDealer()){
			menuItem.add(new MenuItem("home", "#/main", "glyphicon glyphicon-th text-yellow", messages.getString("menu.dashboard")));
			menuItem.add(new MenuItem("Campaign", "#/campaign", "fa fa-user-plus text-green", messages.getString("menu.campaign")));
			menuItem.add(new MenuItem("Enquiry", "#/enquiry", "fa fa-envelope text-red", messages.getString("menu.enquiry")));
			menuItem.add(new MenuItem("", "", "glyphicon glyphicon-calendar text-aqua", "Meeting",
					new MenuItem[] {
							new MenuItem("view Meeting", "#/view_meeting","fa fa-eye text-yellow", "View Meeting")
							,new MenuItem("enquiry Meeting", "#/view_enqMeeting","fa fa-file-text-o", "Enquiry Meeting")
							,new MenuItem("view Notes", "#/view_notes","fa fa-file-text-o", "View Notes")}));
			
			menuItem.add(new MenuItem("", "", "fa fa-users text-yellow", "Client",
					new MenuItem[] {
							new MenuItem("client", "#/client","fa fa-user-plus text-yellow", "Add Client"),
							new MenuItem("view Client", "#/view_client","fa fa-eye text-green", "View Client"),
					new MenuItem("client_bulk", "#/client_bulk", "fa fa-upload text-blue", "Client Bulk") }));
			/*menuItem.add(new MenuItem("", "", "fa fa-building", "Property",new MenuItem[] {new MenuItem("Add Property", "#/add_inventory","fa fa-plus", "Add Property"),new MenuItem("view Property", "#/view_inventory_em","fa fa-eye", "View Property")}));*/
			menuItem.add(new MenuItem("", "", "fa fa-building text-yellow", "Inventory",new MenuItem[] {new MenuItem("Residential Property", "#/residential","fa fa-plus text-yellow", "Add Residential"),new MenuItem("view Residential", "#/view_residential","fa fa-eye text-aqua", "View Residential"),new MenuItem("Commercial Property", "#/commercial","fa fa-plus text-blue", "Add Commercial"),new MenuItem("view Commercial", "#/view_commercial","fa fa-eye text-blue", "View Commercial")}));
			menuItem.add(new MenuItem("", "", "fa fa-building text-aqua", "Projects",new MenuItem[] {new MenuItem("Add Projects", "#/project","fa fa-plus text-yellow", "Add Projects"),new MenuItem("view Projects", "#/view_project","fa fa-eye text-aqua", "View Projects")}));
		}
		else {
		    menuItem.add(new MenuItem("exit", "logout", "glyphicon glyphicon-off", messages.getString("menu.logout")));
	         }
		MenuItem list[] = new MenuItem[menuItem.size()];
		list = menuItem.toArray(list);
		logMessage("get-menu-items", "output size > " + list.length);
		return list;
	}
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index() {

		return "lead/pages/index/index";
	}
	
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String dashboard(Locale locale, Model model) {
		logMessage("main", "");
//		auditUserAction(new UserAction(CommonUtils.getCurrentUserName(), "dashboard", READ));
		return "lead/pages/dashboard/main";
	}
	
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public String user() {

		return "lead/pages/module/user";
	}
	
	@RequestMapping(value = "/client", method = RequestMethod.GET)
	public String showModal(Locale locale, Model model) {
		return "lead/pages/module/client";
	}
	
	
	@RequestMapping(value = "/sector", method = RequestMethod.GET)
	public String sector(Locale locale, Model model) {
		return "lead/pages/module/Sector";
	}
	
	@RequestMapping(value = "/city", method = RequestMethod.GET)
	public String city(Locale locale, Model model) {
		return "lead/pages/module/City";
	}
	
	
	@RequestMapping(value = "/client_bulk", method = RequestMethod.GET)
	public String clientBulk(Locale locale, Model model) {
		return "lead/pages/module/client_bulk";
	}
	
	
	@RequestMapping(value = "/view_client", method = RequestMethod.GET)
	public String viewClient(Locale locale, Model model) {
		return "lead/pages/module/view_client";
	}
	
	
	
	@RequestMapping(value = "/meeting", method = RequestMethod.GET)
	public String meeting() {

		return "lead/pages/module/meeting";
	}
	
	
	@RequestMapping(value = "/enquiry_meeting", method = RequestMethod.GET)
	public String enquiryMeeting() {

		return "lead/pages/module/enquiry_meeting";
	}
	@RequestMapping(value = "/view_enqMeeting", method = RequestMethod.GET)
	public String viewenquiryMeeting() {

		return "lead/pages/module/view_enqMeeting";
	}
	
	
	@RequestMapping(value = "/view_meeting", method = RequestMethod.GET)
	public String viewMeeting() {

		return "lead/pages/module/view_meeting";
	}
	
	@RequestMapping(value = "/edit_meeting", method = RequestMethod.GET)
	public String editMeeting() {

		return "lead/pages/module/edit_meeting";
	}
	
	
	
	@RequestMapping(value = "/view_notes", method = RequestMethod.GET)
	public String viewNotes() {

		return "lead/pages/module/view_notes";
	}
	@RequestMapping(value = "/help", method = RequestMethod.GET)
	public String help() {

		return "lead/pages/module/help";
	}
	
	
	@RequestMapping(value = "/employee", method = RequestMethod.GET)
	public String employee(Locale locale, Model model) {
		logMessage("employee", "");
		
		return "lead/pages/module/AddEmployee";
}
	
	
	@RequestMapping(value = "/bulk_sms", method = RequestMethod.GET)
	public String bulkSms(Locale locale, Model model) {
		logMessage("bulkSms", "");
		
		return "lead/pages/module/bulkSms";
}
	
	@RequestMapping(value = "/add_inventory", method = RequestMethod.GET)
	public String addInventory(Locale locale, Model model) {
		logMessage("add_inventory", "");
		
		return "lead/pages/module/AddInventory";
}
	
	@RequestMapping(value = "/view_inventory", method = RequestMethod.GET)
	public String viewinventory(Locale locale, Model model) {
		model.addAttribute("userRoleName", CommonUtils.getCurrentUserRole());
		return "lead/pages/module/view_inventory";
	}
	
	
	@RequestMapping(value = "/view_inventory_em", method = RequestMethod.GET)
	public String viewInventoryEmployee(Locale locale, Model model) {
		model.addAttribute("userRoleName", CommonUtils.getCurrentUserRole());
		return "lead/pages/module/view_inventory_employee";
	}
	
	
	@RequestMapping(value = "/view_mail", method = RequestMethod.GET)
	public String viewMail(Locale locale, Model model) {
	
		return "lead/pages/module/view_mail";
	}
	
	@RequestMapping(value = "/enquiry", method = RequestMethod.GET)
	public String enquiry(Locale locale, Model model) {
		logMessage("enquiry", "");
		
		return "lead/pages/module/enquiry";
}
	
	
	
	@RequestMapping(value = "/project", method = RequestMethod.GET)
	public String project(Locale locale, Model model) {
		logMessage("project", "");
		
		return "lead/pages/module/AddProject";
}
	
	@RequestMapping(value = "/view_project", method = RequestMethod.GET)
	public String viewProjects(Locale locale, Model model) {
		logMessage("project", "");
		
		return "lead/pages/module/view_projects";
}
	
	@RequestMapping(value = "/edit_project", method = RequestMethod.GET)
	public String editProject() {

		return "lead/pages/module/EditProject";
	}
	
	@RequestMapping(value = "/commercial", method = RequestMethod.GET)
	public String addCommercial(Locale locale, Model model) {
		logMessage("commercial", "");
		
		return "lead/pages/module/AddCommercialProperty";
}
	
	@RequestMapping(value = "/view_commercial", method = RequestMethod.GET)
	public String viewCommercial(Locale locale, Model model) {
		logMessage("view_commercial", "");
		
		return "lead/pages/module/view_commercial";
}
	
	
	@RequestMapping(value = "/residential", method = RequestMethod.GET)
	public String addResidential(Locale locale, Model model) {
		logMessage("commercial", "");
		
		return "lead/pages/module/AddResidentialProperty";
}
	
	@RequestMapping(value = "/view_residential", method = RequestMethod.GET)
	public String viewResidential(Locale locale, Model model) {
		logMessage("project", "");
		
		return "lead/pages/module/view_residential";
}
	
	
	@RequestMapping(value = "/edit_residential", method = RequestMethod.GET)
	public String editResidential(Locale locale, Model model) {
		logMessage("edit_residential", "");
		
		return "lead/pages/module/EditResidentialProperty";
}
	
	@RequestMapping(value = "/edit_commercial", method = RequestMethod.GET)
	public String editcommercial(Locale locale, Model model) {
		logMessage("edit_commercial", "");
		
		return "lead/pages/module/EditCommercialProperty";
}
	
	@RequestMapping(value = "/campaign", method = RequestMethod.GET)
	public String addCampaign(Locale locale, Model model) {
		logMessage("project", "");
		
		return "lead/pages/module/AddCampaign";
}

	@RequestMapping(value = "/template", method = RequestMethod.GET)
	public String createTemplate(Locale locale, Model model) {
		logMessage("template", "");
		
		return "lead/pages/module/CreateTemplate";
}
	
	

	private void logMessage(String action, String data) {
		try {
			logger.debug("[" + action + "] by [" + CommonUtils.getCurrentUserName() + "] " + data);
		} catch (Exception e) {
			logger.debug("Exception while logging action [" + action + "] message [" + data);
		}
	}
		
}