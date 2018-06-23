<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title> </title>
</head>
<body>
<form action="queryBook.action" method="post">
<font size=3>
   		<tr valign="bottom">
   			<td><a href="queryByType.action">图书分类</a></td>
   			&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;
   			<td><s:textfield name="name" value="书名/作者"/></td><td><a href="queryBook.action"><button>查询图书</button></a></td>
   			&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;
   			<td><a href="loginInput.action"><font size="2" color="red">个人中心</font></a></td>
  		</tr>
	</font>
</form>
</body>
</html>