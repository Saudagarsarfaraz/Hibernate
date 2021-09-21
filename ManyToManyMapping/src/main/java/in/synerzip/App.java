package in.synerzip;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class App {
	public static void main(String[] args) {
        
		Laptop lap = new Laptop();
		lap.setlId(101);
		lap.setlName("Dell");
	    
		
		
		Student stud = new Student();
		stud.setRollNo(1);
		stud.setName("Suyash");
		stud.setMark(50);
		stud.setLaptop(lap);
		lap.setStudent(stud);
		
	
		

		Configuration con = new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class);
		ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings( con.getProperties()).build();
		SessionFactory sf = con.buildSessionFactory(reg);
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		session.save(lap);
		session.save(stud);
		
		tx.commit();
		

	}
}
