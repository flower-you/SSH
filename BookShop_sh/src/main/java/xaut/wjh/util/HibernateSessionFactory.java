package xaut.wjh.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
/**
 * 单例模式的懒汉式：sessionFactory==null时才进行创建对象
 * 
 * @author 17976
 *
 */
public class HibernateSessionFactory {

	private static SessionFactory sessionFactory;
	static {
		buildSessionFactory();
	}
	private  HibernateSessionFactory() {

	}
	

	public static Session currentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}


	public static void setSessionFactory(SessionFactory sessionFactory) {
		HibernateSessionFactory.sessionFactory = sessionFactory;
	}


	private static void buildSessionFactory() {
		if(sessionFactory==null) {
			final StandardServiceRegistry ssr=new StandardServiceRegistryBuilder().configure().build();
			sessionFactory=new MetadataSources(ssr).buildMetadata().buildSessionFactory();
		}
	}	
}
