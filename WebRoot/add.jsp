<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'add.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <form action="/Customer/servlet/RegisterServlet">
    <table style=" margin:auto;">
         <caption>添加用户</caption>
         <tr>
            <td>姓名：</td>
            <td><input type="text" name="name"></td>
         </tr>
         <tr>
            <td>性别：</td>
            <td><input type="text" name="gender"></td>
         </tr>
         <tr>
            <td>生日：</td>
            <td><input type="text" name="date"></td>
         </tr>
         <tr>
            <td>电话：</td>
            <td><input type="text" name="phone"></td>
         </tr>
         <tr>
            <td>邮箱：</td>
            <td><input type="text" name="email"></td>
         </tr>
         <tr>
            <td>描述：</td>
            <td><input type="text" name="description"></td>
         </tr>
         <tr>
            <td><input type="submit" name="提交"></td>
            <td><input type="reset" name="重置"></td>
         </tr>
         
    </table>
    </form>
    </body>
</html>
