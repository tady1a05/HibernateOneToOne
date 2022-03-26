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
		
		try {
			Session session = factory.getCurrentSession();
			Instructor ins = new Instructor("Toby","Cheung","toby1a05@gmail.com");
			InstructorDetail insDetail = new InstructorDetail("Arho","fapping");
			ins.setInstructorDetail(insDetail);
			session.beginTransaction();
			session.save(ins);
			session.getTransaction().commit();
			/**                                        **/
			Session session2 = factory.getCurrentSession();
			session2.beginTransaction();
			InstructorDetail ins1 = session2.get(InstructorDetail.class,"1");
			System.out.println(ins1.getInstructor());
			session2.getTransaction().commit();
			/**                                        **/
			Session session3 = factory.getCurrentSession();
			session3.beginTransaction();
			Instructor ins2 = session3.get(Instructor.class,"1");			
			System.out.println(ins2.getInstructorDetail());
			session3.getTransaction().commit();

		}finally {
			factory.close();
		}
	}

}
