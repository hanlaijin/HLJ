package com.hlj.proxy;

public class HelloImpl implements Hello {
    @Override
    public void hello() {
        System.out.println("hello");
    }

    @Override
    public void world() {
        System.out.println("world");
    }
}