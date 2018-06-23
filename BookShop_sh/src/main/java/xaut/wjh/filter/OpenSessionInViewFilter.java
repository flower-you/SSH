package xaut.wjh.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import xaut.wjh.util.HibernateSessionFactory;

public class OpenSessionInViewFilter implements Filter{

	

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {

		Transaction ts=null;
		try {
			ts=HibernateSessionFactory.currentSession().beginTransaction();
			arg2.doFilter(arg0, arg1);
			if(ts!=null) {
				ts.commit();
			}
		}
		catch (Exception e) {
			if(ts!=null)
				ts.rollback();
		}
		
	}

	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	
}
