package com.hlj.common.z.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * Created by hanlaijin@xiaomi.com on 18-7-12.
 */
public class ReflectTest {
    private String s;
    private int i;

    public ReflectTest() {
        System.out.println("无参构造");
    }

    public ReflectTest(String s, int i) {
        System.out.println("有参构造");
        this.s = s;
        this.i = i;
    }

    private void test () {
        System.out.println("test");
    }

    public static void main(String[] args) {
        try {
            Class clazz1 = Class.forName("com.hlj.common.z.reflect.ReflectTest");
            Constructor[] constructors = clazz1.getConstructors();
            for (Constructor c : constructors) {
                System.out.println(c);
            }
            Method[] methods = clazz1.getDeclaredMethods();
            for (Method m : methods) {
                System.out.println(m);
            }
            methods[1].invoke(clazz1.newInstance());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
