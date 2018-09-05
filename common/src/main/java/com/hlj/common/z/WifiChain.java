package com.hlj.common.z;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by hanlaijin@xiaomi.com on 18-7-27.
 */
public class WifiChain {

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

    // 多线程访问kv
//    public String s() {
//        try {
//            List<String> list = Lists.newArrayList();
//            CopyOnWriteArrayList<Double> ulist = new CopyOnWriteArrayList();
//            ExecutorService threadPoolExecutor = Executors.newFixedThreadPool(15);
//            AtomicInteger now = new AtomicInteger(0);
//            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("/home/work/did")));
//            String line = br.readLine();
//            while ((line=br.readLine())!=null){
//                list.add(line);
//            }
//            CountDownLatch countDownLatch = new CountDownLatch(list.size());
//            logger.info("ss all = {}", list.size());
//            for (int i=0;i<list.size();i++) {
//                int finalI = i;
//                threadPoolExecutor.execute(()->{
//                    String band = kvStoreHelper.getDeviceValue(list.get(finalI), "qos_info");
//                    if (band != null && band.startsWith("{") && band.endsWith("}")) {
//                        JSONObject bandJson = null;
//                        try {
//                            bandJson = new JSONObject(band);
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                        }
//                        JSONObject tem = bandJson.optJSONObject("band");
//                        if (tem!=null) {
//                            double u = tem.optDouble("upload", 0);
//                            if (u > 0.0 && u < 500.0) {
//                                ulist.add(u);
//                            }
//                        }
//                    }
//                    int fk = now.incrementAndGet();
//                    if (fk % 20000 == 0) {
//                        logger.info("ss now = {}", fk);
//                    }
//                    countDownLatch.countDown();
//                });
//            }
//            countDownLatch.await();
//            logger.info("ss u = {}", ulist.size());
//            cat(ulist);
//        } catch (Exception e) {
//            logger.info("redis error {}", e);
//        }
//        return ResponseUtils.successResponse();
//    }
//
//    public void cat(List<Double> list) throws Exception {
//        int size = list.size();
//        Collections.sort(list);
//        StringBuffer sb = new StringBuffer();
//        for (int i=1;i<20;i++) {
//            sb.append(list.get(size*5*i/100)).append(",");
//        }
//        logger.info("ss r={}",sb.toString());
//    }


