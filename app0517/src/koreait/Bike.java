package koreait;

//작성자 : 홍승희 
public class Bike extends Product{
	//[3]
	@Override
	public String sell(Object object) {
		return String.format("추가 할인 행사 - %d %% 인하", object);
	}//sell end
	
	//[5]
	private int speed;

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
	//[6]
	public Bike() {}
	
	public Bike(int price, String prdName, int speed) {
		super.prdName = prdName; 
		super.price = price; 
		this.speed = speed;
	}
	//[8]
	public String ride() {
		return "당신은 이것을 시속 "+speed+"km 로 탈수 있습니다.";
	}
	
	//[10]
	@Override
	public String toString() {
		return super.toString()+", 스피드 : "+speed;
	}
	
}//Bike end
class Electronics extends Product{
	//[4]
	@Override
	public String sell(Object object) {
		return String.format("묶음 상품 - %s (1set)", object);
	}//sell end
	
	//[7]
	private double kwh;

	public double getKwh() {
		return kwh;
	}

	public void setKwh(double kwh) {
		this.kwh = kwh;
	}
	//[9]
	public double power() {
		
		return kwh*24; 
	}
	//[10]
	@Override
	public String toString() {
		return super.toString()+String.format(", kwh : %.2f", kwh);
	}
	
	
}//Electronics end