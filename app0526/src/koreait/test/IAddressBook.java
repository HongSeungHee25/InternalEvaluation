package koreait.test;

import java.util.List;
import java.util.Map;

/*
 *   		평가 담당 강사 : 김소희 
 * 		`	평가일 : 2023.5.26
 * 
 * 			답안 제출 훈련생 : 홍승희 
 */

public interface IAddressBook {
	
	Map<String, Person> getPersons();		//주소록 저장 Map 객체 가져오기
	void add(Person person);		//주소록에 항목 Map 데이터 추가
	public void print();			//주소록 Map 전체 데이터 출력 
	List<Person> group(String group);	//주소록 Map 에서 원하는 그룹을 찾아서 List 로 리턴하기
	void load(String path);		//path로 지정된 경로파일에서 데이터 가져와 주소록 Map 에 저장하기
	void save(String path);		//path로 지정된 경로파일에 주소록 Map 데이터 저장하기
}
