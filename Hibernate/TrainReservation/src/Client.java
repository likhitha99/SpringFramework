import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.SQLQuery;

import java.util.List;
import java.util.Iterator;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Transaction;
import org.hibernate.Session;

public class Client {
	private static SessionFactory factory;

	public static void getSessionFactory() {
		try {
			Configuration conf = new Configuration().configure();
			StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
					.applySettings(conf.getProperties());
			factory = conf.buildSessionFactory(builder.build());
		} catch (Throwable ex) {
			System.err.println("Falied to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static void main(String[] java) {
		try {
			getSessionFactory();
			Client client_1 = new Client();

			client_1.InsertRecordInDatabase(1, "Likhitha Ch", 50);
			client_1.InsertRecordInDatabase(2, "Rohan", 35);
			client_1.InsertRecordInDatabase(3, "Pluto", 25);
			client_1.InsertRecordInDatabase(4, "jay Banu", 40);

			System.out.println("Listing Employees");
			client_1.DisplayRecords();

			// Deleting the records
//			client_1.DeleteRecord(1);
//			

		} catch (HibernateException e) {
			System.out.println("Exception is: " + e);
		}
	}

	public void InsertRecordInDatabase(int id, String name, int age) throws HibernateException {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		TrainReservation tr = new TrainReservation(id, name, age);
		session.save(tr);
		tx.commit();

		session.close();
	}

	public void DisplayRecords() throws HibernateException {
		Session session = factory.openSession();

		Criteria cr = session.createCriteria(TrainReservation.class);
		cr.add(Restrictions.gt("age", 15));
		cr.add(Restrictions.lt("age", 50));
		
		List empLst = cr.list();

		for (Iterator iterator = empLst.iterator(); iterator.hasNext();) {
			TrainReservation tr = (TrainReservation) iterator.next();

			System.out.println("Name: " + tr.getPassengerName());
			System.out.println("Age: " + tr.getAge());
		}
		session.close();
	}

	public void DeleteRecord(Integer id) throws HibernateException {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		TrainReservation tr = (TrainReservation) session.get(TrainReservation.class, id);
		session.delete(tr);
		tx.commit();
		session.close();
	}

}
