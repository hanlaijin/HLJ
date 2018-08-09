package com.hlj.common.z.of;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hanlaijin@xiaomi.com on 18-8-1.
 * 给定一个 32 位有符号整数，将整数中的数字进行反转
 */
public class ReverseInteger {

    public static void main(String[] args) {
        ReverseInteger reverseInteger = new ReverseInteger();
        System.out.println(reverseInteger.reverse(-10200));
    }

    public int reverse(int x) {
        boolean flag = false;
        if (x < 0) {
            x = -x;
            flag = true;
        }
        List<Integer> list = new ArrayList<>();
        while (x > 0) {
            int current = x % 10;
            x = x / 10;
            list.add(current);
        }
        int result = 0;
        for (int i = 0; i < list.size(); i++) {
            if (result > Integer.MAX_VALUE/10) {
                return 0;
            }
            result = result * 10 + list.get(i);
        }
        return flag ? -result : result;
    }
}
