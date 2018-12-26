package com.learn.demo.util;

import java.lang.reflect.Modifier;
import java.net.URL;
import java.net.URLClassLoader;
import java.sql.Connection;
import java.sql.Driver;
import java.util.Properties;

public class URLClassLoaderTest {

    private static Connection conn;

    public static Connection getConn(String url,String user,String password) throws Exception{
        if(conn == null){
            //创建一个URL数组
            URL[] urls = {new URL("file:mysql-connector-java-5.2.21-bin.jar")};
            //以默认的ClassLoader作为父ClassLoader，创建URLClassLoader
            URLClassLoader myClassLoader = new URLClassLoader(urls);
            //加载MYSQL的JDBC驱动，并创建默认实例
            Driver driver = (Driver) myClassLoader.loadClass("com.mysql.jdbc.Driver").newInstance();

            //创建一个JDBC连接属性的Properties对象
            Properties props = new Properties();
            props.setProperty("user",user);
            props.setProperty("password",password);
            //调用Driver的connect方法来取得数据库连接
            conn = driver.connect(url,props);
        }
        return conn;
    }

    public static void main(String[] args) throws Exception{
        System.out.println(getConn("jdbc:mysql://localhost:3306/mysql","root","123456"));
        Class clazz = String.class;

        int modifiers = clazz.getSuperclass().getModifiers();
        System.out.println(Modifier.toString(modifiers));
    }

}
