package com.test.controller;

import java.io.IOException;
import java.util.List;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.junit.Test;

import com.test.pojo.MyReader;
import com.test.pojo.User;

public class TestIfAndChoose {
	Logger log = Logger.getLogger(TestIfAndChoose.class);
	/**
	 * 测试IF标签
	 * 
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
			com.test.pojo.MyReader r = new com.test.pojo.MyReader();
			r.setMoney(200);
			/*r.setMoney(600);
			//加上命名空间，以防止出现同名
			User u = new User("liam", "testAdd");
			session.insert("com.test.map.userMapper.insertUser",u);
			r.setUser(u);
			session.insert("insertReader",r);*/
			List<MyReader> list = session.selectList("selectReaderMoney",r);
			for (MyReader myReader : list) {
				System.out.println("用户ID="+myReader.getReaderID());
				System.out.println("用户money="+myReader.getMoney());
				System.out.println("=====懒加载=====");
				if(myReader.getUser()!=null){
					System.out.println("用户名 : "+myReader.getUser().getUserName());
				}else{
					log.info("未获取到User");
				}
			}
			User u1 = session.selectOne("getUser",5);
			System.out.println(u1.toString());
			session.commit();
		}catch(Exception e){
			e.printStackTrace();
			session.rollback();
		} finally {
			session.close();
		}
	}
	
	
	/**
	 * 测试choose标签
	 * 相当于switch case表达式，只会执行一条满足条件的sql
	 */
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
			User u1 = session.selectOne("getUser",4);
			com.test.pojo.MyReader r = new com.test.pojo.MyReader();
			//r.setReaderID(1);
			r.setUser(u1);
			r.setMoney(200);
			/*r.setMoney(600);
			//加上命名空间，以防止出现同名
			User u = new User("liam", "testAdd");
			session.insert("com.test.map.userMapper.insertUser",u);
			r.setUser(u);
			session.insert("insertReader",r);*/
			List<MyReader> list = session.selectList("selectReaderChoose",r);
			for (MyReader myReader : list) {
				System.out.println("用户ID="+myReader.getReaderID());
				System.out.println("用户money="+myReader.getMoney());
				System.out.println("=====懒加载=====");
				if(myReader.getUser()!=null){
					System.out.println("用户名 : "+myReader.getUser().getUserName());
				}else{
					log.info("未获取到User");
				}
			}
			session.commit();
		}catch(Exception e){
			e.printStackTrace();
			session.rollback();
		} finally {
			session.close();
		}
	}
	
	
	/**
	 * 测试where标签
	 */
	@Test
	public void m03(){
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
			User u1 = session.selectOne("getUser",4);
			com.test.pojo.MyReader r = new com.test.pojo.MyReader();
			//r.setReaderID(1);
			r.setUser(u1);
			r.setMoney(200);
			/*r.setMoney(600);
			//加上命名空间，以防止出现同名
			User u = new User("liam", "testAdd");
			session.insert("com.test.map.userMapper.insertUser",u);
			r.setUser(u);
			session.insert("insertReader",r);*/
			List<MyReader> list = session.selectList("selectWhereTag",r);
			for (MyReader myReader : list) {
				System.out.println("用户ID="+myReader.getReaderID());
				System.out.println("用户money="+myReader.getMoney());
				System.out.println("=====懒加载=====");
				if(myReader.getUser()!=null){
					System.out.println("用户名 : "+myReader.getUser().getUserName());
				}else{
					log.info("未获取到User");
				}
			}
			session.commit();
		}catch(Exception e){
			e.printStackTrace();
			session.rollback();
		} finally {
			session.close();
		}
	}
	
	/**
	 * 利用set标签更新数据，可以去掉其中的 ','
	 * 
	 */
	@Test
	public void m04(){
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
			User u1 = session.selectOne("getUser",4);
			com.test.pojo.MyReader r = new com.test.pojo.MyReader();
			r.setReaderID(1);
			r.setUser(u1);
			r.setMoney(210);
			session.update("updateSetReader", r);
			session.commit();
		}catch(Exception e){
			e.printStackTrace();
			session.rollback();
		} finally {
			session.close();
		}
	}
	
	
	/**
	 * trim标签使用
	 */
	@Test
	public void m05(){
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
			User u1 = session.selectOne("getUser",4);
			com.test.pojo.MyReader r = new com.test.pojo.MyReader();
			r.setReaderID(1);
			r.setUser(u1);
			r.setMoney(215);
			session.update("updateTrimReader", r);
			session.commit();
		}catch(Exception e){
			e.printStackTrace();
			session.rollback();
		} finally {
			session.close();
		}
	}
	
}
