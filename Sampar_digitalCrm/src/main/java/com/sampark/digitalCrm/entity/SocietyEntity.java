package com.sampark.digitalCrm.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "society")
public class SocietyEntity {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer societyid;

	@NotNull
	@NotBlank(message = "Name is mandatory")
	@Column(name = "societyname")
	private String societyName;

	@Column(name = "status")
	private Integer status;

	@Column(name = "created_On")
	@CreationTimestamp
	private Date createdOn;

	@Column(name = "sector_Id")
	private Integer sectorId;

	public Integer getSocietyid() {
		return societyid;
	}

	public void setSocietyid(Integer societyid) {
		this.societyid = societyid;
	}

	public String getSocietyName() {
		return societyName;
	}

	public void setSocietyName(String societyName) {
		this.societyName = societyName;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Integer getSectorId() {
		return sectorId;
	}

	public void setSectorId(Integer sectorId) {
		this.sectorId = sectorId;
	}

	@Override
	public String toString() {
		return "SocietyEntity [societyid=" + societyid + ", societyName=" + societyName + ", status=" + status
				+ ", createdOn=" + createdOn + ", sectorId=" + sectorId + "]";
	}

}
