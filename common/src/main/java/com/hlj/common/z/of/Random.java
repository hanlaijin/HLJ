package com.hlj.common.z.of;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hanlaijin@xiaomi.com on 18-8-7.
 */
public class Random {
    public static void main(String[] args) {
        Random r = new Random();
        System.out.println(r.romanToInt("III"));
        System.out.println(r.romanToInt("IV"));
    }

    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int result = 0;
        int before = 0;
        while (before < s.length() - 1) {
            int after = before + 1;
            int x = map.get(s.charAt(before));
            int y = map.get(s.charAt(after));
            if (x < y) {
                result = result - x;
            } else {
                result = result + x;
            }
            before++;
        }
        if (before == s.length() - 1) {
            result += map.get(s.charAt(s.length() - 1));
        }
        return result;
    }
}
