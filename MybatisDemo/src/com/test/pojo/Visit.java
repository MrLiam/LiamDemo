package com.test.pojo;

import java.util.Date;

public class Visit {
	private Integer visitID;
	private User user;
	private Date visitDate;
	private String visitIP;
	public Integer getVisitID() {
		return visitID;
	}
	public void setVisitID(Integer visitID) {
		this.visitID = visitID;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Date getVisitDate() {
		return visitDate;
	}
	public void setVisitDate(Date visitDate) {
		this.visitDate = visitDate;
	}
	public String getVisitIP() {
		return visitIP;
	}
	public void setVisitIP(String visitIP) {
		this.visitIP = visitIP;
	}
	
	
}
