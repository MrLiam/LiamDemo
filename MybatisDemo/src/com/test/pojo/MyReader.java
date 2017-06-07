package com.test.pojo;

public class MyReader {
	private Integer readerID;
	private User user;
	private Integer money;
	
	public MyReader(){
		super();
	}
	public MyReader(Integer readerID,Integer money,User u){
		this.readerID=readerID;
		this.money = money;
		this.user=u;
	}
	public Integer getReaderID() {
		return readerID;
	}
	public void setReaderID(Integer readerID) {
		this.readerID = readerID;
	}
	public Integer getMoney() {
		return money;
	}
	public void setMoney(Integer money) {
		this.money = money;
	}
	
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String toString(){
		return "读者Id： "+readerID+", 余额： "+money;
	}
}
