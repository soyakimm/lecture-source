package com.greedy.section01.javaconfig;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
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
		
		

	}

}
