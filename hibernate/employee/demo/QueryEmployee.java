package hibernate.employee.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.employee.Employee;

public class QueryEmployee {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class).buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			List<Employee> theEmployees = session.createQuery("from Employee").getResultList();
			System.out.println(theEmployees);
			displayEmployee(theEmployees);
			
			session.getTransaction().commit();
			
		}
		finally{
			factory.close();
		}
		
	}

	private static void displayEmployee(List<Employee> theEmployees) {
		for(Employee tmpEmployee : theEmployees) {
			System.out.println(tmpEmployee);
		}
	}
}
