import java.util.Iterator;
import java.util.List;

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
			throw new ExceptionInInitializerError(ex);
		}
	}
	
	public static void main(String[] args) throws InterruptedException{
		getSessionFactory();
		
		Client client_1=new Client();
		
		
		College col=new College(45,"GRIET","Bachupally");
		
		Student1 stu1=new Student1(5,"Lucy","Hale","DSA");
		col.setStudent(stu1);
		client_1.insertData(col,stu1);
		
		Student1 stu2=new Student1(6,"Aria","Montgomery","DAA");
		col.setStudent(stu2);
		client_1.insertData(col,stu2);
		
		client_1.displayRecords();
	}
	
	public void insertData(College colObj,Student1 stuObj)
	{
		Session session=factory.openSession();
		
		Transaction tx=session.beginTransaction();
		
		session.save(colObj);
		session.save(stuObj);
		
		tx.commit();
		
		System.out.println("College and Student are inserted in the database");
		session.close();
	}
	
	public void displayRecords() throws InterruptedException{
		Session session=factory.openSession();
		
		List li=session.createQuery("FROM College").list();
		for(Iterator iterator=li.iterator();iterator.hasNext();) {
			College col=(College) iterator.next();
			System.out.println("\tCollege name::"+col.getCollegeName());
			System.out.println("\tCollege Address:"+col.getCollegeAddress());
			
			Student1 stu=col.getStudent();
			System.out.print("First Name: "+stu.getFirstName());
			System.out.print("   Last Name: "+stu.getLastName());
			System.out.println("    Course : "+stu.getCourse());
			
			
		}
		session.close();
		
	}
}

	

