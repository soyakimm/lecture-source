package com.greedy.section01.javaconfig;

import org.apache.ibatis.annotations.Select;

public interface Mapper {
	
	@Select("SELECT SYSDATE FROM DUAL") /*시스템 현재 날짜 및 시간 조회*/
	java.util.Date selectSysdate();

}
