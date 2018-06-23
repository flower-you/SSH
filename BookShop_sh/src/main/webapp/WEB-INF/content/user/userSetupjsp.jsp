<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>设置</title>
</head>
<body>
	<img alt="用户头像" src="/testUpload${sessionScope.photoPath}" height="40" width="30">
	<h5><strong><em>${sessionScope.userName} </em></strong></h5>
	<a href="">收货地址</a>
	<a href="">账户安全</a>
	<a href=""><button>退出当前账户</button></a>
</body>
</html>