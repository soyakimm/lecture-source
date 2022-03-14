package com.greedy.section01.javaconfig;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

public class Application {

	/*연결방법*/
	private static String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static String USER = "C##GREEDY";
	private static String PASSWORD = "GREEDY";
	
	public static void main(String[] args) {
		/*DB접속에 관한 환경 설정
		 -----------------------------------
		 JdbcTransactionFactory : 수동커밋
		 ManagedTransactionFactory : 자동커밋
		 -----------------------------------
		 PooledDataSource : ConnectionPool 사용
		 UnPolledDataSource : ConnectionPool 미사용
		 --------------------------------------
		 */
		
		Environment environment = new Environment("dev" //환경정보이름 설정
												  , new JdbcTransactionFactory() //트랜잭션 매니저 종류 설정
												  , new PooledDataSource(DRIVER, URL, USER, PASSWORD)); //Connection Pool 사용 유무
		
		/* 생성한 환경 설정 정보를 가지고 마이바티스 설정 객체 생성 */
		Configuration configuration = new Configuration(environment);
		
		/* 설정 객체에 매퍼 등록 */
		configuration.addMapper(Mapper.class);
		
		/* SqlSessionFactory : SqlSession 객체를 생성하기 위한 팩토리 역할을 수행하는 인터페이스 
		 * SqlSessionFactoryBuilder : SqlSessionFactory 인터페이스 타입의 하위 구현 객체를 생성하기 위한 빌드 역할 수행
		 * build() : 설정에 대한 정보를 담고 있는 Configuration 타입의 객체 혹은 외부 설정 파일과 연결 되 늣트림을 매개변수로 전달하면
		 * 			 SqlSessionFactory 인터페이스 타입의 객체를 반환하는 메소드
		 */
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
		
		/* openSession() : SqlSession 인터페이스 타입의 객체를 반환하는 메소드, boolean 타입을 인자로 전달
		 * false : Connection 인터페이스 타입 객체로 DML 수행 후 auto commit에 대한 옵션을 false로 지정(권장)
		 * true : Connection 인터페이스 타입 객체로 DML 수행 후 auto commit에 대한 옵션을 true로 지정
		 */
		SqlSession sqlSession = sqlSessionFactory.openSession(false);
		
		/* getMapper() : Configuration에 등록 된 매퍼를 동일 타입에 반환하는 메소드 */
		Mapper mapper = sqlSession.getMapper(Mapper.class);
		
		/* Mapper 인터페이스에 작성 된 메소드를 호출하여 쿼리 실행 */
		java.util.Date date = mapper.selectSysdate();
		
		System.out.println(date);
		
		/*close() : SqlSession 객체 반납 */
		sqlSession.close();

	}

}
