package xaut.wjh.dao;

import xaut.wjh.entity.TUsers;

public interface IUserDao extends IBaseDao<TUsers,Integer>{
	public boolean login(TUsers user);
	
	public boolean regist(TUsers user);
	
	public boolean existsName(String username);
	
	public String getPhotoPath(TUsers user);
	
	public TUsers queryUser(TUsers user);
	
	public TUsers reviseBasic(TUsers user);
	
	public void delUser(TUsers user);
	
}
