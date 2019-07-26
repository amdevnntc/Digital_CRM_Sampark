package com.sampark.digitalCrm.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="meeting_emplyee_mapping")
public class MeetingEmployeeEntity {
	
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="employee_id")
	private Integer employeeid;
	
	
	@Column(name="meeting_id")
	private Integer meetingid;
	
	@Column(name="dealer_id")
	private Integer dealerid;
	
	@Column(name="employee_meeting_status")
	private Integer employeeMeetingStatus;
	
	@Column(name="ENABLED")
	private Integer enabled;
	
	@Column(name="meeting_date")
	private Date meetingDate;

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

	public Integer getMeetingid() {
		return meetingid;
	}

	public void setMeetingid(Integer meetingid) {
		this.meetingid = meetingid;
	}

	public Integer getDealerid() {
		return dealerid;
	}

	public void setDealerid(Integer dealerid) {
		this.dealerid = dealerid;
	}

	public Integer getEmployeeMeetingStatus() {
		return employeeMeetingStatus;
	}

	public void setEmployeeMeetingStatus(Integer employeeMeetingStatus) {
		this.employeeMeetingStatus = employeeMeetingStatus;
	}

	public Integer getEnabled() {
		return enabled;
	}

	public void setEnabled(Integer enabled) {
		this.enabled = enabled;
	}

	public Date getMeetingDate() {
		return meetingDate;
	}

	public void setMeetingDate(Date meetingDate) {
		this.meetingDate = meetingDate;
	}

	@Override
	public String toString() {
		return "MeetingEmployeeEntity [id=" + id + ", employeeid=" + employeeid + ", meetingid=" + meetingid
				+ ", dealerid=" + dealerid + ", employeeMeetingStatus=" + employeeMeetingStatus + ", enabled=" + enabled
				+ ", meetingDate=" + meetingDate + "]";
	}

	

}
