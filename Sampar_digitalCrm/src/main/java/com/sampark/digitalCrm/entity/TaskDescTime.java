package com.sampark.digitalCrm.entity;

import java.util.Date;

public class TaskDescTime {
	
	private String taskDesc;
	private Date taskTime;
	
	
	public String getTaskDesc() {
		return taskDesc;
	}
	public void setTaskDesc(String taskDesc) {
		this.taskDesc = taskDesc;
	}
	public Date getTaskTime() {
		return taskTime;
	}
	public void setTaskTime(Date taskTime) {
		this.taskTime = taskTime;
	}
	@Override
	public String toString() {
		return "TaskDescTime [taskDesc=" + taskDesc + ", taskTime=" + taskTime + "]";
	}

}
