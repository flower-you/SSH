<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>用户基本信息</title>
</head>
<script type="text/javascript">
function revise(){
	alert("保存成功！");
}
</script>
<body>
	<form action="reviseUser.action?id=${user.id}" method="post" enctype="multipart/form-data">
		<table align="center" border="0" width="400" height="100">
			<tr>
				<td><img alt="用户头像" src="/testUpload${sessionScope.photoPath}" height="80" width="60"></td>
				<th><font size="5">${user.username}</font></th>
			</tr>
			<tr>
				<td>重新上传<input type="file" name="photo" value="${photoPath}"></td>
			</tr>
			<tr>
				<td>
					<s:if test="#session.user.sex">
						<s:radio list="#{true:'男',false:'女' }" name="sex" label="性别" value="true"/>
					</s:if>
					<s:else>
						<s:radio list="#{true:'男',false:'女' }" name="sex" label="性别" value="false"/>
					</s:else>
				</td>
			</tr>
			 
				
				 
			<!-- 
				<tr>
					<td>手机号码:<input type="text" name="phone" value="${user.phone}"></td>
				</tr>
			 -->
			<tr>
				<td>年龄:<input type="text" name="age" value="${user.age}"></td>
			</tr>
			<tr>
				<td><input type="submit" value="保存" onClick="revise()"></td>
				<!-- 返回到个人中心页面 -->
				<td><input type="submit" value="返回"></td>
			</tr>
		</table>
	</form>
</body>
</html>