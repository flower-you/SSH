package xaut.wjh.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.hibernate.Session;

import xaut.wjh.entity.PageBean;
import xaut.wjh.util.HibernateSessionFactory;
import xaut.wjh.util.MySqlUtil;

public class BaseDaoImpl<T extends Serializable,ID extends Serializable> implements IBaseDao<T,ID>{

	 //获取T的Class对象是关键，看构造方法
    private Class<T> persistClass = null;
   
    /**
     * 当子类继承时就会加载BaseDaoTmpl的构造方法o，就能得到子类实例化之后的泛型具体类
     */
    public BaseDaoImpl() {
        //为了得到T的Class，采用如下方法
        //1得到该泛型类的子类对象的Class对象
        Class clz = this.getClass();
        //2得到子类对象的泛型父类类型（也就是BaseDaoImpl<T>）
      //例如：type: xaut.wjh.dao.BaseDaoImpl<xaut.wjh.entity.TUsers>
        ParameterizedType type = (ParameterizedType) clz.getGenericSuperclass();
      //  System.out.println("type"+type);
        Type[] types = type.getActualTypeArguments();
        
        //例如：persistClass.getSimpleName()=TUsers
        persistClass = (Class<T>) types[0];
       // System.out.println("clsSimpleName"+persistClass.getSimpleName());
    }
	
	@Override
	public Serializable save(Serializable entity) {
		Session session=HibernateSessionFactory.getSessionFactory().getCurrentSession();
		session.save(entity);
		return entity;
	}

	@Override
	public T load(ID id) {
		Session session=HibernateSessionFactory.getSessionFactory().getCurrentSession();
		T entity=session.load(persistClass,id);
		return entity;
	}
	
	@Override
	public List<T> queryByHql(String sql, PageBean<T> page,Object... values) {
		if(page!=null&&page.getPageSize()>0) {
//			if(page.getTotalPages()<1) {
				int totalRecords=MySqlUtil.myQuerytForList(sql, values).size();//获得查询出的总记录数
				System.out.println("totalRecords"+totalRecords);
				if(totalRecords<1) {//无记录
					return null;
				}
				//根据记录数计算总页数
				int totalPages=(totalRecords+page.getPageSize()-1)/5;//例如(21+4)/5=5,(24+4)/5=5;(20+4)/5=4,(25+4)/5=5
				page.setTotalPages(totalPages);
				page.setTotalRecords(totalRecords);
//			}
			if(page.getCurrentPage()>page.getTotalPages()) {//容错处理
				page.setCurrentPage(page.getTotalPages());
			}
			int begin=(page.getCurrentPage()-1)*page.getPageSize();
			System.out.println("queryByHql的begin"+begin);
			System.out.println("queryByHql的page"+page);
			List<T> list=MySqlUtil.queryForPage(sql, values, begin,page.getPageSize());
			return list;
		}
		//若Page为null则不进行分页处理
		return MySqlUtil.myQuerytForList(sql, values);
	}

	@Override
	public void revise(String sql,Object...values) {
		MySqlUtil.update(sql, values);
		
	}
	
	@Override
	public void del(String sql, Object... values) {
		// TODO Auto-generated method stub
		MySqlUtil.update(sql, values);
	}
	

	/**
	 * QBC查询
	 * 传入的entity为条件bean，在调用此方法之前必须创建一个bean,并设置相应的条件参数，
	 * 且无法将其通用化，无法创建相应的工具类，反射也无法根据参数类型获取到相应的类中的方法，因为一个类中可能会有很多参数类型相同的方法
	 * 虽然实现上很通用，但是调用起来感觉有点不方便
	 * 而且如果要查询某个单字段 的值时，还需要遍历返回的集合，才能获得相应的属性值
	 * 以上两点就使得调用起来很麻烦了，调用时要写的代码就很多。
	 * 该写的还得写，不想在调用的时候写，那就只能在具体实现的时候写了。
	 */


}
