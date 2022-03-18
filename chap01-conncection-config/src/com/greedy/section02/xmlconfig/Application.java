package com.greedy.section02.xmlconfig;

import java.io.IOException;
import java.io.InputStream;
  
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Application {

	public static void main(String[] args) {

		String resource = "com/greedy/section02/xmlconfig/mybatis-config.xml"; // 파일경로잡기
		
		try {
			InputStream inputStream = Resources.getResourceAsStream(resource); // 경로에 있는 파일을 stream으로 얻어오겠다.
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream); //build를 수행 : sqlSessionFactory생성
			
			SqlSession session = sqlSessionFactory.openSession(false); //false: 수동으로 커밋
			 
			java.util.Date date = session.selectOne("mapper.selectSysdate"); //selectOne: 조회해온 값이 단 하나의 행이다.
			//mapper: namespace , selectSysdate: id == namespace.id
			
			System.out.println(date);
			
			session.close(); //sql session 닫기
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}  
		
		
	}

}
