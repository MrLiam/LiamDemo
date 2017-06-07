package com.test.controller;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.test.pojo.User;

public class TestDelete {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String resource ="com/test/map/MybatisConfig.xml";
		Reader reader = null;
		SqlSession session;
		try {
			reader = Resources.getResourceAsReader(resource);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder().build(reader);
		session = sqlMapper.openSession();
		try {
			User user = new User();
			user.setId(1);
			/*user.setUserName("ldl");
			user.setPassword("ldl123");*/
			session.delete("deleteUser", user);
			session.commit();
		} catch (Exception e1) {
			// TODO: handle exception
			e1.printStackTrace();
		}finally {
			session.close();
		}
	}

}
