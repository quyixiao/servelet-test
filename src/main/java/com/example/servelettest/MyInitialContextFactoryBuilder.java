package com.example.servelettest;

import javax.naming.NamingException;
import javax.naming.spi.InitialContextFactory;
import javax.naming.spi.InitialContextFactoryBuilder;
import java.util.Hashtable;

public class MyInitialContextFactoryBuilder implements InitialContextFactoryBuilder {
    @Override
    public InitialContextFactory createInitialContextFactory(Hashtable<?, ?> environment) throws NamingException {
        System.out.println("----------------------------");
        return new MyInitialContextFactory();
    }
}
