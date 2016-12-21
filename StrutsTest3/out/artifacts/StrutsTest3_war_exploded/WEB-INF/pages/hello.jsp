<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/11/28
  Time: 14:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
        <%="新的风暴"%>
        <br>
        Name(Struts途径获取):<s:property value ="name"/>
        <br>
        Name(请求域中获取):${requestScope.name}
        <s:debug/>
        <hr>
        <s:url var="urlTest1" value="LoginTest1.jsp">
            <s:param name="id" value="24"/>
        </s:url>
        ${urlTest1}
        <br>
        <s:url var="urlTest2" value="LoginTest1.jsp">
            <s:param name="id1" value="id"/>
        </s:url>
        ${urlTest2}
</body>
</html>
