package com.greedy.section02.javaconfig;

import java.util.List;
import static com.greedy.section02.javaconfig.Template.getSqlSession; /* static 부분 import자동으로 안됨 */
import org.apache.ibatis.session.SqlSession;

public class MenuService {

	private MenuMapper menuMapper;
	
	
	public List<MenuDTO> selectAllMenu() {
		
		SqlSession sqlSession = getSqlSession();
		
		/* sqlSession은 요청 단위 생성이다. 따라서 getMapper로 메소드 스코프로 매번 불러와야 한다. */
		menuMapper = sqlSession.getMapper(MenuMapper.class);
		List<MenuDTO> menuList = menuMapper.selectAllMenu(); /*sqlSession인스턴스 요청*/
		
		sqlSession.close(); //만들었던 session을 닫아주기
		
		return menuList;
	}

	/*2번*/
	public MenuDTO selectMenuByCode(int code) {
		
		SqlSession sqlSession = getSqlSession();
		
		menuMapper = sqlSession.getMapper(MenuMapper.class);
		MenuDTO menu = menuMapper.selectMenuByCode(code);
		
		sqlSession.close();
		
		return menu;
	}

	
	/*3번*/
	public boolean registMenu(MenuDTO menu) {
		
		return false; 
	}

	/*4번*/
	public boolean modifyMenu(MenuDTO menu) {
		
		return false;
	}

	
	/*5번*/
	public boolean deleteMenu(int code) {
		
		return false;
		
	}


}
