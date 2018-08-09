package com.hlj.common.z.of;

/**
 * Created by hanlaijin@xiaomi.com on 18-8-7.
 */
public class G {

    public static void main(String[] args) {
        G g = new G();
        int[] a = new int[]{5, 4, 1, 2};
        int[] b = new int[]{5, 2, 1, 2, 1, 5};
        System.out.println(g.trap(b));
    }

    public int trap(int[] height) {
        int result = 0;
        int index = 0;
        for (int i = 0; i < height.length; i++) {
            System.out.print(index + " ");
            if (index - 1 >= 0 && index + 1 <= height.length - 1) {
                if (height[index] < height[index + 1] && height[index] < height[index - 1]) {
                    int left = index - 1;
                    int right = index + 1;
                    while (left - 1 >= 0 && height[left] <= height[left - 1]) {
                        left--;
                    }
                    while (right + 1 <= height.length - 1 && height[right] <= height[right + 1]) {
                        right++;
                    }
                    int low = height[left] < height[right] ? height[left] : height[right];
                    for (int j = left + 1; j < right; j++) {
                        if (low > height[j]) {
                            result = result + low - height[j];
                        }
                    }
                    index = right;
                } else {
                    index++;
                }
            } else {
                index++;
            }
            System.out.println(result);
        }
        return result;
    }
}
