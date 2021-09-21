package in.synerzip;

import java.util.List;

import javax.persistence.Query;

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

		Query q1 = session.createQuery("from Alien where aId=103");
		((org.hibernate.query.Query) q1).setCacheable(true);
		Alien firstResult = (Alien) q1.getSingleResult();

		System.out.println(firstResult);
		tx.commit();
		session.close();

		Session session1 = sf.openSession();
		Transaction tx1 = session1.beginTransaction();
		Query q2 = session1.createQuery("from Alien where aId=103");
		((org.hibernate.query.Query) q2).setCacheable(true);
		Alien firstResult1 = (Alien) q2.getSingleResult();

		System.out.println(firstResult1);
		tx1.commit();
		session1.close();

	}
}
