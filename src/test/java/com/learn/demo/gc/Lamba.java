package com.learn.demo.gc;

@FunctionalInterface
public interface Lamba {

    void say(String msg);

    default String does(String msg) {
        return msg;
    }
}
