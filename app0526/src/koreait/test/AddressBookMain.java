package koreait.test;

import java.util.List;
import java.util.Scanner;

/*
 *   		평가 담당 강사 : 김소희 
 * 		평가일 : 2023.5.26
 * 
 * 		답안 제출 훈련생 :  홍승희 
 */

//7) AddressBookApp.java 로 실행 프로그램 구현하기(30점)
public class AddressBookMain {

	public static void main(String[] args) {
		
		String path = "D:\\iclass0419\\addressbook.txt";	//지정된 파일 위치 입니다.
		Scanner sc = new Scanner(System.in);

		//1) 프로그램 시작 시 파일시스템에 저장된 연락처를 프로그램으로 가져오기 메소드 실행
		PhoneAddressBook ph = new PhoneAddressBook();
		ph.load(path);
		
		
		System.out.println("선택 기능 👉 [n]새 연락처 저장 [s]연락처 찾기 [g]그룹선택 보기 [a]전체보기 [e]프로그램 끝내기");
		boolean run = true;
		String name, sel, mobile,group;
		
		while (run) { 
			System.out.print("선택 ✏ ->");
			sel = sc.nextLine();
			
			switch (sel) {
			case "a":
				//2) 전체 보기 기능 메소드 실행
				ph.print();
				break;
			case "g":
				System.out.print("그룹(1:친구,2:가족,3:비지니스) ✏ ");
				group = sc.nextLine();
				//3) 그룹 선택 보기 메소드 실행
				List<Person> results = ph.group(group);
				System.out.println(results);
				break;
			case "s":
				System.out.print("찾을 이름을 입력해주세요 ✏ ");
				//4) 연락처 찾기 -이름으로 검색이며 main 프로그램에서 구현하여 실행(10점)
				name = sc.nextLine();
				Person pn = ph.getPersons().get(name);
				if(pn == null) {
					System.out.println("존재하지 않은 이름입니다.");
				}else {
					System.out.println(name+"님의 정보입니다.");
					System.out.println(pn);
				}
				
				break;
			case "n": 
				System.out.print("이름 입력 ✏ ");
				name = sc.nextLine(); 
				System.out.print("연락처 입력 ✏ ");
				mobile = sc.nextLine();
				System.out.print("그룹(1:친구,2:가족,3:비지니스) ✏ ");
				group = sc.nextLine();
				//5) 새연락처 저장 메소드 실행
				Person ps = new Person(name, mobile, group);
				ps.setGroup(group);
				ph.add(ps);
				break;
			case "e":
				//6) 프로그램 종료 시 연락처들을 파일시스템으로 저장 메소드 실행
				ph.save(path);
				run = false;  
				break;
			default:
				System.out.println("잘못된 선택입니다. 기능 메뉴를 확인하세요.");  	break;
			}
		} // while end
		System.out.println("::::  너의 주소록을 종료합니다. ::::");
		sc.close();
	}

}
