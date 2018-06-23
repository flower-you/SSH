package xaut.wjh.dao;

import java.util.List;

import xaut.wjh.entity.PageBean;
import xaut.wjh.entity.TBooks;
import xaut.wjh.util.MySqlUtil;

public class BookDaoImpl extends BaseDaoImpl<TBooks,Integer> implements IBookDao{

	//根据书名或者作者名进行模糊查询
	public List<TBooks> queryBook(TBooks book,PageBean page){
		String sql="from TBooks b where b.name=? or b.auth=?";
		System.out.println("queryBook中的book"+book);
		Object[] values= new Object[]{book.getName(),book.getName()};
		List<TBooks> list=this.queryByHql(sql,page, values);
		return list;
	}

	//图书详情展示
	@Override
	public TBooks bookDetail(Integer id) {
		return this.load(id);
	}
	

}
