package dao;

import java.util.List;

import org.hibernate.*;
import org.hibernate.cfg.*;

import model.Member;

public class memberDAO {

	public static void main(String[] args) {
		System.out.println(memberDAO.getAll());
	}
	
	
	//hibernate新增
   public static void addMember(Member m) {
	   SessionFactory f=null;
	   try {
		   f=new Configuration().configure().buildSessionFactory();
	   }catch(Exception ex) {
		   System.out.println("SessionFactory Error:"+ex.getMessage());
		   return;
	   }
	   Session mm=f.openSession();
	   mm.getTransaction().begin();
	   mm.persist(m);
	   mm.getTransaction().commit();	   
	   System.out.println(m.toString()+" add to Member Table");
   }

	   //全查詢
	   public static List<Member> getAll() {
			List<Member> data = null;
			SessionFactory factory = null;
			try {
				factory = new Configuration().configure().buildSessionFactory();
			} catch(Exception e) {
				System.out.println("SessionFactory Error: "+e.getMessage());
				return null;
			}
			Session session = factory.openSession();
			session.getTransaction().begin();
			data = session.createQuery("FROM Member").list();
			session.getTransaction().commit();
			factory.close();
			return data;
		}
		
	 //查詢單一member
		public static Member getOne(String phone) {
			Member m = null;
			SessionFactory factory = null;
			try {
				factory = new Configuration().configure().buildSessionFactory();
			} catch(Exception e) {
				System.out.println("SessionFactory Error: "+e.getMessage());
				return null;
			}
			Session session = factory.openSession();
			session.getTransaction().begin();
			m = session.find(Member.class, phone);
			session.getTransaction().commit();
			factory.close();
			return m;
		}
	   
		//刪除一筆member
		public static void delete(String phone) {
			SessionFactory factory = null;
			try {
				factory = new Configuration().configure().buildSessionFactory();
			} catch(Exception e) {
				System.out.println("SessionFactory Error: "+e.getMessage());
				return;
			}
			Session session = factory.openSession();
			session.getTransaction().begin();
			Member m = session.find(Member.class, phone);
			if(m != null) {
				session.remove(m);
				session.getTransaction().commit();
			}
			else {
				System.out.println("Member " + phone + " Not Found.");
				session.getTransaction().rollback();
			}
			factory.close();
		}
		
		//修改一筆member
		public static void update(Member m) {
			SessionFactory factory = null;
			try {
				factory = new Configuration().configure().buildSessionFactory();
			} catch(Exception e) {
				System.out.println("SessionFactory Error: "+e.getMessage());
				return;
			}
			Session session = factory.openSession();
			session.getTransaction().begin();
			Member update = session.find(Member.class, m.getPhone());
			if(update != null) {
				update.setPhone(m.getPhone());
				update.setName(m.getName());
				update.setPassword(m.getPassword());
				update.setEmail(m.getEmail());
				update.setAddress(m.getAddress());
				update.setEnabled(m.getEnabled());
				session.merge(update);
				session.getTransaction().commit();
			}
			else {
				System.out.println("Member " + m.getPhone() + " Not Found.");
				session.getTransaction().rollback();
			}
			factory.close();
		}
}
