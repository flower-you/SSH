<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>用户登录222</title>
<s:head/>
</head>
<script type="text/javascript">
	function ff(){
		var img=document.getElementById('img1');
		img.src='images/pic.do?q='+Math.random();
	}
</script>
<body onload="ff();">
  <form action="loginVerify.action" method="post">
  	<input type="text" name="username" value="用户名" size="15" />
  	<s:password name="password" label="密    码" size="16" />
  	<tr><td colspan="2">
  		<s:textfield name="vImage" label="验证码" size="15"/>
  		<td><img id="img1"/></td>
  	</td></tr>
  	<s:select list="#application.roleList" listKey="id" listValue="rolename" 
  	headerKey="" headerValue="请选择用户身份" name="role.id" label="用户身份"/>
  	<tr><td><s:submit value="登录" requiredPosition="center" size="16" color="red"/></td></tr>
  	<td><a href="registInput.action"><font size="2" color="gray"></font>立即注册</a><td>
  </td></form>
  	<font color="red">${message}</font>
</body>
</html>