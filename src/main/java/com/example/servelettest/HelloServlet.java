package com.example.servelettest;


import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Field;

// @WebServlet( asyncSupported = true)
public class HelloServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
        System.out.println("doGet方法执行");
        // 释放http连接，转为异步

      /*  String name = req.getClass().getName();
        System.out.println("servlet name is :" + name);
        try {
            Field field = req.getClass().getDeclaredField("request");
            field.setAccessible(true);
            Object ob = field.get(req);
            System.out.println("request name is :" + ob.getClass().getName());


            Field async = ob.getClass().getDeclaredField("asyncSupported");
            async.setAccessible(true);
            async.set(ob,true);
            Object asyncSupported = async.get(ob);
            System.out.println("========asyncSupported====="+asyncSupported);
        } catch (Exception e) {
            e.printStackTrace();
        }*/


        AsyncContext context = req.startAsync();

        // 4秒才超时了，超时也会中断当前请求直接返回
        context.setTimeout(4000L);

        int i = 0;
        int j = 0;
        int c = i / j;

        resp.getWriter().append("xxxxxx");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doGet方法执行");
        doGet(req, resp);
    }

    private class RequestFacade {
    }
}