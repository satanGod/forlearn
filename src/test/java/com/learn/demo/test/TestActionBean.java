package com.learn.demo.test;

import com.learn.demo.gc.ActionBean;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;

import java.io.FileInputStream;
import java.io.InputStream;

public class TestActionBean {
    public static void main(String[] args){
        /*ActionBean ab = new ActionBean();
        ab.setMsg("Hello World!");
        System.out.println(ab.getMsg());*/
        testXml();
    }

    public static void testXml(){

        ApplicationContext ac = new FileSystemXmlApplicationContext("./src/main/resources/config.xml");
        ActionBean ab = (ActionBean)ac.getBean("ActionBean");
        System.out.println(ab.getMsg());
    }

    public static void useBean1(){
        ActionBean ab = new ActionBean();
        BeanWrapper bw = new BeanWrapperImpl(ab);
        bw.setPropertyValue("msg","Hello World by bean wrapper!");
        System.out.println(bw.getPropertyValue("msg"));
    }

    public static void useBean2() throws Exception {
        InputStream is = new FileInputStream("./src/main/resources/config.xml");
        Resource resource = new InputStreamResource(is);//?
        XmlBeanFactory factory = new XmlBeanFactory(resource);//?
        ActionBean ab = (ActionBean)factory.getBean("ActionBean");
        System.out.println(ab.getMsg());
    }

}
