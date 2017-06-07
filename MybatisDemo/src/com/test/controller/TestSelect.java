package com.test.controller;

import java.io.Reader;
import java.util.HashMap;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.junit.Test;

import com.test.pojo.User;

public class TestSelect {
	Logger log = Logger.getLogger(TestSelect.class);
	@Test
	public void testMapAsParameter(){
		SqlSession session = getSession();
		if(null != session){
			log.info("=====获取session成功！=====");
			HashMap<String, String> map = new HashMap<String, String>();
			map.put("userName", "Mr Liam");
			map.put("password", "I Love You,Too");
			User user = session.selectOne("selectByMap", map);
			if(user !=null ){
				System.out.println(user.toString());
			}else{
				System.out.println("登陆失败！");
			}
		}else{
			log.error("error未读取到配置文件！");
		}
	}
	
	@Test
	public void testGetMap(){
		SqlSession session = getSession();
		if(null != session){
			log.info("=====获取session成功！=====");
			HashMap<String, String> map = new HashMap();
			User user = new User("Mr Liam","I Love You,Too");
			map = session.selectOne("getReturnMap", user);
			if(map !=null ){
				System.out.println("用户名： "+map.get("userName")+" ,密码  "+map.get("password"));
			}else{
				System.out.println("登陆失败！");
			}
		}else{
			log.error("error未读取到配置文件！");
		}
	}
	
	@Test
	public void testGetList(){
		SqlSession session = getSession();
		if(null != session){
			log.info("=====获取session成功！=====");
			User user = new User("Mr Liam","I Love You,Too");
			//java.util.List<User> list = session.selectList("getReturnList", user);
			java.util.List<User> list = session.selectList("getReturnList2", user);
			if(list !=null ){
				int i = 1;
				for(User u:list){
					System.out.println("========This is the " + i +" User========");
					i++;
					System.out.println("用户名: "+u.getUserName()+"  ,密码： "+u.getPassword());
				}
				System.out.println("================Over===============");
			}else{
				System.out.println("登陆失败！");
			}
		}else{
			log.error("error未读取到配置文件！");
		}
	}
	
	@Test
	public void getFromResultMap(){
		SqlSession session = getSession();
		if(null != session){
			log.info("=====获取session成功！=====");
			User user = new User("Mr Liam","I Love You,Too");
			//java.util.List<User> list = session.selectList("getReturnList", user);
			java.util.List<User> list = session.selectList("selectByResultMap", user);
			if(list !=null ){
				int i = 1;
				for(User u:list){
					System.out.println("========This is the " + i +" User========");
					i++;
					System.out.println("用户名: "+u.getUserName()+"  ,密码： "+u.getPassword());
				}
				System.out.println("================Over===============");
			}else{
				System.out.println("登陆失败！");
			}
		}else{
			log.error("error未读取到配置文件！");
		}
	}
	
	/***
	 * 获取session类
	 */
	public SqlSession getSession(){
		String resource = "com/test/map/MybatisConfig.xml";
		Reader reader = null;
		SqlSession session = null;
		try {
			reader = Resources.getResourceAsReader(resource);
			SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
			session = sessionFactory.openSession();
		}catch(Exception e){
			e.printStackTrace();
		} 
		return session;
	}
}
