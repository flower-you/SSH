<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>用户登录</title>
<s:head/>
</head>
<script type="text/javascript">
	function defaultRadio(){
		document.getElementsByName("TRoles.id")[0].checked=true;
	}
</script>
<body onload="defaultRadio();">
  <s:form action="loginVerify.action" method="post">
  	<s:textfield name="username" label="用户名" size="15" requiredLabel="true"/>
  	<s:password name="password" label="密    码" size="16" />
  	<s:radio list="#application.roleList" listKey="id" listValue="rolename" 
  	headerKey="id" headerValue="rolename" name="TRoles.id" label="用户身份"></s:radio>
  	<s:submit value="登录" requiredPosition="center" size="16" color="red"/>
  	<tr><td><a href="registInput.action"><font size="2" color="gray">立即注册</font></a></td></tr>
  </s:form>
  	<font color="red">${message}</font>
</body>
</html>