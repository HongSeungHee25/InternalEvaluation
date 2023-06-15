package koreait;

//작성자 : 홍승희 
public abstract class Product {
	//[1]
	 protected int price;
	 protected String prdName;
	 
	 public abstract String sell(Object object);
	//[2] 
	 @Override
	public String toString() {
		return String.format("[가격 : %d , 상품명 : %s ]", price,prdName);
	}
}
