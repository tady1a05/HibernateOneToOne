package com.toby.saveJdbc;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.toby.model.Instructor;
import com.toby.model.InstructorDetail;

public class JdbcSave {

	public static void main(String args[]) {
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();
		Session session = factory.getCurrentSession();

		try {
			
			Instructor ins = new Instructor("Toby","Cheung","toby1a05@gmail.com");
			InstructorDetail insDetail = new InstructorDetail("Arho","fapping");
			ins.setInstructorDetail(insDetail);
			session.beginTransaction();
			session.save(ins);
			session.getTransaction().commit();
			
		}finally {
			session.close();
			factory.close();
		}
	}

}
