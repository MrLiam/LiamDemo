package com.test.controller;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.test.pojo.User;
import com.test.pojo.Visit;

/**
 * 集合查询示例
 * @author Administrator
 *
 */
public class CollectionSelect {
	
	@Test
	public void associationSelect(){
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
			List<User> list = session.selectList("selectVisit");
			for (User user : list) {
				System.out.println("===用户真实姓名： "+user.getUserName());
				for(Visit v:user.getVisitList()){
					System.out.println("登录IP: "+v.getVisitIP()+",  登录时间： "+v.getVisitDate());
					System.out.println("visitID: "+v.getVisitID()+",  用户："+v.getUser().getUserName());
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
}
