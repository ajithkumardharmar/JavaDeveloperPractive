package com.example.AOP;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	
	@Before("execution(* com.example.AOP.ShopingCart.checkoutCart(..))")
	public void logCheckoutBefore(JoinPoint jp) {
//		System.out.println(jp.getSignature());
		System.out.println(" Shoping Checkout process started...");
	}
	@AfterReturning("execution(* com.example.AOP.ShopingCart.checkoutCart(..))")
	public void logCheckoutAfterSuccessfulExecution(JoinPoint jp) {
		System.out.println(" Shoping Checkout process executed successfully...");
	}
	
	@AfterThrowing(pointcut = "execution(* com.example.AOP.ShopingCart.checkoutCart(..))", throwing = "ex")
	public void logCheckoutAfterException(Exception ex) {
		System.out.println(" Shoping Checkout process exception : "+ex.getMessage());
	}
	
	@After("execution(* com.example.AOP.ShopingCart.checkoutCart(..))")
	public void logCheckoutAfter() {
		System.out.println(" Shoping Checkout process Completed...");
	}
	
	
	@Around("execution(* com.example.AOP.ShopingCart.checkoutCart(..))")
	public Object measureExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis(); // Start time

        Object result = joinPoint.proceed(); // Execute the actual method

        long end = System.currentTimeMillis(); // End time
        System.out.println(joinPoint.getSignature() + " executed in " + (end - start) + "ms");

        return result; // Return the original method's result
    }
	

}
