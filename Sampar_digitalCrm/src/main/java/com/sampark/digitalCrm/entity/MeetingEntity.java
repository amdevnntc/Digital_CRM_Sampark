package com.sampark.digitalCrm.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.transaction.Transactional;

@Entity
@Table(name="client_meeting")
public class MeetingEntity {
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="employee_id")
	private Integer employeeid;
	
	@Column(name="client_id")
	private Integer clientid;
	
	@Column(name="dealer_id")
	private Integer dealerid;
	
	
	@Column(name="meeting_title")
	private String meetingtitle;

	@Column(name="meeting_desc")
	private String meetingdesc;
	
	@Column(name="location")
	private String location;
	
	@Column(name="reminder")
	private String reminder;
	
	@Column(name="meeting_date")
	private Date meetingdate;
	
	
	@Column(name="from_time")
	private String fromtime;
	

	@Column(name="to_time")
	private String totime;
	
	@Column(name="CREATED_ON")
	private Date createdon;
	
	
	@Column(name="MODIFIED_ON")
	private Date modifiedon;
	
	@Column(name="ENABLED")
	private Integer enable;
	
	@Column(name="reminder_status")
	private Integer reminderStatus;
	
	@ManyToOne
	@JoinColumn(name="client_id",referencedColumnName="ID",insertable=false,updatable=false)
	private ClientEntity client;

	
	@Transient
	private List<Integer> employeeids;
	
	
	public List<Integer> getEmployeeids() {
		return employeeids;
	}



	public void setEmployeeids(List<Integer> employeeids) {
		this.employeeids = employeeids;
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public Integer getEmployeeid() {
		return employeeid;
	}



	public void setEmployeeid(Integer employeeid) {
		this.employeeid = employeeid;
	}



	public Integer getClientid() {
		return clientid;
	}



	public void setClientid(Integer clientid) {
		this.clientid = clientid;
	}



	public Integer getDealerid() {
		return dealerid;
	}



	public void setDealerid(Integer dealerid) {
		this.dealerid = dealerid;
	}



	public String getMeetingtitle() {
		return meetingtitle;
	}



	public void setMeetingtitle(String meetingtitle) {
		this.meetingtitle = meetingtitle;
	}



	public String getMeetingdesc() {
		return meetingdesc;
	}



	public void setMeetingdesc(String meetingdesc) {
		this.meetingdesc = meetingdesc;
	}



	public String getLocation() {
		return location;
	}



	public void setLocation(String location) {
		this.location = location;
	}



	public String getReminder() {
		return reminder;
	}



	public void setReminder(String reminder) {
		this.reminder = reminder;
	}



	public Date getMeetingdate() {
		return meetingdate;
	}



	public void setMeetingdate(Date meetingdate) {
		this.meetingdate = meetingdate;
	}



	public String getFromtime() {
		return fromtime;
	}



	public void setFromtime(String fromtime) {
		this.fromtime = fromtime;
	}



	public String getTotime() {
		return totime;
	}



	public void setTotime(String totime) {
		this.totime = totime;
	}



	public Date getCreatedon() {
		return createdon;
	}



	public void setCreatedon(Date createdon) {
		this.createdon = createdon;
	}



	public Date getModifiedon() {
		return modifiedon;
	}



	public void setModifiedon(Date modifiedon) {
		this.modifiedon = modifiedon;
	}



	public Integer getEnable() {
		return enable;
	}



	public void setEnable(Integer enable) {
		this.enable = enable;
	}



	public Integer getReminderStatus() {
		return reminderStatus;
	}



	public void setReminderStatus(Integer reminderStatus) {
		this.reminderStatus = reminderStatus;
	}



	public ClientEntity getClient() {
		return client;
	}



	public void setClient(ClientEntity client) {
		this.client = client;
	}



	@Override
	public String toString() {
		return "MeetingEntity [id=" + id + ", employeeid=" + employeeid + ", clientid=" + clientid + ", dealerid="
				+ dealerid + ", meetingtitle=" + meetingtitle + ", meetingdesc=" + meetingdesc + ", location="
				+ location + ", reminder=" + reminder + ", meetingdate=" + meetingdate + ", fromtime=" + fromtime
				+ ", totime=" + totime + ", createdon=" + createdon + ", modifiedon=" + modifiedon + ", enable="
				+ enable + ", reminderStatus=" + reminderStatus + ", employeeids=" + employeeids + ", client=" + client
				+ "]";
	}



}
