package hibernate.employee.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.employee.Employee;

public class DeleteEmployee {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Employee.class).buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			int id = 1;
			session.beginTransaction();
			
			session.createQuery("delete from Employee where id='1'").executeUpdate();
			
			session.getTransaction().commit();
			
		}
		finally {
			factory.close();
		}

	}

}
