package com.test.pojo;

import java.util.List;

public class User {
	private int id;
	private String userName;
	private String password;
	private List<Visit> visitList;
	
	public User(){
		super();
	}
	
	public User(String userName,String password){
		super();
		this.password = password;
		this.userName = userName;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	public List<Visit> getVisitList() {
		return visitList;
	}

	public void setVisitList(List<Visit> visitList) {
		this.visitList = visitList;
	}

	@Override
	public String toString(){
		return "User id="+id+" ,name="+userName+" ,password="+password;
	}
}
