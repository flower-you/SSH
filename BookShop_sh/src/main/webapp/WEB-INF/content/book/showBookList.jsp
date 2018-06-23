<%@ page language="java" import="java.sql.*" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>图书列表</title>
</head>
<script type="text/javascript">
	function nameFont(){
		//将查询后的结果中的条件关键字显示为红色
	}
</script>
<body>
	<s:if test="#request.bookList.size()>0">
		<table align="center" border="2" width="600" height="200">
			<tr>
				<th>封面</th><th>图书名称</th><th>作者</th><th>出版社</th><th>版次</th>
			</tr>
			<s:iterator value="#request.bookList" var="book">
				<tr>
					<td align="center"><a href="bookDetail.action?id=<s:property value="#book.id"/>"><img alt="书籍封面" src="/testUpload/<s:property value="#book.imag"/>" height="80" width="60"></a></td>
					<td align="center"><a href="bookDetail.action?id=<s:property value="#book.id"/>"><s:property value="#book.name"/></a></td>
					<td align="center"><s:property value="#book.auth"/></td>
					<td align="center"><s:property value="#book.publisher"/></td>
					<td align="center"><s:property value="#book.versions"/></td>
				</tr>
			</s:iterator>
		</table>
	</s:if>
	<s:else>
		暂时没有你要查找的书籍！
	</s:else>
	当前第<s:property value="#request.page.currentPage"/>/<s:property value="#request.page.totalPages"/>页
	<s:if test="#request.page.totalPages>0">
		<a href="queryBook.action?currentPage=1&name=<s:property value="#request.nameUrl"/>">首页</a>
	</s:if>
	
	<s:if test="page.currentPage>1">
		<a href="queryBook.action?currentPage=<s:property value="page.currentPage-1"/>&name=<s:property value="#request.nameUrl"/>">上一页</a>
		<s:if test="page.currentPage<page.totalPages">
			<a href="queryBook.action?currentPage=<s:property value="page.currentPage+1"/>&name=<s:property value="#request.nameUrl"/>">下一页</a>
		</s:if>
	</s:if>
	<s:else>
		<s:if test="#request.page.currentPage<#request.page.totalPages">
			<a href="queryBook.action?currentPage=<s:property value="page.currentPage+1"/>&name=<s:property value="#request.nameUrl"/>">下一页</a>
		</s:if>
	</s:else>	
</body>
</html>