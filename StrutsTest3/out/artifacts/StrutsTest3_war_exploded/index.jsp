<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/11/28
  Time: 14:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
  <head>
    <title></title>
      </head>
      <body>
      文本框：<input type="text" value="12345">
      <br>
      <a href="show.action?name=123">123</a>
  <br>
  <a href="test.action">test1</a>

  <a href="LoginTest1.action">登录练习</a>
  <s:debug> </s:debug>
  <a href="error.action">Error</a>
  <br>

  Message:${exception.message}
  <br>
  值栈：<s:property value="[0]"/>
      <br>
      Request:<%=request%>
  </body>
</html>
