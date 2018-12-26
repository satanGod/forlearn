package com.learn.demo.gc;

import java.net.URL;

public class ReflectTest {

    public static void bootstrapClassLoaderTest(){
//        ClassLoader.getSystemClassLoader();
        System.out.println("******************获得根类加载器所加载的核心类库******************");

        //获取根类加载器所加载的全部URL数组
        URL[] urls = sun.misc.Launcher.getBootstrapClassPath().getURLs();

        //遍历、输出根类加载器加载的全部URL
        for (URL url : urls){
            System.out.println(url.toExternalForm());
        }
    }
    public static void getClassLoaders(){
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        ClassLoader extClassLoader = systemClassLoader.getParent();
        ClassLoader rootClassLoader = extClassLoader.getParent();
        System.out.println(rootClassLoader.toString());

    }
    public static void main(String[] args){
        bootstrapClassLoaderTest();
    }
}
