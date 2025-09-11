package com.ajith.DemoHib;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.ajith.vo.Employee;
import com.ajith.vo.EmployeeName;

public class App 
{
    public static void main( String[] args ){
        System.out.println( "Hello World!" );
        EmployeeName empName = new EmployeeName();
        empName.setFname("Ajith");
        empName.setMname("kumar");
        empName.setLname("Dharmar");
        Employee employee = new Employee();
        employee.setEid(1);
//        employee.setEname("Ajith");
        employee.setRole("Designer");
        employee.setExperience(3);
        employee.setEmloyeeName(empName);
        
        Configuration con = new Configuration().configure().addAnnotatedClass(Employee.class);
        
        ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
        
        SessionFactory sf = con.buildSessionFactory(reg);
        
        Session session = sf.openSession();
        
        Transaction tx = session.beginTransaction();
//        employee = session.get(Employee.class, 2);
        session.save(employee);
        tx.commit();
        System.out.println(employee);
        session.close();
    }
}
