package com.sampark.digitalCrm.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name="employee_notes")
public class EmployeeNotes {
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="notes_desc")
	private String notesDesc;
	
	@Column(name="client_id")
	private Integer clientid;
	
	@Column(name="employee_id")
	private Integer employeeid;
	
	@Column(name="dealer_id")
	private Integer dealerid;
	
	
	@CreationTimestamp
	@Column(name="created_on")
	private Date createdOn;
	
	@CreationTimestamp
	@Column(name="MODIFIED_ON")
	private Date modifiedon;
	
	@Column(name="ENABLED")
	private Integer enabled;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNotesDesc() {
		return notesDesc;
	}

	public void setNotesDesc(String notesDesc) {
		this.notesDesc = notesDesc;
	}

	public Integer getClientid() {
		return clientid;
	}

	public void setClientid(Integer clientid) {
		this.clientid = clientid;
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

	@Override
	public String toString() {
		return "EmployeeNotes [id=" + id + ", notesDesc=" + notesDesc + ", clientid=" + clientid + ", employeeid="
				+ employeeid + ", dealerid=" + dealerid + ", createdOn=" + createdOn + ", modifiedon=" + modifiedon
				+ ", enabled=" + enabled + "]";
	}

	
	
}
