package com.greedy.section02.provider;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;

import com.greedy.common.MenuDTO;
import com.greedy.common.SearchCriteria;

public interface SelectBuilderMapper {
	
	/* [ case1 ] */
	@Results(id="menuResultMap", value = {
			@Result(id = true, property = "code", column = "MENU_CODE"),
			@Result(property = "name", column = "MENU_NAME"),
			@Result(property = "price", column = "MENU_PRICE"),
			@Result(property = "categoryCode", column = "CATEGORY_CODE"),
			@Result(property = "orderableStatus", column = "ORDERABLE_STATUS")
	})

	
	/* [ case2 ] */
	@SelectProvider(type=SelectBuilderProvider.class, method="selectAllMenu")
	List<MenuDTO> selectAllMenu();

	@ResultMap("menuResultMap")
	@SelectProvider(type=SelectBuilderProvider.class, method="searchMenuByCondition")
	List<MenuDTO> searchMenuByCondition(SearchCriteria searchCriteria);

}

