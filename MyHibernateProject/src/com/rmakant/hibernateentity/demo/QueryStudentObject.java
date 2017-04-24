 package com.rmakant.hibernateentity.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.rmakant.hibernateentity.Student;

public class QueryStudentObject {

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
			
			
			//Begin session
			session.beginTransaction();
			
			//Save the student object
			System.out.println("Query the student object");
			List<Student> querystudent=session.createQuery("from Student").list();
			
			
			for(Student temp:querystudent)
			{
			
				System.out.println(temp);
				
			}
			
			
			//Commit the change
			session.getTransaction().commit();
			
			System.out.println("Completed"); 
		}
		finally{
			
			factory.close();
		}
		
		
	}

}
