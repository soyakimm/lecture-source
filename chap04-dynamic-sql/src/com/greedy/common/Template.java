package com.greedy.common;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Template {
	
	private static SqlSessionFactory sqlSessionFactory;
	
	public static SqlSession getSqlSession() {
		
		if(sqlSessionFactory == null ) {
			String resource = "mybatis-config.xml";
			try {
				InputStream inputStream = Resources.getResourceAsStream(resource);
				sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream); 
				// SqlSessionFactoryBuilder() : 한번만 생성하고, 더 이상 유지되지 않도록함
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		return sqlSessionFactory.openSession(false);
		
	}

}
