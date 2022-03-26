package com.toby.saveJdbc;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.toby.model.Instructor;
import com.toby.model.InstructorDetail;

public class JdbcRead {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		Session session = null;
		
		try {
		
		session = factory.getCurrentSession();
			
		session.beginTransaction();
		Instructor ins = session.get(Instructor.class,"1");
		System.out.println(ins.getInstructorDetail());
		session.getTransaction().commit();
		
		session.close();
		/*
		session = factory.getCurrentSession();
		
		session.beginTransaction();
		InstructorDetail insDetail = session.get(InstructorDetail.class, "1");
		System.out.println(insDetail.getInstructor());
		session.getTransaction().commit();*/
		
		session.close();

		}finally {
		factory.close();
		}

	}

}
