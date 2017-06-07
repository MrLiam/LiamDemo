package com.test.controller;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.test.pojo.User;

public class TestForeach {
	
	/**
	 * item              每一次迭代结果
	 * collection        循环集合或指定类型
	 * separator         元素之间的分隔符，可选
	 * open              开始符号，可选
	 * close             关闭符号，可选
	 * index             list和数组的序号可选
	 */
	@Test
	public void m01(){
		String resource = "com/test/map/MybatisConfig.xml";
		Reader reader = null;
		SqlSession session;
		try {
			reader = Resources.getResourceAsReader(resource);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		SqlSessionFactory fac = new SqlSessionFactoryBuilder().build(reader);
		session = fac.openSession(false);
		try { 
			ArrayList<Integer> ides = new ArrayList<>();
			ides.add(2);
			ides.add(5);
			ides.add(3);
			List<User> list = session.selectList("selectUserForeach", ides);
			for (User user : list) {
				System.out.println("用户Id： "+user.getId()+" , 用户名： "+user.getUserName());
			}
			session.commit();
		}catch(Exception e){
			e.printStackTrace();
			session.rollback();
		} finally {
			session.close();
		}
	}
	
	@Test
	public void m02(){
		String resource = "com/test/map/MybatisConfig.xml";
		Reader reader = null;
		SqlSession session;
		try {
			reader = Resources.getResourceAsReader(resource);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		SqlSessionFactory fac = new SqlSessionFactoryBuilder().build(reader);
		session = fac.openSession(false);
		try { 
			ArrayList<User> list = new ArrayList<User>();
			User u1 = new User("liam", "siyi");
			User u2 = new User("tang", "jiao");
			list.add(u1);
			list.add(u2);
			session.insert("insertUserForeach", list);
			session.commit();
		}catch(Exception e){
			e.printStackTrace();
			session.rollback();
		} finally {
			session.close();
		}
	}
}
