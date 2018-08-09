package com.hlj.common.z.of;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by hanlaijin@xiaomi.com on 18-8-6.
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters l = new LongestSubstringWithoutRepeatingCharacters();
        System.out.println(l.l(" "));
        System.out.println(l.l("aab"));
        System.out.println(l.l("dvdf"));
        System.out.println(l.l("abcabcbb"));
        System.out.println(l.l("pwwkew"));
        System.out.println(l.l("ckilbkd"));
    }

    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (list.contains(c)) {
                int now = list.size();
                result = now > result ? now : result;
                int index = list.indexOf(c);
                list = list.subList(index + 1, list.size());
            }
            list.add(c);
        }
        return result > list.size() ? result : list.size();
    }

    public int l(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

}
