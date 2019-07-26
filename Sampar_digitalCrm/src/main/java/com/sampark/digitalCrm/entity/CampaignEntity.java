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
@Table(name="tbl_campaign")
public class CampaignEntity {
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	
	@Column(name="name")
	private String name;
	
	@Column(name="file_name")
	private String filename;
	
	
	
	@Column(name="description")
	private String description;
	
	
	@Column(name="employee_id")
	private Integer employeeid;
	
	@Column(name="dealer_id")
	private Integer dealerid;
	
	
	@Column(name="created_on")
	private Date createdOn;
	
	@Column(name="modified_on")
	private Date modifiedon;
	
	@Column(name="enabled")
	private Integer enabled;
	
	
	@Column(name="template")
	private String template;
	
	@Column(name="start_date")
    private Date startDate;	
	
	@Column(name="end_Date")
	private Date endDate;
	
	@Transient
	private List<String> email;
	
	@Transient
	private List<String> mobile;
	
	@Transient
	public String notifiyBy;
	
	@Transient
	public Integer templateid;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public String getTemplate() {
		return template;
	}

	public void setTemplate(String template) {
		this.template = template;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public List<String> getEmail() {
		return email;
	}

	public void setEmail(List<String> email) {
		this.email = email;
	}

	public List<String> getMobile() {
		return mobile;
	}

	public void setMobile(List<String> mobile) {
		this.mobile = mobile;
	}

	public String getNotifiyBy() {
		return notifiyBy;
	}

	public void setNotifiyBy(String notifiyBy) {
		this.notifiyBy = notifiyBy;
	}

	public Integer getTemplateid() {
		return templateid;
	}

	public void setTemplateid(Integer templateid) {
		this.templateid = templateid;
	}

	@Override
	public String toString() {
		return "CampaignEntity [id=" + id + ", name=" + name + ", filename=" + filename + ", description=" + description
				+ ", employeeid=" + employeeid + ", dealerid=" + dealerid + ", createdOn=" + createdOn + ", modifiedon="
				+ modifiedon + ", enabled=" + enabled + ", template=" + template + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", email=" + email + ", mobile=" + mobile + ", notifiyBy=" + notifiyBy
				+ ", templateid=" + templateid + "]";
	}

	
	
}
