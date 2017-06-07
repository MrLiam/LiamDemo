package com.test.pojo;

public class Author {
	private Integer id;
	private User user;
	private String realName;
	private String IDCard;
	
	 public Author() {
		// TODO Auto-generated constructor stub
		 super();
	}
	 
	 public Author(User user,String name,String idCard){
		 super();
		 this.user = user;
		 this.realName = name;
		 this.IDCard = idCard;
	 }
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getIDCard() {
		return IDCard;
	}
	public void setIDCard(String iDCard) {
		IDCard = iDCard;
	}
	
	
	
	
}
