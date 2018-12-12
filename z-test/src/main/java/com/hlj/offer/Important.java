package com.hlj.offer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by hanlaijin@xiaomi.com on 18-10-23.
 */
public class Important {

    public static void main(String[] args) {
        Important important = new Important();
        String[] arr = new String[]{"32", "1", "44"};
        int[] a = new int[]{1, 2, 3};
        important.cmn(arr, 2);
        important.permuteCore(a, 0);
    }

    public void permuteCore(int[] nums, int start) {
        if (start == nums.length) {
            List<Integer> tl = new ArrayList<>();
            for (int i : nums) {
                tl.add(i);
            }
            System.out.println(tl);
        } else {
            for (int i = start; i < nums.length; i++) {
                swap(nums, start, i);
                permuteCore(nums, start + 1);
                swap(nums, start, i);
            }
        }
    }

    private void swap(int[] nums, int start, int end) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }

    public void cmn(String[] arr, int n) {
        if (arr == null || n < 0) {
            return;
        }
        for (int i = 0; i < arr.length - n + 1; i++) {
            cmnCore(1, arr[i], i, arr, n);
        }
    }

    private void cmnCore(int count, String s, int index, String[] arr, int n) {
        if (count == n) {
            System.out.println(s);
        }
        for (int i = index + 1; i < arr.length; i++) {
            cmnCore(count + 1, s + arr[i], i, arr, n);
        }
    }

}
