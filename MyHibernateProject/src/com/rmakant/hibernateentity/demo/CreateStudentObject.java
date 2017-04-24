 package com.rmakant.hibernateentity.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.rmakant.hibernateentity.Student;

public class CreateStudentObject {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		//Create SessionFactory First
		SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		
		//Create Session
		Session session=factory.getCurrentSession();
		
		
		try{
			
			//Create student object 
			System.out.println("Creating new student object");
			Student student3=new Student("Anuj","Bam","anuj12345@gmail.com");
			
			
			//Begin session
			session.beginTransaction();
			
			//Save the student object
			System.out.println("Saving the student object");
			session.save(student3);
			
			//Commit the change
			session.getTransaction().commit();
			
			System.out.println("Completed"); 
		}
		finally{
			
			factory.close();
		}
		
		
	}

}
