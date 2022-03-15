package com.greedy.section02.javaconfig;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

public class Template {
	
	private static String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static String URL = "jdbc:log4jdbc:oracle:thin:@localhost:1521:xe";
	private static String USER = "C##GREEDY";
	private static String PASSWORD = "GREEDY";
	
	private static SqlSessionFactory sqlSessionFactory;
	
	public static SqlSession getSqlSession() {
		
		if(sqlSessionFactory == null) {
			Environment environment =
					new Environment("dev"
							      , new JdbcTransactionFactory()
							      , new PooledDataSource(DRIVER, URL, USER, PASSWORD));
			
			Configuration configuration = new Configuration(environment);
			
			configuration.addMapper(MenuMapper.class);
			
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
		}

		return sqlSessionFactory.openSession(false);
		
	}
	
	
	
	
	
	
	
	
	

}

