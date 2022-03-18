package com.greedy.section03.remix;

import java.util.List;
import java.util.Map;

public class MenuController {

	/* 실수로 인해 인스턴스가 변경되는 일이 없도록 final을 붙여준다 
	 * -> 즉, 초기화 되지 않으면 안된다. == null인 상태로 있으면 의미가 없다. */
	private final PrintResult printResult;
	private final MenuService menuService;
	
	public MenuController() { //생성자 안에 필드들에 대한 생성구문을 넣음 -> 생성되는 순간 -> 두개의 인스턴스 필드도 생성 -> 다시 할당 불가능
		printResult = new PrintResult();
		menuService = new MenuService();
	}
	
	
	public void selectAllMenu() {
		
		List<MenuDTO> menuList = menuService.selectAllMenu();
		
		if(menuList != null) {
			printResult.printMenuList(menuList);
		} else {
			printResult.printErrorMessage("selectList");
		}
		
	}

	/*2번*/
	public void selectAllMenuByCode(Map<String, String> parameter) {
		
		int code = Integer.parseInt(parameter.get("code"));
		
		MenuDTO menu = menuService.selectMenuByCode(code);
		
		if(menu != null ) {
			printResult.printMenu(menu);
			
		} else {
			printResult.printErrorMessage("selectOne");
		
	}
	
	
	}

	/*3번*/
	public void registMenu(Map<String, String> parameter) {
		/*요청에 담긴 데이터를 뽑는다 */
		String name = parameter.get("name");
		
		/*가공*/
		 int price = Integer.parseInt(parameter.get("price"));
		 int categoryCode = Integer.parseInt(parameter.get("categoryCode"));
		 
		 MenuDTO menu = new MenuDTO();
		 menu.setName(name);
		 menu.setPrice(price);
		 menu.setCategoryCode(categoryCode);
		 
		 if(menuService.registMenu(menu)) {
			 printResult.printSuccessMessage("insert");
		 } else {
			 printResult.printErrorMessage("insert");
		 }
	}


	/*4번*/
	public void modifyMenu(Map<String, String> parameter) {
		
		int code = Integer.parseInt(parameter.get("code"));
		String name = parameter.get("name");
		int price = Integer.parseInt(parameter.get("price"));
		int categoryCode = Integer.parseInt(parameter.get("categoryCode"));
		
		MenuDTO menu = new MenuDTO();
		menu.setCode(code);
		menu.setName(name);
		menu.setPrice(price);
		menu.setCategoryCode(categoryCode);
		
		if(menuService.modifyMenu(menu)) {
			printResult.printSuccessMessage("update");
		} else {
			printResult.printErrorMessage("update");
		}
		
	}


    /*5번*/
	public void deleteMenu(Map<String, String> parameter) {
		
		int code = Integer.parseInt(parameter.get("code"));
		
		if(menuService.deleteMenu(code)) {
			printResult.printSuccessMessage("delete");
		} else {
			printResult.printErrorMessage("delete");
		}
		
	}

}
