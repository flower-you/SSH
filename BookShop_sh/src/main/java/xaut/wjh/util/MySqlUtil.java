package xaut.wjh.util;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

public class MySqlUtil {
	
	public static List myQuery(String sql,Object...values) {
		Session session=HibernateSessionFactory.currentSession();
		Query query=session.createQuery(sql);
		if(values!=null) {//必须先进行判空处理，否则若values为空会出现空指针异常
			for(int i=0;i<values.length;i++) {
				query.setParameter(i, values[i]);
			}
		}
		List list=query.list();
		return list;
	}

	public static List myQuerytForList(String sql,Object[] values) {
		Session session=HibernateSessionFactory.currentSession();
		Query query=session.createQuery(sql);
		if(values!=null) {
			for(int i=0;i<values.length;i++) {
				query.setParameter(i, values[i]);
				
			}
		}
		List list=query.list();
		return list;
	}
	
	/**
	 * 分页查询
	 * @param sql
	 * @param values sql中的参数值
	 * @param pages begin,pageSize
	 * @return
	 */
	public static<T> List<T> queryForPage(String sql,Object[] values,int...pages) {
		Session session=HibernateSessionFactory.currentSession();
		Query query=session.createQuery(sql);
		if(values!=null) {
			for(int i=0;i<values.length;i++) {
				query.setParameter(i, values[i]);
				
			}
		}
		if(pages!=null&&pages.length>0) {
			query.setFirstResult(pages[0]);
		}
		if(pages!=null&&pages.length>1) {
			query.setMaxResults(pages[1]);
		}
		List<T> list=query.list();
		return list;
	}
	
	public static<T> void update(String sql,Object...values) {
		Session session=HibernateSessionFactory.currentSession();
		Query query=session.createQuery(sql);
		if(values!=null) {
			for (int i = 0; i < values.length; i++) {
				query.setParameter(i, values[i]);
			}
		}
		query.executeUpdate();
	}
}
