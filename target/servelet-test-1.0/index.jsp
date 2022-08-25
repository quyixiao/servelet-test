<%--
  Created by IntelliJ IDEA.
  User: quyixiao
  Date: 2022/5/22
  Time: 11:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.sql.*,javax.sql.*,javax.naming.*" %>
<%@ page import="com.example.servelettest.Person" %>
<%-- 我在测试 --%>
<%
      Person person =new Person();
      person.setName("帅哥");
      person.setHeight(167);
      person.setAge(20);
      request.setAttribute("person", person);
%>
名字 ： ${person.name} <br>
人身高 ： ${person.height}