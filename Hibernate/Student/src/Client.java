import java.util.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class Client {
	private static SessionFactory factory;
	
	public static void getSessionFactory()
	{
		try {
			Configuration conf=new Configuration().configure();
			StandardServiceRegistryBuilder builder=new StandardServiceRegistryBuilder().applySettings(conf.getProperties());
			factory=conf.buildSessionFactory(builder.build());
		}
		catch(Throwable ex) {
			System.err.println("Falied to create sessionFactory object."+ex);
			
		}
	}
	
	public static void main(String[] args) throws InterruptedException{
		getSessionFactory();
		
		Client client_1=new Client();
		
		Address1 add1=new Address1("Park Street","Mumbai","India","486");
		Student stu1=new Student(5,"Lucy","Hale","DSA");
		stu1.setAddress(add1);
		client_1.insertData(stu1,add1);
		
		Address1 add2=new Address1("Amway Road","Bangalore","India","500");
		Student stu2=new Student(6,"Aria","Montgomery","DAA");
		stu2.setAddress(add2);
		client_1.insertData(stu2,add2);
		
		client_1.displayRecords();
	}
	
	public void insertData(Student stuObj, Address1 addObj)
	{
		Session session=factory.openSession();
		
		Transaction tx=session.beginTransaction();
		
		session.save(stuObj);
		session.save(addObj);
		tx.commit();
		
		System.out.println("Student and Address are inserted in the database");
		session.close();
	}
	
	public void displayRecords() throws InterruptedException{
		Session session=factory.openSession();
		
		List li=session.createQuery("FROM Student").list();
		for(Iterator iterator=li.iterator();iterator.hasNext();) {
			Student stu=(Student) iterator.next();
			System.out.print("First Name: "+stu.getFirstName());
			System.out.print("   Last Name: "+stu.getLastName());
			System.out.println("    Course : "+stu.getCourse());
			Address1 add=stu.getAddress();
			System.out.println("Address");
			System.out.println("\tStreet:"+add.getStreet());
			System.out.println("\tCity:"+add.getCity());
			System.out.println("\tState:"+add.getState());
			System.out.println("\tZipcode:"+add.getZipcode());
			
		}
		session.close();
		
	}
}
