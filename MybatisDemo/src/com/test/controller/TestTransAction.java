package com.test.controller;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.test.pojo.Author;
import com.test.pojo.User;

public class TestTransAction {
	
	/**
	 * 测试插入数据后，自动封装原对象的ID，完善原对象的值
	 * 测试事务是否生效
	 */
	@Test
	public void m01(){
		String resource = "com/test/map/MybatisConfig.xml";
		Reader reader = null;
		SqlSession session;
		try {
			reader = Resources.getResourceAsReader(resource);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		SqlSessionFactory fac = new SqlSessionFactoryBuilder().build(reader);
		session = fac.openSession(false);
		try {
			User user = new User("Tom", "Toms");
			//加上命名空间，以防止出现同名
			session.insert("com.test.map.userMapper.insertUser",user);
			System.out.println("返回用的的Id（）自动封装机制： "+user.getId());//只针对id设置为自增长才行
			
			Author author = new Author(user,"刘东林","19940205");
			session.insert("insertAuthor",author);
			System.out.println("未设置ID自增的  插入作者的ID为： "+author.getId());//此处返回为空null
			
			//设置自增长的author，可以返回iD
			Author author2 = new Author(user,"刘东林","199412");
			session.insert("insertAutoAuthor",author2);
			System.out.println("设置自增长   插入作者的ID为： "+author2.getId());//此处返回为空null
			System.out.println("真实姓名： "+author.getRealName());
			
			session.commit();
		}catch(Exception e){
			e.printStackTrace();
			session.rollback();
		} finally {
			// TODO: handle finally clause
			session.close();
		}
	}
	
}
