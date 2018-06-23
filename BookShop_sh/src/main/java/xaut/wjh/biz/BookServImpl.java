package xaut.wjh.biz;

import java.util.List;

import xaut.wjh.dao.IBookDao;
import xaut.wjh.entity.PageBean;
import xaut.wjh.entity.TBooks;
import xaut.wjh.util.DaoFactory;

public class BookServImpl implements IBookServ{

	private IBookDao bookDao=DaoFactory.getBookDao();
	
	@Override
	public List<TBooks> qBookByNameOrAuth(TBooks book,PageBean page) {
		return bookDao.queryBook(book, page);
	}
	
	@Override
	public TBooks bookDetail(TBooks book) {
		return bookDao.bookDetail(book.getId());
	}
	
}
