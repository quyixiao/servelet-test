package com.example.servelettest;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.spi.InitialContextFactory;
import java.lang.reflect.Method;
import java.util.Hashtable;

public class MyInitialContextFactory implements InitialContextFactory {


    @Override
    public Context getInitialContext(Hashtable<?, ?> environment) throws NamingException {
        try {
            System.out.println("开始初始值x===================================");
            Class clzz = Class.forName("com.luban.MyNameContext");
            Object ob = clzz.newInstance();
            Method method = ob.getClass().getDeclaredMethod("getNamingContext");
            method.setAccessible(true);
            return (Context) method.invoke(ob);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
