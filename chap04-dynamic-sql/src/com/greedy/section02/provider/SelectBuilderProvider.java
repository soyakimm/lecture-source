package com.greedy.section02.provider;

import java.util.List;

import org.apache.ibatis.jdbc.SQL;

import com.greedy.common.MenuDTO;
import com.greedy.common.SearchCriteria;

public class SelectBuilderProvider {
	
	
	/* [ case1 ] */
	/*메소드 정의
	 * -> SQL문을 문자열 형태로 반환하도록 반환 타입을 지정한다. */
	public String selectAllMenu() {
		
		return new SQL()
				.SELECT("MENU_CODE")
				.SELECT("MENU_NAME")
				.SELECT("MENU_PRICE")
				.SELECT("CATEGORY_CODE")
				.SELECT("ORDERABLE_STATUS")
				.FROM("TBL_MENU")
				.WHERE("ORDERABLE_STATUS = 'Y'").toString();
		/*완성된 쿼리구문이 List<MenuDTO> selectAllMenu(); 가 수행할 구문이 된다 */
				 
	}
	
	/* [ case2 ] */
	public String searchMenuByCondition(SearchCriteria searchCriteria) {
		
		SQL sql = new SQL();
		
		sql.SELECT("MENU_CODE")
		.SELECT("MENU_NAME")
		.SELECT("MENU_PRICE")
		.SELECT("CATEGORY_CODE")
		.SELECT("ORDERABLE_STATUS")
		.FROM("TBL_MENU");
		
		if("category".equals(searchCriteria.getCondition())) {
			sql.JOIN("TBL_CATEGORY USING(CATEGORY_CODE)")
				.WHERE("ORDERABLE_STATUS = 'Y'")
				.AND()
				.WHERE("CATEGORY_NAME = #{ value }");
		} else if("name".equals(searchCriteria.getCondition())) {
			/* 가변인자를 이용하면 자동 AND로 처리하기 때문에 OR를 사용해야 하는 경우 .OR() 를 이용해야 한다. */
			sql.WHERE("ORDERABLE_STATUS = 'Y'", "MENU_NAME LIKE '%' || #{ value } || '%'");
		}
		
		return sql.toString();
		
	}
	

}

