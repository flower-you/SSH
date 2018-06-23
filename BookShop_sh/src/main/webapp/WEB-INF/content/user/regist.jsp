<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>用户注册</title>
</head>
<script type="text/javascript">
	function defaultRadio(){
		document.getElementsByName("TRoles.id")[0].checked=true;
	}
</script >
<body onload="defaultRadio();">
	<s:form action="userRegist.action" method="post" enctype="multipart/form-data">
		<s:textfield name="username" label="用户名" size="15"/>
		<s:password name="password" label="密     码" size="16"/>
		<s:password name="repassword" label="确认密码" size="16"/>
		<s:radio list="#{true:'男',false:'女' }" name="sex" label="性别" value="true"/>
		<s:textfield name="age" label="年龄" size="16"/>
		<s:textfield name="phone" label="电话" size="16"/>
		<s:file name="photo" label="用户头像" value="images/defaultPhotos/皮卡丘.jpg"/>
		<s:radio list="#application.roleList" listKey="id" listValue="rolename" 
  	headerKey="id" headerValue="rolename" name="TRoles.id" label="用户身份"></s:radio>
		<tr>
			<td>
			   <s:submit value="立即注册" requiredPosition="center"/>
			</td>
		</tr>
	</s:form>
</body>
</html>