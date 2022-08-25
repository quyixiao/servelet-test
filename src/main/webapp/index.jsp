<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://tomcat.apache.org/jsp2-example-taglib" prefix="MyEL" %><!-- tld中的uri和short-name -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <title>Insert title here</title>
</head>
<body>
<!-- 这个方法名是在tld注册时的name -->
${MyEL:MyLowerToUpper("sasas") }<br>


<!-- EL函数只能处理四大域中的属性值及String常量 -->
<%
      String name="xlj";
      pageContext.setAttribute("name", name);
%>



${MyEL:MyLowerToUpper(name) }<br>

</body>
</html>


