package com.hlj.common.z.of;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hanlaijin@xiaomi.com on 18-7-30.
 */
public class Cn3 {

    private static int[] arr = new int[]{1, -1, -2, -3, 0, 2, 1};

    public static void main(String[] args) {
        combine(0, 3, new ArrayList<>());
    }

    public static void combine(int index, int k, List tmpArr) {
        if (k == 1) {
            for (int i = index; i < arr.length; i++) {
                tmpArr.add(arr[i]);
                System.out.println(tmpArr.toString() + ",");
                tmpArr.remove((Object) arr[i]);
            }
        } else if (k > 1) {
            for (int i = index; i <= arr.length - k; i++) {
                tmpArr.add(arr[i]); //tmpArr都是临时性存储一下
                combine(i + 1, k - 1, tmpArr); //索引右移，内部循环，自然排除已经选择的元素
                tmpArr.remove((Object) arr[i]); //tmpArr因为是临时存储的，上一个组合找出后就该释放空间，存储下一个元素继续拼接组合了
            }
        } else {
            return;
        }
    }
}
