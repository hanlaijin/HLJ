package com.hlj.offer.leetcode;

/**
 * Created by hanlaijin@xiaomi.com on 18-11-12.
 */
public class L796 {

    /**
     * 给定两个字符串, A 和 B
     * A 的旋转操作就是将 A 最左边的字符移动到最右边
     * 例如, 若 A = 'abcde'，在移动一次之后结果就是'bcdea'
     * 如果在若干次旋转操作之后，A 能变成B，那么返回True
     */
    public boolean rotateString(String A, String B) {
        if (A.length() != B.length()) {
            return false;
        }
        if (A.equals("") && B.equals("")) {
            return true;
        }
        char as = A.charAt(0);
        for (int i = 0; i < B.length(); i++) {
            if (B.charAt(i) == as) {
                StringBuffer temp = new StringBuffer();
                for (int j = i; j < i + B.length(); j++) {
                    temp.append(B.charAt(j % B.length()));
                }
                if (A.equals(temp.toString())) {
                    return true;
                }
            }
        }
        return false;
    }
}
