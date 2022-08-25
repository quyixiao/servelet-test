//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.servelettest;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Hashtable;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.naming.spi.NamingManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

//Hashtable<String,String> env = new Hashtable<>();
//env.put("java.naming.factory.initial", "com.example.servelettest.MyInitialContextFactoryBuilder");
         /*   Context initCtx = new InitialContext(env);
            Context envCtx = (Context)initCtx.lookup("java:comp/env");
            String paramValue = (String)envCtx.lookup("sql_type");

            //System.out.println("paramValue============================" + paramValue);
            System.out.println("开始请求============================");
            if(flag){
                // 因为 initctx_factory_builder是静态变量，设置一次即可
                System.out.println("设置 InitialContextFactoryBuilder =========");
                NamingManager.setInitialContextFactoryBuilder(new MyInitialContextFactoryBuilder());
                flag = false;
            }

            */

public class HelloServlet extends HttpServlet {
    public static boolean flag = true;

    public HelloServlet() {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Context ctx = null;
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            System.out.println("====================初始化InitialContext ===========");
            ctx = new InitialContext();
            System.out.println("--------------------------开始调用lookup查询------------ ");
            // DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/mysql");
            DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/mysql");
            System.out.println("打印出ds============================" + ds);
            con = ds.getConnection();
            System.out.println("==con=====" + con);
            stmt = con.createStatement();
            System.out.println("==stmt=====" + stmt);
            rs = stmt.executeQuery("select * from lt_company ");
            PrintWriter out = response.getWriter();
            response.setContentType("text/html");
            out.print("<html><body><h2>Employee Details</h2>");
            out.print("<table border=\"1\" cellspacing=10 cellpadding=5>");
            out.print("<th>ID</th>");
            out.print("<th>is_delete</th>");
            out.print("<th>cooperate_type</th>");
            out.print("<th>company_name</th>");
            out.print("<th>company_code</th>");

            while(rs.next()) {
                out.print("<tr>");
                out.print("<td>" + rs.getInt("id") + "</td>");
                out.print("<td>" + rs.getInt("is_delete") + "</td>");
                out.print("<td>" + rs.getInt("cooperate_type") + "</td>");
                out.print("<td>" + rs.getString("company_name") + "</td>");
                out.print("<td>" + rs.getString("company_code") + "</td>");
                out.print("</tr>");
            }

            out.print("</table></body><br/>");
            out.print("<h3>Database Details</h3>");
            out.print("Database Product: " + con.getMetaData().getDatabaseProductName() + "<br/>");
            out.print("Database Driver: " + con.getMetaData().getDriverName());
            out.print("</html>");
        } catch (NamingException var24) {
            var24.printStackTrace();
        } catch (SQLException var25) {
            var25.printStackTrace();
        } finally {
            try {
                rs.close();
                stmt.close();
                con.close();
                ctx.close();
            } catch (SQLException var22) {
                System.out.println("Exception in closing DB resources");
            } catch (NamingException var23) {
                System.out.println("Exception in closing Context");
            }

        }

    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doGet方法执行");
        this.doGet(req, resp);
    }

}



