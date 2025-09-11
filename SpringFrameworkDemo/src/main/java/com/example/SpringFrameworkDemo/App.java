package com.example.SpringFrameworkDemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App {
	
    public static void main( String[] args )
    {
//    	ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
    	ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
    	
    	Doctor doctor = context.getBean(Doctor.class);
    	doctor.assist();
    	doctor.setQualification("MBBS");
//    	System.out.println(doctor);
//    	Doctor doctor1 = context.getBean(Doctor.class);
//    	System.out.println(doctor1);
    	
//    	Nurse nurse = (Nurse) context.getBean("nurse");
//    	nurse.assist();
    	// spring container to get Object
//    	Staff staff = context.getBean(Doctor.class);
//    	staff.assist();
//    	Staff staff2 = context.getBean(Nurse.class);
//    	staff2.assist();
    	
    }
}
