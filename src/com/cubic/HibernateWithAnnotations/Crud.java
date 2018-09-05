package com.cubic.HibernateWithAnnotations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Crud {

	public static void insert() {
		Configuration cfg=new Configuration().addAnnotatedClass(Employee.class).configure();
		SessionFactory factory=cfg.buildSessionFactory();
		Session s=factory.openSession();
		Transaction tx=s.beginTransaction();
		Employee e=new Employee();
		e.setEname("adithya");
		RegularEmployee re=new RegularEmployee();
		re.setEname("abc");
		re.setSalary(15000);
		re.setBonus(600);
		ContractEmployee ce=new ContractEmployee();
		ce.setEname("xyz");
		ce.setPayperhour(1000);
		ce.setDuration("6Months");
		s.persist(re);
		s.persist(ce);
		tx.commit();
		System.out.println("Record Inserted Successfully");
		s.close();
		factory.close();
	}
}
