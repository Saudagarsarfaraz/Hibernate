package in.synerzip;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class App {
	public static void main(String[] args) {

		AlienName aName = new AlienName();
		aName.setfName("Suyash");
		aName.setmName("Sai");
		aName.setlName("Pampatwar");
		
		Alien alien = new Alien();
		alien.setaId(102);
		alien.setaColor("Blue");
		alien.setAlienName(aName);
		

		Configuration con = new Configuration().configure().addAnnotatedClass(Alien.class);
		ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings( con.getProperties()).build();
		SessionFactory sf = con.buildSessionFactory(reg);
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		session.save(alien);
		tx.commit();
		

	}
}
