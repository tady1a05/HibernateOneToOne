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
						
			/*session.beginTransaction();
			
			Instructor ins = session.get(Instructor.class,"1");

			
			if(ins != null) {
				session.delete(ins);
			}
			
			session.getTransaction().commit();*/

		}finally {
			factory.close();
		}
	}

}
