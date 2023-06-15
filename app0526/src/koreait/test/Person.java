package koreait.test;

/*
 *   		평가 담당 강사 : 김소희 
 * 		`	평가일 : 2023.5.26
 * 
 * 			답안 제출 훈련생 :  홍승희 
 */

public class Person {
	private String name;		 //이름
	private String mobile;		 //핸드폰 연락처
	private String group;        //FRIENDS , FAMILY , BUSINESS  중 하나의 문자열만 저장하기
						 //setGroupt(String group)은 인자로 "1","2","3"을 받아 그에 맞는 문자열로 필드값 저장하기
	
	public Person(String name, String mobile, String group) {
		this.name = name;
		this.mobile = mobile;
		this.group = group;
	}
	
	@Override
	public String toString() {
		return  name + "_"+mobile+"_"+group;                          //1)과 6)번에 사용하기 위해 재정의합니다.
	}
	//getter, setter 정의

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = switch (group) {
		case "1" -> "FRIENDS";
		case "2" -> "FAMILY";
		case "3" -> "BUSINESS";
		default -> throw new IllegalArgumentException("Unexpected (value 1 or 2 or 3) : " + group);
		};
	}
	
	
	
	
	
	
}
