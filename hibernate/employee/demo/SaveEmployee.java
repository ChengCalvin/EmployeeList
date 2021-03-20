package hibernate.employee.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.employee.Employee;

public class SaveEmployee {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Employee.class).buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		
		try {
			Employee employee = new Employee("Mary", "White", "Alphabet");
			
			session.beginTransaction();
			
			session.save(employee);
			
			session.getTransaction().commit();
			
			
		}
		finally {
			factory.close();
		}
	}

}
