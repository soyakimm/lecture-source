package com.greedy.section01.xml;

import static com.greedy.common.Template.getSqlSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.greedy.common.MenuDTO;
import com.greedy.common.SearchCriteria;

public class MenuService {
	
	private DynamicSqlMapper mapper;

	public void selectMenuByPrice(int price) {
		
		SqlSession sqlSession = getSqlSession();
		
		/*mapper 가져오기*/
		mapper = sqlSession.getMapper(DynamicSqlMapper.class);
	
		/* 2. 기본 자료형은 조건문의 값을 비교할 수 없다. HashMap의 key 혹은 DTO의 getter를 이용하여 값을 확인한다. */
		Map<String, Integer> map = new HashMap<>();
		map.put("price", price);
		
		/*1. 메뉴에 적합한 가격대에 해당하는 메뉴오더만 가져온다*/
		List<MenuDTO> menuList = mapper.selectMenuByPrice(map);
		
		if(menuList != null && menuList.size() > 0) {
			for(MenuDTO menu : menuList) {
				System.out.println(menu);
			}
		} else {
			System.out.println("검색 결과가 존재하지 않습니다.");
		}
		
		/* (1-2) sql 동적쿼리 유의점
		 * 1. 하나의 int값 기본자료형은 가져올 수 없다. -> map타입의 key:value형식으로 넘기면 된다.*/
		
		sqlSession.close();
		
	}

	/*2번*/
	public void searchMenu(SearchCriteria searchCriteria) {
		
		SqlSession sqlSession = getSqlSession();
		mapper = sqlSession.getMapper(DynamicSqlMapper.class);
		
		List<MenuDTO> menuList = mapper.searchMenu(searchCriteria);
		
		if(menuList != null && menuList.size() > 0) {
			for(MenuDTO menu : menuList) {
				System.out.println(menu);
			}
		} else {
			System.out.println("검색 결과가 존재하지 않습니다.");
		}
		
		sqlSession.close();
	}

	public void searchMenuBySupCategory(SearchCriteria searchCriteria) {
		
		SqlSession sqlSession = getSqlSession();
		mapper = sqlSession.getMapper(DynamicSqlMapper.class);
		
		List<MenuDTO> menuList = mapper.searchMenuBySupCategory(searchCriteria);
		
		if(menuList != null && menuList.size() > 0) {
			for(MenuDTO menu : menuList) {
				System.out.println(menu);
			}
		} else {
			System.out.println("검색 결과가 존재하지 않습니다.");
		}
		
		sqlSession.close();
	}

	public void searchMenuByRandomMenuCode(List<Integer> randomMenuCodeList) {
		
		SqlSession sqlSession = getSqlSession();
		mapper = sqlSession.getMapper(DynamicSqlMapper.class);
		
		Map<String, List<Integer>> criteria = new HashMap<>();
		criteria.put("randomMenuCodeList", randomMenuCodeList);
		
		List<MenuDTO> menuList = mapper.searchMenuByRandomMenuCode(criteria);
		
		if(menuList != null && menuList.size() > 0) {
			for(MenuDTO menu : menuList) {
				System.out.println(menu);
			}
		} else {
			System.out.println("검색 결과가 존재하지 않습니다.");
		}
		
		sqlSession.close();
		
	}

	public void searchMenuByCodeOrSearchAll(SearchCriteria searchCriteria) {
		
		SqlSession sqlSession = getSqlSession();
		mapper = sqlSession.getMapper(DynamicSqlMapper.class);
				
		List<MenuDTO> menuList = mapper.searchMenuByCodeOrSearchAll(searchCriteria);
		
		if(menuList != null && menuList.size() > 0) {
			for(MenuDTO menu : menuList) {
				System.out.println(menu);
			}
		} else {
			System.out.println("검색 결과가 존재하지 않습니다.");
		}
		
		sqlSession.close();
		
	}

	public void searchMenuByNameOrCategory(Map<String, Object> searchCriteria) {
		
		SqlSession sqlSession = getSqlSession();
		mapper = sqlSession.getMapper(DynamicSqlMapper.class);
				
		List<MenuDTO> menuList = mapper.searchMenuByNameOrCategory(searchCriteria);
		
		if(menuList != null && menuList.size() > 0) {
			for(MenuDTO menu : menuList) {
				System.out.println(menu);
			}
		} else {
			System.out.println("검색 결과가 존재하지 않습니다.");
		}
		
		sqlSession.close();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}

