package com.hlj.offer.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by hanlaijin@xiaomi.com on 18-10-23.
 */
public class MyString {
    public static void main(String[] args) {
        String s = "1234567";
        char[] cs = s.toCharArray();
        for (char c : cs) {
            System.out.println(c - '0');
        }
        MyString my = new MyString();
//        System.out.println(my.addBinary("11","1"));
//        System.out.println(my.addBinary("1011","1010"));
    }

    // pattern = "abba", str = "dog cat cat dog" true
    // pattern = "abba", str = "cat cat cat cat" false
    public boolean wordPattern(String pattern, String str) {
        int l = pattern.length();
        String[] array = str.split(" ");
        if (l != array.length) {
            return false;
        }
        Map<Character, String> map = new HashMap<>();
        for (int i = 0; i < l; i++) {
            char c = pattern.charAt(i);
            if (map.containsKey(c)) {
                String value = map.get(c);
                if (!value.equals(array[i])) {
                    return false;
                }
            } else {
                map.put(c, array[i]);
            }
        }
        Set<Character> keys = new HashSet<>();
        Set<String> values = new HashSet<>();
        for (Map.Entry<Character, String> entry : map.entrySet()) {
            keys.add(entry.getKey());
            values.add(entry.getValue());
        }
        return keys.size() == values.size() ? true : false;
    }

    // 二进制相加，大数相加同理
    public String addBinary(String a, String b) {
        StringBuffer sba = new StringBuffer(a);
        StringBuffer sbb = new StringBuffer(b);
        int[] aa = getArray(sba.reverse().toString());
        int[] ab = getArray(sbb.reverse().toString());
        return sum(aa, ab);
    }

    private int[] getArray(String a) {
        int[] arr = new int[a.length()];
        for (int i = 0; i < a.length(); i++) {
            arr[i] = a.charAt(i) - '0';
        }
        return arr;
    }

    private String sum(int[] raa, int[] rab) {
        int index = 0;
        int count = 0;
        StringBuffer sb = new StringBuffer();
        while (index < raa.length && index < rab.length) {
            int sum = raa[index] + rab[index] + count;
            if (sum > 1) {
                sum = sum % 2;
                count = 1;
            } else {
                count = 0;
            }
            index++;
            sb.append(sum);
        }
        while (index < raa.length) {
            int sum = raa[index] + count;
            if (sum > 1) {
                sum = sum % 2;
                count = 1;
            } else {
                count = 0;
            }
            index++;
            sb.append(sum);
        }
        while (index < rab.length) {
            int sum = rab[index] + count;
            if (sum > 1) {
                sum = sum % 2;
                count = 1;
            } else {
                count = 0;
            }
            index++;
            sb.append(sum);
        }
        if (count > 0) {
            sb.append(count);
        }
        return sb.reverse().toString();
    }
}
