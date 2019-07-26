package com.sampark.digitalCrm.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name="tbl_enquiry_meeting")
public class EnquiryMeetingEntity {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="enquiry_Id")
    private Integer enquiryId;
	
	@Column(name="employee_Id")
    private Integer employeeId;
	
	@Column(name="dealer_Id")
	private Integer dealerId;
	
	@Column(name="meeting_Date")
    private String meetingDate;
	
	@Column(name="creatred_On")
	@CreationTimestamp
	private Date createdOn;
	
	@Column(name="modified_On")
	@CreationTimestamp
	private Date modifiedOn;
	
	@Column(name="enable")
	private Integer enabled;
	
	
	@Column(name="from_Time")
	private String fromTime;
	
	
	@Column(name="to_Time")
	private String toTime;
	
	@Column(name="title")
	private String title;
	
	
	@Column(name="description")
	private String description;
	
	
	@Column(name="location")
	private String location;
	
	
	@Column(name="reminder")
	private Integer reminder;
	
	@Column(name="reminder_Status")
	private Integer reminderStatus;
	/*
	 * @OneToMany(fetch = FetchType.EAGER, mappedBy="marketId", cascade =
	 * CascadeType.ALL) private List<MarketDataEntity> list;
	 */
	
	
	@ManyToOne(optional=false)
	@JoinColumn(name="enquiry_Id",referencedColumnName="ID",insertable=false,updatable=false)
    private EnquiryEntity enquiryEntity;
	
	
	

	public Integer getReminderStatus() {
		return reminderStatus;
	}

	public void setReminderStatus(Integer reminderStatus) {
		this.reminderStatus = reminderStatus;
	}

	public Integer getReminder() {
		return reminder;
	}

	public void setReminder(Integer reminder) {
		this.reminder = reminder;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Integer getDealerId() {
		return dealerId;
	}

	public void setDealerId(Integer dealerId) {
		this.dealerId = dealerId;
	}

	public String getFromTime() {
		return fromTime;
	}

	public void setFromTime(String fromTime) {
		this.fromTime = fromTime;
	}

	public String getToTime() {
		return toTime;
	}

	public void setToTime(String toTime) {
		this.toTime = toTime;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getEnquiryId() {
		return enquiryId;
	}

	public void setEnquiryId(Integer enquiryId) {
		this.enquiryId = enquiryId;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getMeetingDate() {
		return meetingDate;
	}

	public void setMeetingDate(String meetingDate) {
		this.meetingDate = meetingDate;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Date getModifiedOn() {
		return modifiedOn;
	}

	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

	public Integer getEnabled() {
		return enabled;
	}

	public void setEnabled(Integer enabled) {
		this.enabled = enabled;
	}

	

	public EnquiryEntity getEnquiryEntity() {
		return enquiryEntity;
	}

	public void setEnquiryEntity(EnquiryEntity enquiryEntity) {
		this.enquiryEntity = enquiryEntity;
	}

	@Override
	public String toString() {
		return "EnquiryMeetingEntity [id=" + id + ", enquiryId=" + enquiryId + ", employeeId=" + employeeId
				+ ", dealerId=" + dealerId + ", meetingDate=" + meetingDate + ", createdOn=" + createdOn
				+ ", modifiedOn=" + modifiedOn + ", enabled=" + enabled + ", fromTime=" + fromTime + ", toTime="
				+ toTime + ", title=" + title + ", description=" + description + ", location=" + location
				+ ", reminder=" + reminder + ", reminderStatus=" + reminderStatus + ", enquiryEntity=" + enquiryEntity
				+ "]";
	}

	
	
	
	
	

}
