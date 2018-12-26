package com.learn.demo.gc;

public class TestLamba {

    public void say(String msg,Lamba p){
        p.say(msg);
    }
    public static void main(String[] args){
        TestLamba t = new TestLamba();
        t.say("it is a test for lamba",msg ->System.out.println(msg) );
        t.say("123",Integer::valueOf );
        ((Lamba)Integer::valueOf).say("122");
    }
}
