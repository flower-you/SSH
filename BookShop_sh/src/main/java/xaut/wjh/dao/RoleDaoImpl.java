package xaut.wjh.dao;

import java.util.List;

import xaut.wjh.entity.PageBean;
import xaut.wjh.entity.TRoles;

public class RoleDaoImpl extends BaseDaoImpl<TRoles,Integer> implements IRoleDao{

	@Override
	public List<TRoles> getAllRoles() {
		String sql="from TRoles";
		List<TRoles> roles=this.queryByHql(sql, null,null);
		return roles;
	}
}
