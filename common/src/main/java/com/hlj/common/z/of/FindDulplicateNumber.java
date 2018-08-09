package com.hlj.common.z.of;

/**
 * Created by hanlaijin@xiaomi.com on 18-8-6.
 */
public class FindDulplicateNumber {

    public static void main(String[] args) {
        int[] array = new int[]{7,0,4,1,2,4,3,6,5};
        System.out.println(new FindDulplicateNumber().find(array));
    }

    public int find(int[] array) {
        for (int i=0;i<array.length;i++) {
            int toChange = array[array[i]];
            if (array[i] == toChange) {
                return toChange;
            }
            array[array[i]] = array[i];
            array[i] = toChange;
        }
        throw new IllegalArgumentException("error");
    }
}
