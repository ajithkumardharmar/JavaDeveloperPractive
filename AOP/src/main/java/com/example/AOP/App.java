package com.example.AOP;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.example.AOP.SpringConcept.Car;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
//        ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfigAOP.class);
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(BeanConfigAOP.class);
//        context.refresh();
        ShopingCart shop = context.getBean(ShopingCart.class);
        shop.checkoutCart();
        Engine engine = context.getBean(Engine.class);
        Car car = context.getBean(Car.class);
        car.drive();
        System.out.println( "Completed!" );
        context.close();
    }
}
