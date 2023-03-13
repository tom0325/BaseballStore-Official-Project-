package dao;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import model.Product;

public class ProductDAO {

	//main
	public static void main(String[] args) {
		System.out.println(ProductDAO.getByKind("def"));
	}
	
	//查詢product by productKind
	public static List<Product> getByKind(String productKindId) {
		List<Product> data = null;
		SessionFactory factory = null;
		try {
			factory = new Configuration().configure().buildSessionFactory();
		} catch(Exception e) {
			System.out.println("SessionFactory Error: "+e.getMessage());
			return null;
		}
		Session session = factory.openSession();
		session.getTransaction().begin();
		Query<Product> query = session.createQuery("FROM Product p where p.productKindId= :x");
		query.setParameter("x", productKindId);
		data = query.list();
		
		session.getTransaction().commit();
		factory.close();
		return data;
	}
	
	//查詢單一product
	public static Product getOne(int productId) {
		Product product = null;
		SessionFactory factory = null;
		try {
			factory = new Configuration().configure().buildSessionFactory();
		} catch(Exception e) {
			System.out.println("SessionFactory Error: "+e.getMessage());
			return null;
		}
		Session session = factory.openSession();
		session.getTransaction().begin();
		product = session.find(Product.class, productId);
		session.getTransaction().commit();
		factory.close();
		return product;
	}
	
	//查詢全部product
	public static List<Product> getAll() {
		List<Product> data = null;
		SessionFactory factory = null;
		try {
			factory = new Configuration().configure().buildSessionFactory();
		} catch(Exception e) {
			System.out.println("SessionFactory Error: "+e.getMessage());
			return null;
		}
		Session session = factory.openSession();
		session.getTransaction().begin();
		data = session.createQuery("SELECT p FROM Product p").list();
		session.getTransaction().commit();
		factory.close();
		return data;
	}
	
	//加入一筆product
	public static void add(Product product) {
		SessionFactory factory = null;
		try {
			factory = new Configuration().configure().buildSessionFactory();
		} catch(Exception e) {
			System.out.println("SessionFactory Error: "+e.getMessage());
			return;
		}
		Session session = factory.openSession();
		session.getTransaction().begin();
		session.persist(product);
		session.getTransaction().commit();
		factory.close();
	}
	
	//刪除一筆product
	public static void delete(int productId) {
		SessionFactory factory = null;
		try {
			factory = new Configuration().configure().buildSessionFactory();
		} catch(Exception e) {
			System.out.println("SessionFactory Error: "+e.getMessage());
			return;
		}
		Session session = factory.openSession();
		session.getTransaction().begin();
		Product product = session.find(Product.class, productId);
		if(product != null) {
			session.remove(product);
			session.getTransaction().commit();
		}
		else {
			System.out.println("Product " + productId + " Not Found.");
			session.getTransaction().rollback();
		}
		factory.close();
	}
	
	//修改一筆product
	public static void update(Product product) {
		SessionFactory factory = null;
		try {
			factory = new Configuration().configure().buildSessionFactory();
		} catch(Exception e) {
			System.out.println("SessionFactory Error: "+e.getMessage());
			return;
		}
		Session session = factory.openSession();
		session.getTransaction().begin();
		Product newProduct = session.find(Product.class, product.getProductId());
		if(newProduct != null) {
			newProduct.setProductKindId(product.getProductKindId());
			newProduct.setProductName(product.getProductName());
			newProduct.setDescription(product.getDescription());
			newProduct.setPrice(product.getPrice());
			newProduct.setStock(product.getStock());
			newProduct.setEnabled(product.getEnabled());
			session.merge(newProduct);
			session.getTransaction().commit();
		}
		else {
			System.out.println("Product " + product.getProductId() + " Not Found.");
			session.getTransaction().rollback();
		}
		factory.close();
	}
}
