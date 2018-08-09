package com.hlj.common.z.test;


/**
 * Created by hanlaijin@xiaomi.com on 18-7-13.
 */
public class AddBigNumber {
    public static void main(String[] args) {
        String s1 = "321";
        String s2 = "9876";
        System.out.println(add(s1, s2));
    }

    private static String add(String s1, String s2) {
        char[] a1 = s1.toCharArray();
        for (char c : a1) {
            System.out.println(c);
        }
        return null;
    }
}
