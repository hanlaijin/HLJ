package com.hlj.common.z.test;

import com.google.common.collect.Sets;
import org.apache.commons.lang3.StringUtils;

import java.util.Set;

/**
 * Created by hanlaijin@xiaomi.com on 18-5-30.
 */
public class PackageMatch {

    public static Set<String> set = Sets.newHashSet();

    public static void main(String[] args) {
        set.add("com.wanmei.zhuxian");
        String s = "com.wanmei.zhuxian.aiqiyi";
        String ss = "com.wanmei.zhuxian.aiqiyi.pps";
        String sss = "1.2.11.2.pps";
        System.out.println(packageMatch(s));
        System.out.println(packageMatch(ss));
        System.out.println(packageMatch(sss));
    }


    public static boolean packageMatch(String s) {
        if (StringUtils.isBlank(s) || StringUtils.split(s, ".").length < 2) {
            return false;
        }
        while (s.contains(".")) {
            if (set.contains(s)) {
                return true;
            } else {
                s = StringUtils.substringBeforeLast(s, ".");
            }
        }
        return false;
    }

}
