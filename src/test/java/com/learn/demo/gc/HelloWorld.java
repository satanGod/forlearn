package com.learn.demo.gc;

import org.springframework.beans.factory.InitializingBean;

import java.util.Date;


/**
 * invocation
 */
public class HelloWorld implements InitializingBean {
    private String msg = null;
    private Date date = null;

    @Override
    public void afterPropertiesSet() throws Exception {
        this.msg = "Hello World!";
        this.date = new Date();
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMsg() {
        return msg;
    }

    public Date getDate() {
        return date;
    }
}
