package com.example.AOP;


import org.springframework.stereotype.Component;

@Component
public class ShopingCart {
	// Logging 
	// Authentication and Authorization 
	// Sanity the Data
	public void checkoutCart() {
		// Below code for @AfterThrowing annotation testing code
//		int account =2000;
//		if(3000>account) {
//			throw new RuntimeException("insufficient balance in account : "+account);
//		}
		System.out.println(" checkout called from shopping cart");
		
	}
	
	public void addToCart(String productName) {
		System.out.println(" AddCart called from shopping cart : "+productName);
	}
	
	public int getProductQuantity() {
		return 6;
	}

}
