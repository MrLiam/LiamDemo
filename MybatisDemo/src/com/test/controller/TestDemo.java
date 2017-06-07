package com.test.controller;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.test.pojo.User;

public class TestDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("hello World");
		String resource = "com/test/map/MybatisConfig.xml";
		//使用类加载器加载mybatis的配置文件（它也加载关联的映射文件）
		InputStream is = TestDemo.class.getClassLoader().getResourceAsStream(resource);
		//构建sqlSession的工厂
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
		 //使用MyBatis提供的Resources类加载mybatis的配置文件（它也加载关联的映射文件）
        //Reader reader = Resources.getResourceAsReader(resource); 
        //构建sqlSession的工厂
        //SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
        //创建能执行映射文件中sql的sqlSession
		SqlSession session = sessionFactory.openSession();
		 /**
         * 映射sql的标识字符串，
         * com.test.map.userMapper是userMapper.xml文件中mapper标签的namespace属性的值，
         * getUser是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQL
         */
		//String statement = "com.test.map.userMapper.getUser";//映射sql的标识字符串
		//执行查询返回一个唯一user对象的sql
        User user = session.selectOne("getUser", 1);
        //或者如下方法
        //User user = session.selectOne(statement, 1);
        System.out.println(user);
        session.close();
	}

}
