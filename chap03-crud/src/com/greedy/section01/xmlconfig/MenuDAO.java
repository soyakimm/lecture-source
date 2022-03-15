package com.greedy.section01.xmlconfig;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class MenuDAO {

	public List<MenuDTO> selectAllMenu(SqlSession sqlSession) {
		
		return sqlSession.selectList(/*수행되어야할 sql쿼리문*/ "MenuMapper.selectAllMenu");
		//Mapper.xml: namespace속성에 / selsectAllMenu: id속성
	}

	/*2번*/
	public MenuDTO selectMenuByCode(SqlSession sqlSession, int code) {
		return sqlSession.selectOne( "MenuMapper.selectMenuByCode", code );
	}

	/*3번*/
	public int insertMenu(SqlSession sqlSession, MenuDTO menu) {
		return sqlSession.insert("MenuMapper.insertMenu", menu);
		//menuMapper 네임스페이스를 가지고 있는 매퍼 안에서 insertMenu 엘리먼트를 수행하고, menu인스턴스를 넘긴다.
	}
	

	/*4번*/
	public int updateMenu(SqlSession sqlSession, MenuDTO menu) {
		return sqlSession.update("MenuMapper.updateMenu", menu);
	}


	
	/*5번*/
	public int deleteMenu(SqlSession sqlSession, int code) {
		return sqlSession.delete("MenuMapper.deleteMenu", code);
	}


}
