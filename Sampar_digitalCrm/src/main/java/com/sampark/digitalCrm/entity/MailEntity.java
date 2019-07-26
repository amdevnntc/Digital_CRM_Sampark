package com.sampark.digitalCrm.entity;

import java.util.Date;

import javax.mail.Address;

public class MailEntity {

	private Address From;
	private Date SentDate;
	private Date RecieveDate;
	private String Subject;
	private String Description;
	private String filename;
	
	private String contenttype;
	
	public String getContenttype() {
		return contenttype;
	}
	public void setContenttype(String contenttype) {
		this.contenttype = contenttype;
	}
	public Date getRecieveDate() {
		return RecieveDate;
	}
	public void setRecieveDate(Date recieveDate) {
		RecieveDate = recieveDate;
	}
	public Address getFrom() {
		return From;
	}
	public void setFrom(Address from) {
		From = from;
	}
	public Date getSentDate() {
		return SentDate;
	}
	public void setSentDate(Date sentDate) {
		SentDate = sentDate;
	}
	public String getSubject() {
		return Subject;
	}
	public void setSubject(String subject) {
		Subject = subject;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	@Override
	public String toString() {
		return "MailEntity [From=" + From + ", SentDate=" + SentDate + ", RecieveDate=" + RecieveDate + ", Subject="
				+ Subject + ", Description=" + Description + ", filename=" + filename + "]";
	}
	
}
