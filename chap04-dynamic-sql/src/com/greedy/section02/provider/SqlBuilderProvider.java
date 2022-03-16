package com.greedy.section02.provider;

import org.apache.ibatis.jdbc.SQL;

import com.greedy.common.MenuDTO;

public class SqlBuilderProvider {
	
	/*등록할 정보에 대한 메뉴 */
	public String registMenu(MenuDTO menu) {
		
		SQL sql = new SQL();
		
		sql.INSERT_INTO("TBL_MENU")
			.VALUES("MENU_CODE", "SEQ_MENU_CODE.NEXTVAL")
			.VALUES("MENU_NAME", "#{name}")
			.VALUES("MENU_PRICE", "#{price}")
			.VALUES("CATEGORY_CODE", "#{categoryCode}")
			.VALUES("ORDERABLE_STATUS",	"#{orderableStatus}");
		
		return sql.toString();
	}
	
	/* 기본 메뉴 수정하기 */
	public String modifyMenu(MenuDTO menu) {
		
		SQL sql = new SQL();
		
		/* 비어있지 않은 값만 업데이트 되는 동적 쿼리를 작성한다. */
		sql.UPDATE("TBL_MENU");
		
		/*set조건설정
		 * 메뉴의 getName이 널이 아니고, 빈 문자열이 아닐 경우 -> updateset절에 적어줘요
		 * */
		if(menu.getName() != null && !"".equals(menu.getName())) {
			sql.SET("MENU_NAME = #{name}");
		}
		
		if(menu.getPrice() > 0) {
			sql.SET("MENU_PRICE = #{price}");
		}
		
		if(menu.getCategoryCode() > 0 ) {
			sql.SET("CATEGORY_CODE = #{categoryCode}");
		}
		
		if(menu.getOrderableStatus() != null && !"".equals(menu.getOrderableStatus())) {
			sql.SET("ORDERABLE_STATUS = #{orderableStatus}");
		}
		
		/*where절*/
		sql.WHERE("MENU_CODE = #{code}"); //모든 메뉴를 '문자열'로 return
		
		return sql.toString();
	}
	
	/* 마음에 들지 않는 메뉴 삭제하기 -깃 */
	public String deleteMenu() {
		
		SQL sql = new SQL();
		
		sql.DELETE_FROM("TBL_MENU")
			.WHERE("MENU_CODE = #{ code }");
		
		return sql.toString();
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
