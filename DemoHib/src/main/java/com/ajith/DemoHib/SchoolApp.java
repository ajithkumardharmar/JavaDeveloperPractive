package com.ajith.DemoHib;

import java.util.Collection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.ajith.vo.Laptop;
import com.ajith.vo.Student;

public class SchoolApp {
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Student student=null;
		
		Configuration config = new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class);
		
		ServiceRegistry service = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
		
		SessionFactory sessionFactory = config.buildSessionFactory(service);
		
		Session  session = sessionFactory.openSession();
		
		session.beginTransaction();
//		Laptop laptop = new Laptop();
//		
//		laptop.setLid(1003);
//		laptop.setLname("Acer");
//		
//		
//		Laptop laptop2 = new Laptop();
//		
//		laptop2.setLid(1004);
//		laptop2.setLname("Apple pro book");
//		
//		Student student = new Student();
//		
//		student.setRollno(103);
//		student.setStudentName("Ak");
//		student.setMark(90);
//		student.getLaptop().add(laptop);
//		laptop.getStudent().add(student);
//		student.getLaptop().add(laptop2);
//		student.getLaptop().add(laptop);
		
//		Student student2= new Student();
//		
//		student2.setRollno(102);
//		student2.setStudentName("Priya");
//		student2.setMark(90);
//		student2.getLaptop().add(laptop);
//		student2.getLaptop().add(laptop2);
			
		
//		session.save(laptop);
//		session.save(laptop2);
//		session.save(student);
//		session.save(student2);
		
		
		
		student = (Student) session.get(Student.class, 101);
		System.out.println(student);
//		student = session.get(Student.class, 102);
//		System.out.println(student.getStudentName());
//		student = session.get(Student.class, 101);
//		System.out.println(student.getStudentName());
//		student = session.get(Student.class, 102);
//		System.out.println(student.getStudentName());
//		Collection<Laptop> laptop = student.getLaptop();
//		
//		for(Laptop l : laptop) {
//			System.out.println(l.getLname());
//		}
//		
		session.getTransaction().commit();
		session.close();
		
		Session session2 = sessionFactory.openSession();
		session2.beginTransaction();
		
		student = (Student) session2.get(Student.class, 101);
		System.out.println(student);
		
		session2.getTransaction().commit();
		session2.close();
		
		
		
		
		
		
	}

}
