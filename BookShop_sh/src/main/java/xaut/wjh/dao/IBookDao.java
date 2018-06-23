package xaut.wjh.dao;

import java.util.List;

import xaut.wjh.entity.PageBean;
import xaut.wjh.entity.TBooks;

public interface IBookDao extends IBaseDao<TBooks,Integer>{
	//新增图书
	
	//展示图书列表，根据分类，根据关键字模糊查询	
	public List<TBooks> queryBook(TBooks book,PageBean page);
	
	public TBooks bookDetail(Integer id);
	
}
