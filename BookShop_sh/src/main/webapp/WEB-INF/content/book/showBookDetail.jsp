<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>图书详情</title>
</head>
<body>
<!-- 用el表达式也可以获取，例如：${bookDetail.name} -->
	<s:if test="#request.bookDetail!=null">
		<form action="">
			<div id="bookDetail">
				<div id="bookImag">
					<img src="/testUpload/<s:property value="#request.bookDetail.imag"/>" height="80" width="60">
				</div>
				<div id="detail">
					<br/><strong><s:property value="#request.bookDetail.name"/></strong>
					<br/>作者：<s:property value="#request.bookDetail.auth"/>
					<br/>出版社：<s:property value="#request.bookDetail.publisher"/>
					<br/>单价<font color="red" size="5">¥<s:property value="#request.bookDetail.price*#request.bookDetail.rebate"/></font>
					&nbsp;&nbsp;(<font size="3" color="red"><s:property value="#request.bookDetail.rebate"/>折</font>)
					&nbsp;&nbsp;<font size="5" color="gray">定价：<s:property value="#request.bookDetail.price"/></font>
					<br/>简介：<s:property value="#request.bookDetail.brief"/>
				</div>
			</div>
			<div></div>
			<div id="btn">
				<input type="submit" value="加入购物车">
				<input type="submit" value="立即购买">
			</div>
		</form>
	</s:if>
</body>
</html>