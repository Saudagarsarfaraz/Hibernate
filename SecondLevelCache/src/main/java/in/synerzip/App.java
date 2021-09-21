package in.synerzip;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class App {
	public static void main(String[] args) {

		Alien alien = new Alien();

		Configuration con = new Configuration().configure().addAnnotatedClass(Alien.class);
		ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
		SessionFactory sf = con.buildSessionFactory(reg);
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		Alien alien2 = (Alien) session.get(Alien.class, 103);
		System.out.println(alien2);
		tx.commit();
		session.close();
		
		Session session1 = sf.openSession();
		Transaction tx1 = session1.beginTransaction();
		
		Alien alien3 = (Alien) session1.get(Alien.class, 103);
		System.out.println(alien3);
        tx1.commit();
		session1.close(); 
		

	}
}
