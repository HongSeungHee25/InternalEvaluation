package koreait;

//작성자 : 홍승희
public class ProductMain {

	public static void main(String[] args) {
		//[1] main 메소드에 Product배열(크기는 10) cart를 선언합니다.
		Product[] cart = new Product[10];
		//cart 배열이 다음과 같은 객체를 참조값 하도록 합니다.
		cart[0] = new Bike(123000,"MTB",25);
		cart[3] = new Bike(99000,"삼천리",15);
		
		cart[1] = new Electronics();
		cart[1].price = 35000; cart[1].prdName = "USB";
		cart[5] = new Electronics();
		cart[5].price = 117000; cart[5].prdName = "ipad";
		cart[7] = new Electronics();
		cart[7].price = 2250000; cart[7].prdName = "lg 냉장고";
		
		//1번 문제에 [3]번문제 출력
		System.out.println("1번 문제에 [3]번 출력 => "+cart[0].sell(20));
		//1번 문제에 [4]번문제 출력
		System.out.println("1번 문제에 [4]번 출력 => "+cart[1].sell("사운드바"));
		
		//[2] 위 1에 생성된 cart 배열의 7번 인덱스 kwh 필드값을 0.9로 하여 power() 메소드
		//실행결과를 출력하세요.
		Electronics E = (Electronics)cart[7];
		E.setKwh(0.9);
		System.out.println("[2] 출력 => "+E.power());
		
		//[3] 위 1번에 생성된 cart 배열 상품 중 가격이 10만원 이상인 것을 출력하세요.
		//출력은 toString메소드로 합니다.
		for (int i = 0; i < cart.length; i++) {
			if(cart[i] != null && cart[i].price >= 100000) {
				System.out.println("[3] 출력 => "+cart[i].toString());
			}//if end
		}//for end
		
		//[4] 위 1번에 생성된 cart 배열 상품 중 Bike 객체만 ride() 메소드 실행결과를 
		//리턴받아 출력합니다.
		for (int i = 0; i < cart.length; i++) {
			if (cart[i] != null && cart[i] instanceof Bike) {
				Bike B = (Bike) cart[i];
				System.out.println("[4] 출력 => "+B.ride());
			}//if end
		}//for end
	}//main end
}//class end
