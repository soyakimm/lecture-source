package com.greedy.section01.xmlmapper;

import java.util.List;

import com.greedy.common.CategoryAndMenuDTO;
import com.greedy.common.MenuAndCategoryDTO;
import com.greedy.common.MenuDTO;

public interface ElementTestMapper {

	List<String> selectCacheTest();

	List<MenuDTO> selectResultMapTest();

	List<MenuDTO> selectResultMapConstructorTest();

	List<MenuAndCategoryDTO> selectResultMapAssociationTest();

	List<CategoryAndMenuDTO> selectResultMapCollectionTest();

	List<MenuDTO> selectSqlTest();

	int insertNewCategory(MenuAndCategoryDTO menuAndCategory);

	int insertNewMenu(MenuAndCategoryDTO menuAndCategory);

}

