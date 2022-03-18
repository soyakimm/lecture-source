package com.greedy.section01.xmlconfig;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Application {

	public static void main(String[] args) {
		
		/*greedy계정을 이용해서 mybatis를 통해 crud수행*/
		
		Scanner sc = new Scanner(System.in);
		MenuController menuController = new MenuController();
		
		do {
			System.out.println("============메뉴 관리============");
			System.out.println("1. 메뉴 전체 조회");
			System.out.println("2. 메뉴 코드로 메뉴 조회");
			System.out.println("3. 신규 메뉴 추가");
			System.out.println("4. 메뉴 수정");
			System.out.println("5. 메뉴 삭제");
			System.out.print("6. 메뉴 관리 번호를 입력하세요 : ");
			int no = sc.nextInt();
			
			switch(no) {
			case 1 : menuController.selectAllMenu(); break;
			case 2 : menuController.selectAllMenuByCode(inputMenuCode());break;
			case 3 : menuController.registMenu(inputMenu()); break;
			case 4 : menuController.modifyMenu(inputModifyMenu());break;
			case 5 : menuController.deleteMenu(inputMenuCode()); break;
			default : System.out.println("잘못 된 메뉴를 선택하셨습니다.");
			}
		} while(true);


	}
	
	/* 스캐너를 통해 입력받은 코드를 넘긴다 */
	private static Map<String, String> inputMenuCode() { /*메소드*/
		
		Scanner sc = new Scanner(System.in);
		System.out.println("메뉴 코드를 입력하세요 : ");
		String code = sc.nextLine();
		
		Map<String, String> parameter = new HashMap<>();
		parameter.put("code", code);
		
		return parameter;
		
	}
	
	/*3번*/
	private static Map<String, String> inputMenu() { /*메소드*/
		
		Scanner sc = new Scanner(System.in);
		System.out.print("메뉴 이름을 입력하세요 : ");
		String name = sc.nextLine();
		System.out.print("메뉴 가격을 입력하세요 : ");
		String price = sc.nextLine();
		System.out.print("카테고리 코드를 입력하세요 : ");
		String categoryCode = sc.nextLine();
		
		Map<String, String> parameter = new HashMap<>();
		parameter.put("name", name);
		parameter.put("price", price);
		parameter.put("categoryCode", categoryCode);
		
		return parameter;
		
	}

	
	/*4번*/
	private static Map<String, String> inputModifyMenu() { /*메소드*/
		
		Scanner sc = new Scanner(System.in);
		System.out.print("수정할 메뉴 코드를 입력하세요 : ");
		String code = sc.nextLine();
		System.out.print("수정할 메뉴 이름을 입력하세요 : ");
		String name = sc.nextLine();
		System.out.print("수정할 메뉴 가격을 입력하세요 : ");
		String price = sc.nextLine();
		System.out.print("수정할 카테고리 코드를 입력하세요 : ");
		String categoryCode = sc.nextLine();
		
		Map<String, String> parameter = new HashMap<>();
		parameter.put("code", code);
		parameter.put("name", name);
		parameter.put("price", price);
		parameter.put("categoryCode", categoryCode);
		
		return parameter;
		
	}

	

	

}
