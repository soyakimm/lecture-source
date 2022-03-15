package com.greedy.section03.remix;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface MenuMapper {

	List<MenuDTO> selectAllMenu();

	MenuDTO selectMenuByCode(int code);

	int insertMenu(MenuDTO menu);

	int updateMenu(MenuDTO menu);

	int deleteMenu(int code);

	
	
	
	
	
	
	
	
	
	
	
	
	
}

