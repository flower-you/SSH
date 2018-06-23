package xaut.wjh.dao;

import java.io.Serializable;
import java.util.List;

import xaut.wjh.entity.PageBean;

public interface IBaseDao <T extends Serializable,ID extends Serializable>{
	//数据插入，例如用户注册，新增图书
	public T save(T entity);
	
	//通过页数进行查询
    public List<T> queryByHql(String sql,PageBean<T> page,Object...values);
	
	//通过ID进行查询，返回查询到的当前类的实体对象
	public T load(ID id);
	
	//修改
	public void revise(String sql,Object...values);
	
	public void del(String sql,Object...values);

}
