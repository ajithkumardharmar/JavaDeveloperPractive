package com.example.AOP.SpringConcept;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.example.AOP.BeanConfigAOP;
import com.example.AOP.ShopingCart;

public class SecurityApp {
	public static void main(String[] args) {
		  System.out.println( "Hello World!" );
//        ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfigAOP.class);
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(BeanConfigAOP.class);
        SecurityService securityService = context.getBean(SecurityService.class);
        securityService.setRole("ADMIN");
        ShopingCart shop = context.getBean(ShopingCart.class);
        shop.checkoutCart();
        shop.addToCart("Mobiles");
        shop.getProductQuantity();
        System.out.println( "Completed!" );
        context.close();
    }
}