//    #!/bin/bash
//            today=$(date -d today '+%Y-%m-%d')
//    yesterday=$(date -d yesterday '+%Y-%m-%d')
//    mysql="xxxxx "
//    $mysql "select growth_factor,acceleration,mili from account" > /home/work/hlj/wifichain/account/all
//    $mysql "select user_id from finished_task where type='LOGIN' and create_time>=\"$yesterday\" and create_time<\"$today\""  > /home/work/hlj/wifichain/account/user
//    cat /home/work/hlj/wifichain/account/user | while read line
//do
//    query="select growth_factor,acceleration,mili from account where user_id=$line"
//    $mysql "$query" > /home/work/hlj/wifichain/account/t$line
//            done
//    cat /home/work/hlj/wifichain/account/t* > ./res
//    rm -rf /home/work/hlj/wifichain/account/t*
//    cat res | grep -v 'growth_factor' > /home/work/hlj/wifichain/account/yesterday
//    rm -rf res
//    private static final Logger logger = LoggerFactory.getLogger(WifiChainStatTask.class);
//    private static List<Long> mili = Lists.newArrayList();
//    private static List<Long> growth = Lists.newArrayList();
//    private static List<Long> accelerat = Lists.newArrayList();
//    private static Map<Long, List<Long>> miliMap = new TreeMap<Long, List<Long>>();
//    private static Map<Long, List<Long>> growthMap = new TreeMap<Long, List<Long>>();
//    private static Map<Long, List<Long>> acceleratMap = new TreeMap<Long, List<Long>>();
//
//    static {
//        mili.add(50000000L);
//        mili.add(100000000L);
//        mili.add(200000000L);
//        mili.add(500000000L);
//        mili.add(1000000000L);
//        mili.add(2000000000L);
//        mili.add(3000000000L);
//        mili.add(5000000000L);
//        mili.add(10000000000L);
//        mili.add(15000000000L);
//        mili.add(Long.MAX_VALUE);
//        for (Long l : mili) {
//            List<Long> list = Lists.newArrayList();
//            miliMap.put(l, list);
//        }
//
//        growth.add(500L);
//        growth.add(600L);
//        growth.add(700L);
//        growth.add(800L);
//        growth.add(900L);
//        growth.add(1000L);
//        growth.add(1500L);
//        growth.add(2000L);
//        growth.add(3000L);
//        growth.add(4000L);
//        growth.add(5000L);
//        growth.add(7000L);
//        growth.add(Long.MAX_VALUE);
//        for (Long l : growth) {
//            List<Long> list = Lists.newArrayList();
//            growthMap.put(l, list);
//        }
//
//        accelerat.add(10L);
//        accelerat.add(20L);
//        accelerat.add(25L);
//        accelerat.add(Long.MAX_VALUE);
//        for (Long l : accelerat) {
//            List<Long> list = Lists.newArrayList();
//            acceleratMap.put(l, list);
//        }
//    }
//
//    public static void main(String[] args) {
//        try {
//            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("/home/work/hlj/wifichain/account/" + args[0])));
//            String line = br.readLine();
//            int now = 0;
//            while ((line = br.readLine()) != null) {
//                fillDataToMap(line);
//                if (now++ % 10000 == 0) {
//                    logger.info("now = {}", now);
//                }
//            }
//            printMap();
//        } catch (Exception e) {
//            logger.error(" ??? ", e);
//        } finally {
//            System.exit(0);
//        }
//    }
//
//    private static void fillDataToMap(String line) throws Exception {
//        String[] s = StringUtils.split(line, "\t");
//        Long g = Long.parseLong(s[0]);
//        Long a = (long)(Double.parseDouble(s[1]) * 10);
//        Long m = Long.parseLong(s[2]);
//        Long mkey = getKey(mili, m);
//        Long gkey = getKey(growth, g * a);
//        Long akey = getKey(accelerat, a);
//        miliMap.get(mkey).add(m);
//        growthMap.get(gkey).add(g);
//        acceleratMap.get(akey).add(a);
//    }
//
//    private static Long getKey(List<Long> list, Long num) throws Exception {
//        for (int i = 0; i < list.size(); i++) {
//            Long now = list.get(i);
//            if (now >= num) {
//                return now;
//            }
//        }
//        throw new Exception("ERROR");
//    }
//
//    private static void printMap() throws Exception {
//        PrintWriter pw = new PrintWriter(new FileOutputStream(new File("/home/work/hlj/wifichain/account/result")));
//        logger.info("[mili]");
//        for (Map.Entry<Long, List<Long>> entry : miliMap.entrySet()) {
//            pw.print(entry.getValue().size() + "\t");
//            logger.info("key = {}, value = {}", entry.getKey(), entry.getValue().size());
//        }
//        pw.println();
//        logger.info("[growth]");
//        for (Map.Entry<Long, List<Long>> entry : growthMap.entrySet()) {
//            pw.print(entry.getValue().size() + "\t");
//            logger.info("key = {}, value = {}", entry.getKey(), entry.getValue().size());
//        }
//        pw.println();
//        logger.info("[accelerat]");
//        for (Map.Entry<Long, List<Long>> entry : acceleratMap.entrySet()) {
//            pw.print(entry.getValue().size() + "\t");
//            logger.info("key = {}, value = {}", entry.getKey(), entry.getValue().size());
//        }
//        pw.flush();
//    }

    private static void getHostAccountFromFile() throws Exception {
        Gson gson = new Gson();
        File f = new File("/home/mi/final");
        BufferedReader br = new BufferedReader(new FileReader(f));
        String line;
        int wechat = 0;
        int balance = 0;
        int freeze = 0;
        int active = 0;
        while ((line = br.readLine()) != null) {
            Account account = gson.fromJson(line, Account.class);
            wechat += StringUtils.isBlank(account.balance) ? 0 : Integer.parseInt(account.balance);
            balance += StringUtils.isBlank(account.official_account_balance) ? 0 : Integer.parseInt(account.official_account_balance);
            freeze += StringUtils.isBlank(account.official_account_freeze_money) ? 0 : Integer.parseInt(account.official_account_freeze_money);
            active += StringUtils.isBlank(account.active_balance) ? 0 : Integer.parseInt(account.active_balance);
        }
        System.out.println(wechat);
        System.out.println(balance);
        System.out.println(freeze);
        System.out.println(active);
        br.close();
    }

    public static void main(String[] args) throws Exception {
        getHostAccountFromFile();
    }
}

class Account {
    public List<WithdrawAccount> withdraw_accounts;
    public String balance;
    public String withdrawn;
    public String last_withdraw_time;
    public String status;
    public String official_account_balance;
    public String official_account_freeze_money;
    public String active_balance;
    public String active_withdrawn;

    @Override
    public String toString() {
        return "Account{" +
                "withdraw_accounts=" + withdraw_accounts +
                ", balance='" + balance + '\'' +
                ", withdrawn='" + withdrawn + '\'' +
                ", last_withdraw_time='" + last_withdraw_time + '\'' +
                ", status='" + status + '\'' +
                ", official_account_balance='" + official_account_balance + '\'' +
                ", official_account_freeze_money='" + official_account_freeze_money + '\'' +
                ", active_balance='" + active_balance + '\'' +
                ", active_withdrawn='" + active_withdrawn + '\'' +
                '}';
    }
}

class WithdrawAccount {
    public String accountType;
    public String accountId;
    public String realName;
    public String idCard;
    public String nickname;
    public String headUrl;
    public String b64Nickname;
    public String miPayIdCard;
    public String miPayMobile;
}
