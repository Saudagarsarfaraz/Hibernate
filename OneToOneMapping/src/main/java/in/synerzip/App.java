package in.synerzip;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

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
		lap.setlName("Hp");
		
		Student stud = new Student();
		stud.setRollNo(3);
		stud.setName("suresh");
		stud.setMark(50);
		stud.setLaptop(lap);
		

		Configuration con = new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class);
		ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings( con.getProperties()).build();
		SessionFactory sf = con.buildSessionFactory(reg);
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		session.save(lap);
		session.save(stud);
		
	
		session.save(stud);
		
		tx.commit();
		

	}
}
