package com.test.Dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;

public interface TestUpdateUser {
	@Delete("delete from User where id=#{id}")
	public void deleteUser(Integer id);
	
	@Insert("insert into User(id,userName,password) values(#{id},#{userName},#{password})")
	public void insertUser(com.test.pojo.User user);
}
