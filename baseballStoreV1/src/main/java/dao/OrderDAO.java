package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import model.Order;
import model.Product;

public class OrderDAO {

	//main
	public static void main(String[] args) {
		List<Order> list = OrderDAO.getByPhone("0987654322");
		list.forEach((o)->System.out.println(o.getOrderId()));
	}
	
	//用status查詢order 
		public static List<Order> getByStatus(String status) {
			List<Order> data = null;
			SessionFactory factory = null;
			try {
				factory = new Configuration().configure().buildSessionFactory();
			} catch(Exception e) {
				System.out.println("SessionFactory Error: "+e.getMessage());
				return null;
			}
			Session session = factory.openSession();
			session.getTransaction().begin();
			Query<Order> query = session.createQuery("FROM Order o where o.status= :x");
			query.setParameter("x", status);
			data = query.list();
			
			session.getTransaction().commit();
			factory.close();
			return data;
		}
	
	//用手機號碼查詢order 
	public static List<Order> getByPhone(String phone) {
		List<Order> data = null;
		SessionFactory factory = null;
		try {
			factory = new Configuration().configure().buildSessionFactory();
		} catch(Exception e) {
			System.out.println("SessionFactory Error: "+e.getMessage());
			return null;
		}
		Session session = factory.openSession();
		session.getTransaction().begin();
		Query<Order> query = session.createQuery("FROM Order o where o.phone= :x");
		query.setParameter("x", phone);
		data = query.list();
		
		session.getTransaction().commit();
		factory.close();
		return data;
	}
	
	//查詢單一order
	public static Order getOne(int orderId) {
		Order order = null;
		SessionFactory factory = null;
		try {
			factory = new Configuration().configure().buildSessionFactory();
		} catch(Exception e) {
			System.out.println("SessionFactory Error: "+e.getMessage());
			return null;
		}
		Session session = factory.openSession();
		session.getTransaction().begin();
		order = session.find(Order.class, orderId);
		session.getTransaction().commit();
		factory.close();
		return order;
	}
	
	//查詢全部order
	public static List<Order> getAll() {
		List<Order> data = null;
		SessionFactory factory = null;
		try {
			factory = new Configuration().configure().buildSessionFactory();
		} catch(Exception e) {
			System.out.println("SessionFactory Error: "+e.getMessage());
			return null;
		}
		Session session = factory.openSession();
		session.getTransaction().begin();
		data = session.createQuery("FROM Order").list();
		session.getTransaction().commit();
		factory.close();
		return data;
	}
	
	//加入一筆order
	public static void add(Order order) {
		SessionFactory factory = null;
		try {
			factory = new Configuration().configure().buildSessionFactory();
		} catch(Exception e) {
			System.out.println("SessionFactory Error: "+e.getMessage());
			return;
		}
		Session session = factory.openSession();
		session.getTransaction().begin();
		session.persist(order);
		session.getTransaction().commit();
		factory.close();
	}
	
	//刪除一筆order
	public static void delete(int orderId) {
		SessionFactory factory = null;
		try {
			factory = new Configuration().configure().buildSessionFactory();
		} catch(Exception e) {
			System.out.println("SessionFactory Error: "+e.getMessage());
			return;
		}
		Session session = factory.openSession();
		session.getTransaction().begin();
		Order order = session.find(Order.class, orderId);
		if(order != null) {
			session.remove(order);
			session.getTransaction().commit();
		}
		else {
			System.out.println("Order " + orderId + " Not Found.");
			session.getTransaction().rollback();
		}
		factory.close();
	}
	
	//修改一筆order
	public static void update(Order order) {
		SessionFactory factory = null;
		try {
			factory = new Configuration().configure().buildSessionFactory();
		} catch(Exception e) {
			System.out.println("SessionFactory Error: "+e.getMessage());
			return;
		}
		Session session = factory.openSession();
		session.getTransaction().begin();
		Order newOrder = session.find(Order.class, order.getOrderId());
		if(newOrder != null) {
			newOrder.setPhone(order.getPhone());
			newOrder.setTotal(order.getTotal());
			newOrder.setStatus(order.getStatus());;
			session.merge(newOrder);
			session.getTransaction().commit();
		}
		else {
			System.out.println("Order " + order.getOrderId() + " Not Found.");
			session.getTransaction().rollback();
		}
		factory.close();
	}
}
