package com.hlj.common.z;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * Created by hanlaijin@xiaomi.com on 18-10-24.
 */
public class Portal {
    public static void main(String[] args) throws Exception {
        BufferedReader brr = new BufferedReader(new InputStreamReader(new FileInputStream("/home/mi/temp/portal/pay")));
        String lines;
        int android = 0;
        int ios = 0;
        int other = 0;
        while ((lines = brr.readLine()) != null) {
            if (lines.toLowerCase().contains("android")) {
                android++;
            } else if(lines.toLowerCase().contains("iphone") || lines.toLowerCase().contains("ipad")) {
                ios++;
            } else {
                other++;
            }
        }
        System.out.println("a="+android);
        System.out.println("i="+ios);
        System.out.println("o="+other);
        System.out.println(android+ios+other);
    }
}
