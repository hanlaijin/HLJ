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
//        int a[] = new int[]{1, 1, 2};
//        System.out.println(important.permuteUnique(a));
    }

    public Set<List<Integer>> permuteUnique(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        permuteCore(nums, 0, set);
        return set;
    }

    public void permuteCore(int[] nums, int start, Set<List<Integer>> set) {
        if (start == nums.length) {
            List<Integer> tl = new ArrayList<>();
            for (int i : nums) {
                tl.add(i);
            }
            System.out.println(tl);
            set.add(tl);
        } else {
            for (int i = start; i < nums.length; i++) {
                swap(nums, start, i);
                permuteCore(nums, start + 1, set);
                swap(nums, start, i);
            }
        }
    }

    private void swap(int[] nums, int start, int end) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }

}
