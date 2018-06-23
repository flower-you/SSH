package xaut.wjh.dao;

import java.util.List;

import xaut.wjh.entity.PageBean;
import xaut.wjh.entity.TRoles;

public interface IRoleDao extends IBaseDao<TRoles,Integer>{

	public List<TRoles> getAllRoles();
}
