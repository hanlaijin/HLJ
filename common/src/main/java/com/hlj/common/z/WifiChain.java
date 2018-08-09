package com.hlj.common.z;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by hanlaijin@xiaomi.com on 18-7-27.
 */
public class WifiChain {
    public static void main(String[] args) throws Exception {
        fk3();
    }

    //周一活跃周二没活跃
    public static void fk1() throws Exception {
        Set<String> set = Sets.newHashSet();
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("/home/mi/temp/wifichain/0727/24")));
        String line;
        while ((line = br.readLine()) != null) {
            set.add(line);
        }
        PrintWriter pw = new PrintWriter(new FileOutputStream("/home/mi/temp/wifichain/0727/23"));
        BufferedReader brr = new BufferedReader(new InputStreamReader(new FileInputStream("/home/mi/temp/wifichain/0727/2324登录用户")));
        String lines;
        while ((lines = brr.readLine()) != null) {
            if (!set.contains(lines)) {
                pw.println(lines);
            }
        }
        pw.flush();
    }

    //连续四天没活跃
    public static void fk2() throws Exception {
        List<Double> grows = Lists.newArrayList();
        List<Double> milis = Lists.newArrayList();
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("/home/mi/temp/wifichain/0727/z连续四天没活跃用户")));
        String line;
        while ((line = br.readLine()) != null) {
            String[] arr = line.split("\\t");
            BigDecimal grow = new BigDecimal(arr[1]).multiply(new BigDecimal(arr[3]));
            BigDecimal mili = new BigDecimal(arr[2]).divide(new BigDecimal(100000000));
            grows.add(grow.setScale(0, BigDecimal.ROUND_HALF_UP).doubleValue());
            milis.add(mili.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
        }
        Collections.sort(grows);
        Collections.sort(milis);
        int all = 473063;
        for (int i = 1; i < 10; i++) {
            int index = all * i / 10;
            System.out.print(grows.get(index) + " ");
        }
        System.out.println();
        for (int i = 1; i < 10; i++) {
            int index = all * i / 10;
            System.out.print(milis.get(index) + " ");
        }
    }

    //周一活跃周二没活跃的米粒分布
    public static void fk3() throws Exception {
        Set<String> set = Sets.newHashSet();
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("/home/mi/temp/wifichain/0727/z周一活跃周二没活跃")));
        String line;
        while ((line = br.readLine()) != null) {
            set.add(line);
        }
        Map<String, Double> map = Maps.newHashMap();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("/home/mi/temp/wifichain/0727/24record")));
        String l;
        while ((l = bufferedReader.readLine()) != null) {
            String[] arr = l.split("\\t");
            if (map.containsKey(arr[0])) {
                double temp = new BigDecimal(map.get(arr[0])).add(new BigDecimal(arr[1])).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
                map.put(arr[0], temp);
            } else {
                map.put(arr[0], new BigDecimal(arr[1]).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
            }
        }
        Collection<Double> collection = map.values();
        List<Double> list = Lists.newArrayList();
        list.addAll(collection);
        Collections.sort(list);
        int all = 37331;
        for (int i = 1; i < 10; i++) {
            int index = all * i / 10;
            System.out.print(new BigDecimal(list.get(index)).divide(new BigDecimal(100000000)).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue() + "\t");
        }
    }
}
