package xaut.wjh.interceptor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
/**
 * 拦截非登陆用户请求
 * @author 小花花
 *
 */
public class LoginInterceptor extends MethodFilterInterceptor{

	private static final long serialVersionUID = 3398835284260821910L;

	@Override
	protected String doIntercept(ActionInvocation arg0) throws Exception {
		Object loginUserName=ActionContext.getContext().get("username");
		System.out.println("LoginInterceptor"+loginUserName.toString());
		if(null==loginUserName) {
			return "login";
		}
		return null;
	}

	
}
