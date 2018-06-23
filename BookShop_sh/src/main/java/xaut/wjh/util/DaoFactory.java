package xaut.wjh.util;

import xaut.wjh.dao.BookDaoImpl;
import xaut.wjh.dao.IBookDao;
import xaut.wjh.dao.IRoleDao;
import xaut.wjh.dao.IUserDao;
import xaut.wjh.dao.RoleDaoImpl;
import xaut.wjh.dao.UserDaoImpl;

public class DaoFactory {

	public static IUserDao getUserDao() {
		IUserDao userdao=new UserDaoImpl();
		return userdao;
	}
	
	public static IRoleDao getRoleDao() {
		IRoleDao roledao=new RoleDaoImpl();
		return roledao;
	}
	
	public static IBookDao getBookDao() {
		IBookDao bookDao=new BookDaoImpl();
		return bookDao;
	}
}

