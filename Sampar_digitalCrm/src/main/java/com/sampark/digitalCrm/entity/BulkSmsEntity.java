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
@Table(name="sms_details")
public class BulkSmsEntity {
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="contact")
	private String contact;

	
	@Column(name="message")
	private String message;
	
	@Column(name="dealer_id")
	private Integer dealerid;
	
	@Column(name="employee_id")
	private Integer employeeid;
	
	@Column(name="created_on")
	private Date createdOn;
	
	@Column(name="MODIFIED_ON")
	private Date modifiedon;
	
	@Column(name="ENABLED")
	private Integer enabled;
	
	@Transient
	private List<String> contacts;
	
	@Override
	public String toString() {
		return "BulkSmsEntity [id=" + id + ", contact=" + contact + ", message=" + message + ", dealerid=" + dealerid
				+ ", employeeid=" + employeeid + ", createdOn=" + createdOn + ", modifiedon=" + modifiedon
				+ ", enabled=" + enabled + ", contacts=" + contacts + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getDealerid() {
		return dealerid;
	}

	public void setDealerid(Integer dealerid) {
		this.dealerid = dealerid;
	}

	public Integer getEmployeeid() {
		return employeeid;
	}

	public void setEmployeeid(Integer employeeid) {
		this.employeeid = employeeid;
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

	public List<String> getContacts() {
		return contacts;
	}

	public void setContacts(List<String> contacts) {
		this.contacts = contacts;
	}



}
