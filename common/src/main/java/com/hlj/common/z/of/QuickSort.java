package com.hlj.common.z.of;

/**
 * Created by hanlaijin@xiaomi.com on 18-8-2.
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] array = new int[]{1, 5, 2, 6, 3, 9, 4};
        new QuickSort().quickSort(array, 0, array.length - 1);
        print(array);
    }

    public void quickSort(int[] array, int left, int right) {
        if (left > right) {
            return;
        }
        int p = getP(array, left, right);
        quickSort(array, left, p - 1);
        quickSort(array, p + 1, right);
    }

    private int getP(int[] array, int left, int right) {
        int temp = array[left];
        while (left < right) {
            while (left < right && array[right] >= temp) {
                right--;
            }
            array[left] = array[right];

            while (left < right && array[left] <= temp) {
                left++;
            }
            array[right] = array[left];
        }
        array[left] = temp;
        return left;
    }

    public static void print(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
