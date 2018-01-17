<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'list.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
td {
	width: 100px;
	border: 1px solid black;
}
</style>
</head>

<body>
	<table style="border: 1px solid black; margin:auto;">
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

		<c:forEach items="${pb.beanList}" var="customer">
			<tr>
				<td>${customer.id}</td>
				<td>${customer.name}</td>
				<td>${customer.gender}</td>
				<td>${customer.birthday}</td>
				<td>${customer.phone}</td>
				<td>${customer.email}</td>
				<td>${customer.desc}</td>
				<td><a href="servlet/DeleteServlet?id=${customer.id}">删除</a></td>
			</tr>
		</c:forEach>
	</table>
	<center>
		第${pb.pageCode}页/共${pb.totalPage}页 <a
			href="/Customer/servlet/CustomerServlet?page=1">首页</a>
		<c:if test="${pb.pageCode>1}">
			<a href="/Customer/servlet/CustomerServlet?page=${pb.pageCode-1}">上一页</a>
		</c:if>


		<c:choose>
			<c:when test="${pb.totalPage<=10 }">
				<c:set value="1" var="begin"></c:set>
				<c:set value="${pb.totalPage }" var="end"></c:set>
			</c:when>
			<c:otherwise>
				<c:set value="${pb.pageCode-5 }" var="begin"></c:set>
				<c:set value="${pb.pageCode+4 }" var="end"></c:set>
				<c:if test="${begin<1}">
					<c:set value="1" var="begin"></c:set>
					<c:set value="10" var="end"></c:set>
				</c:if>
				<c:if test="${end>pb.totalPage}">
					<c:set value="${pb.totalPage-9 }" var="begin"></c:set>
					<c:set value="${pb.totalPage }" var="end"></c:set>
				</c:if>
			</c:otherwise>
		</c:choose>

		<%--循环遍历标签 --%>
		<c:forEach var="i" begin="${begin}" end="${end}">
			<c:choose>
				<c:when test="${i eq pb.pageCode }">[${i}]
                </c:when>
				<c:otherwise>
					<a href="/Customer/servlet/CustomerServlet?page=${i}">[${i}]</a>
				</c:otherwise>
			</c:choose>

		</c:forEach>


		<c:if test="${pb.pageCode<pb.totalPage}">
			<a href="/Customer/servlet/CustomerServlet?page=${pb.pageCode+1}">下一页</a>
		</c:if>
		<a href="/Customer/servlet/CustomerServlet?page=${pb.totalPage}">尾页</a>
		<form action="/Customer/servlet/CustomerServlet?page=${param.page}">
			<input type="text" name="page"><input type="submit"
				value="跳转">
		</form>
	</center>
</body>
</html>
