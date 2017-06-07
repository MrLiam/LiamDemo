package com.test.controller;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.test.pojo.Author;

public class TestAssociationSelect {
	
	/**
	 * 关联查询
	 * 子查询与联合查询区别
	 * 联合查询：一次查询，占用资源大
	 * 子查询：N+1次查询，占用资源可大可小
	 */
	@Test
	public void associationSelect(){
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
//			全属性联合查询
			//List<Author> list = session.selectList("selectAuthorJoin");  
			//构造函数联合查询
			//List<Author> list = session.selectList("selectAuthorByConstructorJoin");
			//子查询
			/*List<Author> list = session.selectList("selectAuthorSub");
			System.out.println("========显示========");
			for (Author author : list) {
				System.out.println("===用户登录名： "+author.getUser().getUserName()+"\r\n"+"===用户真实姓名： "+author.getRealName());
			}
			System.out.println("========结束========");*/
			
			/*
			 * 测试懒加载
			 */
			List<Author> list = session.selectList("selectAuthorSub");
			for (Author author : list) {
				System.out.println("===用户真实姓名： "+author.getRealName());
				System.out.println("==============启用懒加载===========");
				System.out.println("===用户登录名： "+author.getUser().getUserName());
			}
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
