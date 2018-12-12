package com.hlj.offer.extend;

/**
 * Created by hanlaijin@xiaomi.com on 18-11-22.
 */
public class SubA extends A {
    public int b = 4;

    public void mb() {
        System.out.println("smb");
    }

    public void m() {
        System.out.println("smb");
    }

    public static void main(String[] args) {
        A a = new SubA();
        a.mb();
//        a.m(); 调用不了
        System.out.println(a.b);
    }
}
