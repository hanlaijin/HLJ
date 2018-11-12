package com.hlj.offer.array;

/**
 * Created by hanlaijin@xiaomi.com on 18-10-18.
 */
public class Array {

    // 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置
    public int searchInsert(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }
        if (target <= nums[0]) {
            return 0;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target) {
                if (nums[i - 1] == target) {
                    return i - 1;
                } else {
                    return i;
                }
            }
        }
        return nums.length;
    }

    public static void main(String[] args) {
        Array a = new Array();
        int[] arr = new int[]{1, 2, 4, 3, 4, 5, 6, 7, 8, 9};
    }

    private void resort(int[] arr) {
        if (arr.length == 0 || arr.length == 1) {
            return;
        }
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            while (left <= right && arr[left] % 2 == 1) {
                left++;
            }
            while (left <= right && arr[right] % 2 == 0) {
                right--;
            }
            if (left < right) {
                swap(arr, left, right);
            }
        }
    }

    private void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
}
