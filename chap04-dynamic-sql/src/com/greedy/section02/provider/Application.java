package com.greedy.section02.provider;

import java.util.Scanner;

import com.greedy.common.MenuDTO;
import com.greedy.common.SearchCriteria;

public class Application {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		do {
			System.out.println("========== 구문 빌더 API 를 이용한 동적 SQL ==========");
			System.out.println("1. SelectBuilder 테스트 하기");
			System.out.println("2. SqlBuilder 테스트 하기");
			System.out.println("9. 프로그램 종료하기");
			System.out.print("메뉴를 입력하세요 : ");
			int no = sc.nextInt();
			
			switch(no) {
			case 1 : selectBuilderSubMenu(); break;
			case 2 : sqlBuilderSubMenu(); break;
			case 9 : System.out.println("프로그램을 종료합니다."); return;
			}
		} while(true);
	}

	
	
	/* [case1] : SelectBuilder */
	
	private static void selectBuilderSubMenu() {
		
		Scanner sc = new Scanner(System.in);
		SelectBuilderService selectBuilderService = new SelectBuilderService();
		do {
			System.out.println("========== SelectBuilder 서브 메뉴 ==========");
			System.out.println("1. SelectBuilder 기본 구문 사용하기");
			System.out.println("2. SelectBuilder를 이용한 동적 SQL 사용하기");
			System.out.println("9. 이전 메뉴로");
			System.out.print("메뉴를 입력하세요 : ");
			int no = sc.nextInt();
			
			switch(no) {
			case 1 : selectBuilderService.testSimpleStatement(); break;
			case 2 : selectBuilderService.testDynamicStatement(inputSearchCriteria()); break;
			case 9 : return;
			}
		} while(true);
	}

	
	
	/* [case2] : SqlBuilder */
	private static SearchCriteria inputSearchCriteria() {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("검색 조건을 입력하세요(category or name) : ");
		String condition = sc.nextLine();
		System.out.print("검색할 내용을 입력하세요 : ");
		String value = sc.nextLine();
		
		return new SearchCriteria(condition, value);
		
	}


	
	
	/* SqlBuilder 서브메뉴 */
	private static void sqlBuilderSubMenu() {
		
		Scanner sc = new Scanner(System.in);
		SqlBuilderService sqlBuilderService = new SqlBuilderService();
		
		do {
			System.out.println("========== SqlBuilder 서브 메뉴 ==========");
			System.out.println("1. 새로운 메뉴 추가하기");
			System.out.println("2. 기본 메뉴 수정하기");
			System.out.println("3. 마음에 들지 않는 메뉴 삭제하기");
			System.out.println("9. 이전 메뉴로");
			System.out.print("메뉴를 입력하세요 : ");
			int no = sc.nextInt();
			
			switch(no) {
			case 1 : sqlBuilderService.registMenu(inputNewMenu()); break;
			case 2 : sqlBuilderService.modifyMenu(inputModifyMenu());break;
			case 3 : sqlBuilderService.deleteMenu(inputMenuCode());break;
			case 9 : return;
			}
		} while(true);
	}

	
	/*등록할 정보에 대한 메뉴 */
	private static MenuDTO inputNewMenu() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("등록할 메뉴 이름을 입력하세요 : ");
		String name = sc.nextLine();
		System.out.println("등록할 메뉴 가격을 입력하세요 : ");
		int price = sc.nextInt();
		System.out.println("등록할 카테고리를 입력하세요 : ");
		int categoryCode = sc.nextInt();
		System.out.println("판매 등록 여부를 입력하세요(Y/N) : ");
		sc.nextLine();
		String orderableStatus = sc.nextLine();
		
		MenuDTO menu = new MenuDTO();
		menu.setName(name);
		menu.setPrice(price);
		menu.setCategoryCode(categoryCode);
		menu.setOrderableStatus(orderableStatus);
		
		return menu;
	}
	
	/* 기본 메뉴 수정하기 -깃 */
	private static MenuDTO inputModifyMenu() {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("수정할 메뉴 코드를 입력하세요 : ");
		int code = sc.nextInt();
		System.out.print("수정할 메뉴 이름을 입력하세요 : ");
		sc.nextLine();
		String name = sc.nextLine();
		System.out.print("수정할 메뉴 가격을 입력하세요 : ");
		int price = sc.nextInt();
		System.out.print("수정할 카테고리를 입력하세요 : ");
		int categoryCode = sc.nextInt();
		System.out.print("수정할 판매 등록 여부를 입력하세요(Y/N) : ");
		sc.nextLine();
		String orderableStatus = sc.nextLine();
		
		return new MenuDTO(code, name, price, categoryCode, orderableStatus);
		
	}

	
	/* 마음에 들지 않는 메뉴 삭제하기 -깃 */
		private static int inputMenuCode() {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("삭제할 메뉴 번호를 입력하세요 : ");
		int code = sc.nextInt();
		
		return code;
		
	}


}
