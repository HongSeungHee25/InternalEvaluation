package koreait.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.TreeMap;

/*
 *   		평가 담당 강사 : 김소희 
 * 		평가일 : 2023.5.26
 * 
 * 		답안 제출 훈련생 : 홍승희
 */

public class PhoneAddressBook implements IAddressBook {
	
	private Map<String,Person> persons;
	
	public PhoneAddressBook() {
		persons = new TreeMap<>();
	}

	@Override
	public Map<String, Person> getPersons() {
		return persons;
	}

	@Override
	public void add(Person person) {
		persons.put(person.getName(), person);
		
	}

	@Override
	public void print() {
		System.out.println(String.format("%-20s\t%-13s", "이름","전화번호"));
		System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::");
		for(String key : persons.keySet()) {
			Person ps = persons.get(key);
			System.out.println(String.format("%-20s\t%-13s",ps.getName(),ps.getMobile()));
		}
	}

	@Override
	public List<Person> group(String group) {
		group = switch (group) {
		case "1" -> "FRIENDS";
		case "2" -> "FAMILY";
		case "3" -> "BUSINESS";
		default -> throw new IllegalArgumentException("Unexpected (value 1 or 2 or 3) : " + group);
		};
		List<Person> result = new ArrayList<Person>(); 
		for(String key : persons.keySet()) {
			Person ps = persons.get(key);
			if(ps.getGroup().equals(group));
			result.add(ps);
		}
		return result;
	}
	
	@Override
	public void load(String path) {
		File file = new File(path);
		Scanner fsc = null;
		try {
			fsc = new Scanner(file);
			while(fsc.hasNext()) {
				String temp = fsc.nextLine();
				System.out.println(temp);
				StringTokenizer stk = new StringTokenizer(temp,"\t-_");
				String name = stk.nextToken();
				persons.put(name, new Person(name, stk.nextToken(), stk.nextToken()));
			}
			System.out.println("이름 "+persons.size()+"명을 주소록에서 정상적으로 불러왔습니다.");
			System.out.println("주소록 정상적으로 불러오기 성공");
		}catch(FileNotFoundException e) {
			System.out.println("예외 : "+e.getMessage());
		}finally {
			if(fsc != null) fsc.close();
		}
		
	}


	@Override
	public void save(String path) {
		File file = new File(path);
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(file);
			Iterator<String> iterator = persons.keySet().iterator();
			while(iterator.hasNext()) {
				String result = iterator.next();
				Person ps = persons.get(result);
				pw.println(ps);
			}
			System.out.println("이름 "+persons.size()+"명을 주소록에 저장했습니다.");
			System.out.println("정상적으로 저장 완료");
		}catch(FileNotFoundException e){
			System.out.println("예외 : "+e.getMessage());
	}finally {
		if(pw != null) pw.close();
	}
	
		

		//1) 프로그램 시작 시 파일시스템에 저장된 연락처를 프로그램으로 가져오기 (15점)
	
	//2) 전체 보기 기능을 메소드로 변경하여 구현하기 (10점)  
	
	
	//3) 그룹 선택 보기를 메소드로 변경하여 구현하기 (10점)
	
	
		//5) 새연락처 저장 (10점)
	
	
	//6) 프로그램 종료 시 연락처들을 파일시스템으로 저장 (15점)
	// Map 데이터 가져올 때 반복자를 사용하세요.
	
	}
}
	
	

