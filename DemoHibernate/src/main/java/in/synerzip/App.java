package in.synerzip;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class App {
	public static void main(String[] args) {

		Alien a1 = new Alien();
		a1.setaId(102);
		a1.setaName("Ashfakh");
		a1.setaColor("Black");

		Configuration con = new Configuration().configure().addAnnotatedClass(Alien.class);
		ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings( con.getProperties()).build();
		SessionFactory sf = con.buildSessionFactory(reg);
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		session.save(a1); //saving data
		// Alien alien = (Alien) session.get(Alien.class, 101);  //fetching data
		tx.commit();
        //System.out.println(alien); 
	}
}
