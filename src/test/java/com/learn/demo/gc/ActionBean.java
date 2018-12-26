package com.learn.demo.gc;

import java.util.Date;

public class ActionBean {
    private String msg = null;

    private Date date = null;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    //初始化
    public void init(){
        this.msg = "Hello World by init method!";
        this.date = new Date();
    }

    //销毁
    public void cleanup(){
        this.msg = null;
        this.date = null;
        System.out.println("您销毁了msg " + this.msg +"和date " + this.date);
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
