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
        
		

		Student stud = new Student();
		stud.setRollNo(3);
		stud.setName("suresh");
		stud.setMark(50);
		
		Laptop lap = new Laptop();
		lap.setlId(101);
		lap.setlName("Hp");
		
		Laptop lap1 = new Laptop();
		lap1.setlId(102);
		lap1.setlName("Dell");
		
		Laptop lap2 = new Laptop();
		lap2.setlId(103);
		lap2.setlName("Mac");
		
		List<Laptop> list = new ArrayList<Laptop>();
		list.add(lap);
		list.add(lap1);
		list.add(lap2);
		
		stud.setLaptop(list);
		


		Configuration con = new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class);
		ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings( con.getProperties()).build();
		SessionFactory sf = con.buildSessionFactory(reg);
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		session.save(lap);
		session.save(lap1);
		session.save(lap2);
		
	
		session.save(stud);
		
		tx.commit();
		

	}
}
