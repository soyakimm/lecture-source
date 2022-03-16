package com.greedy.section02.provider;

import org.apache.ibatis.session.SqlSession;
import static com.greedy.common.Template.getSqlSession;

import com.greedy.common.MenuDTO;

public class SqlBuilderService {
	
	private SqlBuilderMapper mapper;

	/*등록할 정보에 대한 메뉴 */
	public void registMenu(MenuDTO menu) {
		
		SqlSession sqlSession = getSqlSession();
		mapper = sqlSession.getMapper(SqlBuilderMapper.class);
		
		int result = mapper.registMenu(menu);
		
		if(result > 0 ) {
			System.out.println("신규 메뉴 등록에 성공하셨습니다.");
			sqlSession.commit();
		} else {
			System.out.println("신규 메뉴 등록에 실패하셨습니다.");
			sqlSession.rollback();
		}
		
		sqlSession.close();
		
	}
	
	/* 기본 메뉴 수정하기 -깃*/
	public void modifyMenu(MenuDTO menu) {
		
		SqlSession sqlSession = getSqlSession();
		mapper = sqlSession.getMapper(SqlBuilderMapper.class);
		
		int result = mapper.modifyMenu(menu);
		
		if(result > 0) {
			System.out.println("메뉴 정보 수정에 성공하셨습니다.");
			sqlSession.commit();
		} else {
			System.out.println("메뉴 정보 수정에 실패하셨습니다.");
			sqlSession.rollback();
		}
		
		sqlSession.close();
		
	}


	/* 마음에 들지 않는 메뉴 삭제하기 -깃 */
	public void deleteMenu(int code) {

		public void deleteMenu(int code) {
			
			SqlSession sqlSession = getSqlSession();
			mapper = sqlSession.getMapper(SqlBuilderMapper.class);
			
			int result = mapper.deleteMenu(code);
			
			if(result > 0) {
				System.out.println("메뉴 삭제에 성공하셨습니다.");
				sqlSession.commit();
			} else {
				System.out.println("메뉴 삭제에 실패하셨습니다.");
				sqlSession.rollback();
			}
			
			sqlSession.close();
			
		}


}
