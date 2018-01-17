<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'listone.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
table {
	border: 1px solid black;
}

td {
	width: 100px;
	border: 1px solid black;
}
</style>
</head>

<body>
	<center>

		<table>
			<caption>用户信息</caption>
			<tr>
				<td>编号</td>
				<td>姓名</td>
				<td>性别</td>
				<td>生日</td>
				<td>电话</td>
				<td>邮箱</td>
				<td>描述</td>
				<td>操作</td>
			</tr>

			<tr>
				<td>${param.id}</td>
				<td>${customer.name}</td>
				<td>${customer.gender}</td>
				<td>${customer.birthday}</td>
				<td>${customer.phone}</td>
				<td>${customer.email}</td>
				<td>${customer.desc}</td>
				<td><a href="servlet/DeleteServlet?id=${param.id}">删除</a>
				</td>
			</tr>
		</table>
	</center>
</body>
</html>
