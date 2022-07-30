<%--
  Created by IntelliJ IDEA.
  User: quyixiao
  Date: 2022/5/22
  Time: 11:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.sql.*,javax.sql.*,javax.naming.*" %>
<%
    Connection conn =null;
    try

    {
        //初始化查找命名空间
        Context ctx = new InitialContext();
        //InitialContext ctx = new InitialContext();亦可
        //找到DataSource,对名称进行定位java:comp/env是必须加的,后面跟你的DataSource名
        DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/myDB");
        //取出连接
        conn = ds.getConnection();
        System.out.println("connection pool connected !!");
    } catch (NamingException e) {
        System.out.println(e.getMessage());
    } catch (SQLException e) {
        e.printStackTrace();
    }finally
    {
       if(conn !=null){
           //注意不是关闭,是放回连接池.
           conn.close();
       }


    }
%>
