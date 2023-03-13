package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import model.Order;
import model.Orderdetail;
import model.OrderdetailPK;

public class OrderdetailDAO {

	//main
	public static void main(String[] args) {
		System.out.println(OrderdetailDAO.getByOrderId(1129160902).get(0).getTotal());
	}
	
	//用orderId查詢orderdetail
	public static List<Orderdetail> getByOrderId(int orderId) {
		List<Orderdetail> data = null;
		SessionFactory factory = null;
		try {
			factory = new Configuration().configure().buildSessionFactory();
		} catch(Exception e) {
			System.out.println("SessionFactory Error: "+e.getMessage());
			return null;
		}
		Session session = factory.openSession();
		session.getTransaction().begin();
		Query<Orderdetail> query = session.createQuery("FROM Orderdetail o where o.id.orderId= :x");
		query.setParameter("x", orderId);
		data = query.list();
		
		session.getTransaction().commit();
		factory.close();
		return data;
	}
	
	//查詢單一orderdetail
	public static Orderdetail getOne(OrderdetailPK orderdetailId) {
		Orderdetail orderdetail = null;
		SessionFactory factory = null;
		try {
			factory = new Configuration().configure().buildSessionFactory();
		} catch(Exception e) {
			System.out.println("SessionFactory Error: "+e.getMessage());
			return null;
		}
		Session session = factory.openSession();
		session.getTransaction().begin();
		orderdetail = session.find(Orderdetail.class, orderdetailId);
		session.getTransaction().commit();
		factory.close();
		return orderdetail;
	}
	
	//查詢全部orderdetail
	public static List<Orderdetail> getAll() {
		List<Orderdetail> data = null;
		SessionFactory factory = null;
		try {
			factory = new Configuration().configure().buildSessionFactory();
		} catch(Exception e) {
			System.out.println("SessionFactory Error: "+e.getMessage());
			return null;
		}
		Session session = factory.openSession();
		session.getTransaction().begin();
		data = session.createQuery("FROM Orderdetail").list();
		session.getTransaction().commit();
		factory.close();
		return data;
	}
	
	//加入一筆orderdetail
	public static void add(Orderdetail orderdetail) {
		SessionFactory factory = null;
		try {
			factory = new Configuration().configure().buildSessionFactory();
		} catch(Exception e) {
			System.out.println("SessionFactory Error: "+e.getMessage());
			return;
		}
		Session session = factory.openSession();
		session.getTransaction().begin();
		session.persist(orderdetail);
		session.getTransaction().commit();
		factory.close();
	}
	
	//刪除一筆orderdetail
	public static void delete(OrderdetailPK orderdetailId) {
		SessionFactory factory = null;
		try {
			factory = new Configuration().configure().buildSessionFactory();
		} catch(Exception e) {
			System.out.println("SessionFactory Error: "+e.getMessage());
			return;
		}
		Session session = factory.openSession();
		session.getTransaction().begin();
		Orderdetail orderdetail = session.find(Orderdetail.class, orderdetailId);
		if(orderdetail != null) {
			session.remove(orderdetail);
			session.getTransaction().commit();
		}
		else {
			System.out.println("Orderdetail " + orderdetailId + " Not Found.");
			session.getTransaction().rollback();
		}
		factory.close();
	}
	
	//修改一筆orderdetail
	public static void update(Orderdetail orderdetail) {
		SessionFactory factory = null;
		try {
			factory = new Configuration().configure().buildSessionFactory();
		} catch(Exception e) {
			System.out.println("SessionFactory Error: "+e.getMessage());
			return;
		}
		Session session = factory.openSession();
		session.getTransaction().begin();
		Orderdetail newOrderdetail = session.find(Orderdetail.class, orderdetail.getId());
		if(newOrderdetail != null) {
			newOrderdetail.setQuantity(orderdetail.getQuantity());
			newOrderdetail.setPrice(orderdetail.getPrice());
			newOrderdetail.setTotal(orderdetail.getTotal());
			session.merge(newOrderdetail);
			session.getTransaction().commit();
		}
		else {
			System.out.println("Orderdetail " + orderdetail.getId() + " Not Found.");
			session.getTransaction().rollback();
		}
		factory.close();
	}
}
