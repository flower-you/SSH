<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>个人中心</title>
</head>
<body>
	<div>
		<img alt="用户头像" src="/testUpload${sessionScope.photoPath}" height="60" width="50">
		<h2><strong><em>${sessionScope.userName} </em></strong></h2>
		<!-- 或者用ognl表达式 <s:property value="#session.userName"/>-->
		<a href="queryUser.action?username=${sessionScope.userName}">基本信息</a>
		<a href="queryAccount.action?username=${sessionScope.userName}">账户安全</a>
	</div>

	<div>
		<a href="">我的订单</a>
		<a href="">我的收藏</a>
		<a href="">购物车</a>
		<a href="">关注店铺</a>
	</div>
</body>
</html>