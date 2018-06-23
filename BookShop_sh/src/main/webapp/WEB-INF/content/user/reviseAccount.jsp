<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>账户安全</title>
</head>
<script type="text/javascript">
	function delAccount(id){
		var cc=window.confirm("注销账户将清除您的所有信息！且无法再使用该账号！您确定要注销你的账号吗?");
		location.href='delUser.action?id='+id;
		
	}
	function rePassword(id){
		location.href='toRePassword.action?id='+id;
	}
</script>
<body>
	<s:form action="reviseAccout.action">
		手机号：<input type="text" name="phone" value="${user.phone}">
		<!-- 需要添加短信验证 -->
		<input type="button" value="修改手机号" id="revisePhone"onClick="">
		<br/>
		<input type="button" value="注销账户" id="${user.id}" onClick="delAccount(this.id)">
		 <br/>
		 <!-- 跳入修改页，成功后跳回登录页 -->
		<a><button>修改密码</button></a>
	</s:form>
</body>
</html>