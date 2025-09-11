package com.example.AOP.SpringConcept;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AuthendicateAspect {
	
	@Autowired
	private SecurityService securityService;
	
	@Before("execution(* com.example.AOP.ShopingCart.addToCart(..))")
	public void logAddToCartBefore(JoinPoint jp) {
//		System.out.println(jp.getSignature());
		String argument = jp.getArgs()[0].toString();
		System.out.println(" Shoping AddToCart Argument : "+ argument);
	}
	
	@Before("execution(* com.example.AOP.ShopingCart.checkoutCart(..))")
	public void logCheckoutBefore(JoinPoint jp) {
//		System.out.println(jp.getSignature());
		System.out.println(" Shoping Checkout process started...");
	}
	
	@Pointcut("within(com.example.AOP.ShopingCart)")
	// This pointcut matches all methods within the ShopingCart class
	public void shopingCartMethod() { }
	
	

	@Before("shopingCartMethod() ")
	public void authenticate() {
		if(!securityService.isAdmin()) {
			throw new SecurityException(" Access denied only admin can access ShopingCart ");
		}
		System.out.println("Authentication Request success");
	}
	@Pointcut("execution (* com.example.AOP.ShopingCart.getProductQuantity(..))")
	// This pointcut matches all methods within the ShopingCart class
	public void addToCartMethod() { }
	
	@AfterReturning(pointcut = "addToCartMethod()",returning ="returnVal" )
	public void afterReturingVal(Object returnVal) {
		
		System.out.println("afterReturingVal : "+returnVal);
	}
}
