package xaut.wjh.biz;

import java.util.List;

import xaut.wjh.entity.PageBean;
import xaut.wjh.entity.TBooks;

public interface IBookServ {

	public List<TBooks> qBookByNameOrAuth(TBooks book,PageBean page);
	
	public TBooks bookDetail(TBooks book);
}
