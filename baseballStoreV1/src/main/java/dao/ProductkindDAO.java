package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import model.Productkind;

public class ProductkindDAO {

	//main
	public static void main(String[] args) {
		
	}
	
	//查詢單一productkind
	public static Productkind getOne(String productkindId) {
		Productkind productkind = null;
		SessionFactory factory = null;
		try {
			factory = new Configuration().configure().buildSessionFactory();
		} catch(Exception e) {
			System.out.println("SessionFactory Error: "+e.getMessage());
			return null;
		}
		Session session = factory.openSession();
		session.getTransaction().begin();
		productkind = session.find(Productkind.class, productkindId);
		session.getTransaction().commit();
		factory.close();
		return productkind;
	}
	
	//查詢全部productkind
	public static List<Productkind> getAll() {
		List<Productkind> data = null;
		SessionFactory factory = null;
		try {
			factory = new Configuration().configure().buildSessionFactory();
		} catch(Exception e) {
			System.out.println("SessionFactory Error: "+e.getMessage());
			return null;
		}
		Session session = factory.openSession();
		session.getTransaction().begin();
		data = session.createQuery("FROM Productkind").list();
		session.getTransaction().commit();
		factory.close();
		return data;
	}
	
	//加入一筆productkind
	public static void add(Productkind productkind) {
		SessionFactory factory = null;
		try {
			factory = new Configuration().configure().buildSessionFactory();
		} catch(Exception e) {
			System.out.println("SessionFactory Error: "+e.getMessage());
			return;
		}
		Session session = factory.openSession();
		session.getTransaction().begin();
		session.persist(productkind);
		session.getTransaction().commit();
		factory.close();
	}
	
	//刪除一筆productkind
	public static void delete(String productkindId) {
		SessionFactory factory = null;
		try {
			factory = new Configuration().configure().buildSessionFactory();
		} catch(Exception e) {
			System.out.println("SessionFactory Error: "+e.getMessage());
			return;
		}
		Session session = factory.openSession();
		session.getTransaction().begin();
		Productkind productkind = session.find(Productkind.class, productkindId);
		if(productkind != null) {
			session.remove(productkind);
			session.getTransaction().commit();
		}
		else {
			System.out.println("Productkind " + productkindId + " Not Found.");
			session.getTransaction().rollback();
		}
		factory.close();
	}
	
	//修改一筆product
	public static void update(Productkind productkind) {
		SessionFactory factory = null;
		try {
			factory = new Configuration().configure().buildSessionFactory();
		} catch(Exception e) {
			System.out.println("SessionFactory Error: "+e.getMessage());
			return;
		}
		Session session = factory.openSession();
		session.getTransaction().begin();
		Productkind newProductkind = session.find(Productkind.class, productkind.getProductKindId());
		if(newProductkind != null) {
			newProductkind.setProductKindName(productkind.getProductKindName());
			session.merge(newProductkind);
			session.getTransaction().commit();
		}
		else {
			System.out.println("Productkind " + productkind.getProductKindId() + " Not Found.");
			session.getTransaction().rollback();
		}
		factory.close();
	}
}
