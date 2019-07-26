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
@Table(name="tbl_badge")
public class BadgeEntity {
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	
	@Column(name="employee_Id")
	private Integer employeeId;
	
	@Column(name="dealer_Id")
	private Integer dealerId;
	
	@Column(name="badge_Count")
	private Integer badgeCount;
	
	@Column(name="created_On")
	@CreationTimestamp
	private Date createdOn;
	
	

	public Integer getBadgeCount() {
		return badgeCount;
	}

	public void setBadgeCount(Integer badgeCount) {
		this.badgeCount = badgeCount;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public Integer getDealerId() {
		return dealerId;
	}

	public void setDealerId(Integer dealerId) {
		this.dealerId = dealerId;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	@Override
	public String toString() {
		return "BadgeEntity [id=" + id + ", employeeId=" + employeeId + ", dealerId=" + dealerId + ", badgeCount="
				+ badgeCount + ", createdOn=" + createdOn + "]";
	}
	
	
	
	

}
