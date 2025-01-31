package com.main;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.entities.Department;
import com.entities.Employee;

public class MainClass {
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Employee.class);
		cfg.addAnnotatedClass(Department.class);
		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();
		Employee e1 = new Employee();
		e1.setE_id(105);
		e1.setE_name("saloni");
		ss.persist(e1);
		

		System.out.println("mapping is successfully");

		List <Employee>list=new ArrayList<>();
		list.add(e1);
		Department d = new Department();
		d.setD_id(203);
		d.setD_name("AWS");
		
		e1.setDept(d);

		d.setEmp(list);
		ss.persist(d);
		
		tr.commit();
		ss.close();
	}
}
