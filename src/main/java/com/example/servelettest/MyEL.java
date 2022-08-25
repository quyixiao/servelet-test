package com.example.servelettest;//自定义函数
//该类及其函数,需要在扩展名为.tld的xml文件中注册
//tld：tag library definition（标签库定义）
//xml文件是需要约束的,即需要配置文件头部。这个头部约束可以从一下文件中进行复制
//在Tomcat安装目录下：webapps\examples\WEB-INF\jsp2
//文件为：jsp2-example-taglib.tld

//这个.tld的xml文件，需要定义在当前web项目的WEB-INF目录下，在此目录下创建以.tld结尾的xml文件
//将jsp2-example-taglib.tld中头部复制到创建的xml文件中

//再将函数注册，还是在jsp2-example-taglib.tld底部中复制
public class MyEL {
    private static MyEL instance;

    public static MyEL getInstance() {
        if (instance == null) {
            instance = new MyEL();
        }
        return instance;
    }

    //字符串小写变大写
    public static String LowerToUpper(String str) {
        return str.toUpperCase();
    }
}