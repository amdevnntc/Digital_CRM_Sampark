package com.sampark.digitalCrm.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="employee_task")
public class EmployeeTask {
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="task_Title")
	private String taskTitle;
	
	@Column(name="task_Location")
	private String taskLocation;
	
	@Column(name="task_Date")
	private String taskDate;
	
	@Column(name="task_Time")
	private String taskTime;
	
	@Column(name="repeat_Type")
	private String repeatType;
	
	@Column(name="all_Days")
	private Boolean allDays;
	
	@Column(name="employee_id")
	private Integer employeeid;
	
	@Column(name="dealer_id")
	private Integer dealerid;
	
	@Column(name="reminder")
	private String reminder;
	
	@Column(name="created_on")
	private Date createdOn;
	
	@Column(name="MODIFIED_ON")
	private Date modifiedon;
	
	@Column(name="ENABLED")
	private Integer enabled;
	
	@Column(name="description")
	private String description;
	
	
	
	
	@Transient
	private List<String> repeatDays;
	
	@Transient
	private String days;

	
	
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTaskTitle() {
		return taskTitle;
	}

	public void setTaskTitle(String taskTitle) {
		this.taskTitle = taskTitle;
	}

	public String getTaskLocation() {
		return taskLocation;
	}

	public void setTaskLocation(String taskLocation) {
		this.taskLocation = taskLocation;
	}

	public String getTaskDate() {
		return taskDate;
	}

	public void setTaskDate(String taskDate) {
		this.taskDate = taskDate;
	}

	public String getTaskTime() {
		return taskTime;
	}

	public void setTaskTime(String taskTime) {
		this.taskTime = taskTime;
	}

	public String getRepeatType() {
		return repeatType;
	}

	public void setRepeatType(String repeatType) {
		this.repeatType = repeatType;
	}

	public Boolean getAllDays() {
		return allDays;
	}

	public void setAllDays(Boolean allDays) {
		this.allDays = allDays;
	}

	public Integer getEmployeeid() {
		return employeeid;
	}

	public void setEmployeeid(Integer employeeid) {
		this.employeeid = employeeid;
	}

	public Integer getDealerid() {
		return dealerid;
	}

	public void setDealerid(Integer dealerid) {
		this.dealerid = dealerid;
	}

	public String getReminder() {
		return reminder;
	}

	public void setReminder(String reminder) {
		this.reminder = reminder;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Date getModifiedon() {
		return modifiedon;
	}

	public void setModifiedon(Date modifiedon) {
		this.modifiedon = modifiedon;
	}

	public Integer getEnabled() {
		return enabled;
	}

	public void setEnabled(Integer enabled) {
		this.enabled = enabled;
	}

	public List<String> getRepeatDays() {
		return repeatDays;
	}

	public void setRepeatDays(List<String> repeatDays) {
		this.repeatDays = repeatDays;
	}

	public String getDays() {
		return days;
	}

	public void setDays(String days) {
		this.days = days;
	}

	@Override
	public String toString() {
		return "EmployeeTask [id=" + id + ", taskTitle=" + taskTitle + ", taskLocation=" + taskLocation + ", taskDate="
				+ taskDate + ", taskTime=" + taskTime + ", repeatType=" + repeatType + ", allDays=" + allDays
				+ ", employeeid=" + employeeid + ", dealerid=" + dealerid + ", reminder=" + reminder + ", createdOn="
				+ createdOn + ", modifiedon=" + modifiedon + ", enabled=" + enabled + ", description=" + description
				+ ", repeatDays=" + repeatDays + ", days=" + days + "]";
	}

	
	
	
}
