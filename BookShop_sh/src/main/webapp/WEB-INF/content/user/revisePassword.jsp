<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>修改密码</title>
</head>
<body>
	<form action="" method="post">
		<!-- 查询与数据库中的是否一致，一致修改成功，跳回登录页，否则返回修改页 -->
		旧密码:<input type="password" name="password">
		新密码:<input type="password" name="newPassword">
		<!-- 添加客户端效验 -->
		重复新密码:<input type="password" name="reNewPassword">
		<span><input type="submit" value="确定">
		
	</form>
</body>
</html>