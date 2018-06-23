package xaut.wjh.action;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import xaut.wjh.dao.IRoleDao;
import xaut.wjh.dao.IUserDao;
import xaut.wjh.entity.TRoles;
import xaut.wjh.entity.TUsers;
import xaut.wjh.util.DaoFactory;

public class UserAction extends ActionSupport implements ModelDriven<TUsers>,
SessionAware,ApplicationAware{
	
	private static final long serialVersionUID = 5966068460896929755L;

	private TUsers user=new TUsers();
	
	private File photo;//和输入域的名称一致，是上传到服务器的临时文件对象
	private String photoContentType;//命名规则：输入域名称-contentType,用于表示上传文件的MIME类型
	private String photoFileName;//命名规则：输入域名称-FileName,用于表示上传文件在客户端时的文件名称，不包含路径
    
	private String message;

	private IUserDao userdao=DaoFactory.getUserDao();
	private IRoleDao roledao=DaoFactory.getRoleDao();
	
	ActionContext ac=ActionContext.getContext();
	Map<String,Object> request=(Map)ac.get("request");
	
	private Map<String,Object> applicationAttribute=ac.getApplication();
	private Map<String,Object> sessionAttribute=ac.getSession();
	
	private String generateFileName() {
		//32位
		String str=UUID.randomUUID().toString();
		str=str.replaceAll("-","");
		
		if(photoFileName!=null&&photoFileName.indexOf(".")>0) {
			String fileExt=photoFileName.substring(photoFileName.lastIndexOf("."));
			str+=fileExt;
		}
		return str;
	}
	//
	@Override
	public String execute() throws Exception {
		return "upload";
	}
	
	public String test() throws Exception {
		return super.execute();
	}
	public String login() {
		Object obj=applicationAttribute.get("roleList");

		if(obj==null||(obj instanceof List)||((List)obj).size()<1) {
			List<TRoles> rList=roledao.getAllRoles();
			applicationAttribute.put("roleList", rList);
		}

		return "login";
	}
	public String loginVerify() {
		
		if(userdao.login(user)) {
			sessionAttribute.put("userName", user.getUsername());
			sessionAttribute.put("photoPath",userdao.getPhotoPath(user));
			return "success";
		}
		else
			message="登录失败！请重新输入！";
			return "failure";
		
	}
	public String registInput() {
		return "registInput";
	}
	
	public String userRegist() throws Exception{
		
		upload();
		boolean flag=userdao.regist(user);
		if(flag) {
			return "success";
		}
		return "failure";
	}
	
	public void upload() throws IOException {
		
		if(photo!=null&&photo.length()>0) {//判断是否有上传文件
			String realPath="D:/testUpload";
			String newFileName=this.generateFileName();
			File destFile=new File(realPath,newFileName);
			FileUtils.copyFile(photo, destFile);
			user.setPhotoName(newFileName);
		}
		
	}
	
	public String queryUser() {
		TUsers tuser=userdao.queryUser(user);
		sessionAttribute.put("user", tuser);
		return "userMessage";
	}
	
	public String queryUserAccount() {
		TUsers tuser=userdao.queryUser(user);
		sessionAttribute.put("user", tuser);
		return "userMessage";
	}
	/**
	 * 在修改用户信息时，如果一次只修改一个值，其实没必要定义多个method,可在action中增加一个属性reviseField
	 * 前端传入要修改的属性名，method根据reviseField的不同，然后返回不同的值，以实现跳转不同的页面
	 * @return
	 */
	public String reviseUser() {
		try {
			upload();
		} catch (IOException e) {
			e.printStackTrace();
		}
		TUsers tuser=userdao.reviseBasic(user);
		sessionAttribute.put("user", tuser);
		return "userCenter";
	}
	
	public String toRevisePassword() {
		return "toRevisePassword";
	}
	
	
	public String revisePassword() {
		return "toLogin";
	}
	
	public String delUser() {
		userdao.delUser(user);
		return "toIndex";
	}
	
	@Override
	public TUsers getModel() {
		//System.out.println(user);
		return user;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public void setApplication(Map<String, Object> application) {
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		
	}
	
	public File getPhoto() {
		return photo;
	}

	public void setPhoto(File photo) {
		this.photo = photo;
	}

	public String getPhotoContentType() {
		return photoContentType;
	}

	public void setPhotoContentType(String photoContentType) {
		this.photoContentType = photoContentType;
	}

	public String getPhotoFileName() {
		return photoFileName;
	}
 
	public void setPhotoFileName(String photoFileName) {
		this.photoFileName = photoFileName;
	}

}
