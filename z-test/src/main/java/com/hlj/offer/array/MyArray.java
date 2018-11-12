package com.hlj.offer.array;

import java.util.Arrays;

/**
 * Created by hanlaijin@xiaomi.com on 18-11-9.
 */
public class MyArray {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 1, 3, 9, 4, 2, 5, 8, 7};
        MyArray array = new MyArray();
        array.quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public int partition(int[] array, int lo, int hi) {
        //固定的切分方式
        int key = array[lo];
        while (lo < hi) {
            while (array[hi] >= key && hi > lo) {//从后半部分向前扫描
                hi--;
            }
            array[lo] = array[hi];
            while (array[lo] <= key && hi > lo) {//从前半部分向后扫描
                lo++;
            }
            array[hi] = array[lo];
        }
        array[hi] = key;
        return hi;
    }

    public void quickSort(int[] array, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int index = partition(array, lo, hi);
        quickSort(array, lo, index - 1);
        quickSort(array, index + 1, hi);
    }
}
