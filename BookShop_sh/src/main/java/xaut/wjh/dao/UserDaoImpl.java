package xaut.wjh.dao;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import xaut.wjh.entity.TUsers;
import xaut.wjh.util.MyMD5Util;
import xaut.wjh.util.MySqlUtil;

public class UserDaoImpl extends BaseDaoImpl<TUsers,Integer> implements IUserDao{

	@Override
	public boolean login(TUsers user) {
		String sql="from TUsers u where u.username=? and u.TRoles.id=?";
		Object[] values= new Object[]{user.getUsername(),user.getTRoles().getId()};
		//如果有输入的用户名和角色对应的用户则证明此用户存在
		List<TUsers> list=this.queryByHql(sql, null,values);
		//然后再验证密码是否正确
		if(list.size()>0) {
			String passwordInDb=list.get(0).getPassword();
			try {
				if(MyMD5Util.validPassword(user.getPassword(), passwordInDb)) {
					return true;
				}
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	@Override
	public boolean regist(TUsers user) {
		String encryptedPwd="";
		try {
			//将密码使用MD5加密后再存入数据库
			encryptedPwd = MyMD5Util.getEncryptedPwd(user.getPassword());
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		user.setPassword(encryptedPwd);
		System.out.println("user"+user);
		this.save(user);
		return true;
	}

	@Override
	public boolean existsName(String username) {
		String sql="from TUsers u where u.username=?";
		List<TUsers> list=this.queryByHql(sql,null,username);
		if(list!=null&&list.size()>0) {
			return true;
		}
		return false;
	}

	@Override
	public String getPhotoPath(TUsers user) {
		String hql="select photoName from TUsers u where u.username=?";
		List<String> list=MySqlUtil.myQuery(hql,user.getUsername());
		String photoPath=null;
		if(list!=null&&list.size()>0) {
			photoPath="/"+list.get(0);
		}
		System.out.println("photoPath"+photoPath);
		return photoPath;
	}
	
	//查询用户信息
	@Override
	public TUsers queryUser(TUsers user) {
		String hql="from TUsers u where u.username=?";
		List<TUsers> list=MySqlUtil.myQuery(hql,user.getUsername());
		if(list!=null&&list.size()>0) {
			return list.get(0);
		}
		return null;
	}
	
	@Override
	public TUsers reviseBasic(TUsers user) {
		String sql="update TUsers u set u.age=?,u.sex=?,u.photoName=? where u.id=?";
		Object[] values= {user.getAge(),user.getSex(),user.getPhotoName(),user.getId()};
		this.revise(sql, values);
		//返回更新后的值
		return this.queryUser(user);
	}

	@Override
	public void delUser(TUsers user) {
		String sql="delete from TUsers u where u.id=?";
		this.del(sql, user.getId());
	}
	
	
	
}
