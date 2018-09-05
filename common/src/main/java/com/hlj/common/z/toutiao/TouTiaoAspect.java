//package com.hlj.common.z.toutiao;
//
//import com.xiaomi.miwifi.wifirent.RedisUtil;
//import com.xiaomi.xiaoqiang.common.guestwifi.WifiRentConstant;
//import com.xiaomi.xiaoqiang.common.guestwifi.dto.TouTiaoTokenResponse;
//import com.xiaomi.xiaoqiang.common.utils.XQUtils;
//import com.xiaomi.xiaoqiang.common.utils.guestwifi.WifiRentTouTiaoUtil;
//import org.apache.commons.lang3.StringUtils;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Pointcut;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Component;
//
///**
// * Created by hanlaijin@xiaomi.com on 18-5-24.
// */
//@Aspect
//@Component
public class TouTiaoAspect {
//    private static Logger logger = LoggerFactory.getLogger(TouTiaoAspect.class);
//
//    @Pointcut("execution(@com.xiaomi.xiaoqiang.common.guestwifi.annotation.AccessTokenRequired * *(..))")
//    public void init() {
//    }
//
//    @Around("init()")
//    public Object toutiao(ProceedingJoinPoint joinPoint) throws Throwable {
//        Object[] args = joinPoint.getArgs();
//        String mac = XQUtils.encodeMac((String) args[0]);
//        args[0] = mac;
//        setnxAccessToken(mac);
//        return joinPoint.proceed(args);
//    }
//
//    private void setnxAccessToken(String mac) throws Exception {
//        try {
//            String key = XQUtils.buildRedisKey(WifiRentConstant.TOUTIAO_KEY, mac);
//            String value = RedisUtil.getJedisCluster().get(key);
//            if (StringUtils.isBlank(value)) {
//                TouTiaoTokenResponse result = WifiRentTouTiaoUtil.getAccessToken(mac);
//                if (result.getTokenSuccess()) {
//                    RedisUtil.getJedisCluster().setex(key, WifiRentConstant.TOUTIAO_EXPIRE_TIME, "");
//                }
//            }
//        } catch (Exception e) {
//            logger.error("toutiao access token error .", e);
//        }
//    }

}
