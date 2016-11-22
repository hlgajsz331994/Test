<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.hlg.test.Person"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!--<%
	Person p = new Person();
	p.test();
 	%>
	<%
		String str = "abc";
		out.print(str);
	%>
	 <br><br/>
	<%= str %>
-->
	<%
	int age = Integer.valueOf(request.getParameter("age"));
	if(age>=18){
	 %>d
	 成年人
	 <%}else{ %>
	 未成年
	 <%} %>
</body>
</html>