package xaut.wjh.util;

import xaut.wjh.biz.BookServImpl;
import xaut.wjh.biz.IBookServ;
import xaut.wjh.dao.IUserDao;

public class ServiceFactory {

	public static IBookServ getBookServ() {
		return new BookServImpl();
	}
	
//	public static IUserDao getUserSev() {
//		return new UserServImpl();
//	}
}
