package com.greedy.section01.xmlconfig;

import java.util.List;
import static com.greedy.section01.xmlconfig.Template.getSqlSession; /* static 부분 import자동으로 안됨 */
import org.apache.ibatis.session.SqlSession;

public class MenuService {

	private final MenuDAO menuDAO;
	
	public MenuService() {
		menuDAO = new MenuDAO();
		
	}
	
	public List<MenuDTO> selectAllMenu() {
		
		SqlSession sqlSession = getSqlSession();
		
		/*전체 메뉴 조회*/
		List<MenuDTO> menuList = menuDAO.selectAllMenu(sqlSession); /*sqlSession인스턴스 요청*/
		
		sqlSession.close(); //만들었던 session을 닫아주기
		
		return menuList;
	}

	/*2번*/
	public MenuDTO selectMenuByCode(int code) {
		SqlSession sqlSession = getSqlSession();
		
		MenuDTO menu = menuDAO.selectMenuByCode(sqlSession, code);
		
		sqlSession.close(); 
		
		return null;
	}
	
	/*3번*/
	public boolean registMenu(MenuDTO menu) {
		
		SqlSession sqlSession = getSqlSession();
		
		int result = menuDAO.insertMenu(sqlSession, menu);
		
		if(result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		sqlSession.close();
		
		
		return result > 0 ? true : false; /* 0 이상이면 true 아니면 false */
	}

	/*4번*/
	public boolean modifyMenu(MenuDTO menu) {
		
		SqlSession sqlSession = getSqlSession();
		
		int result = menuDAO.updateMenu(sqlSession, menu);
		
		if(result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		sqlSession.close();
		
		return result > 0 ? true : false;
	}

	
	/*5번*/
	public boolean deleteMenu(int code) {
		
		SqlSession sqlSession = getSqlSession();
		
		int result = menuDAO.deleteMenu(sqlSession, code);
		
		if(result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		sqlSession.close();
		
		return result > 0? true: false;
		
	}


}
