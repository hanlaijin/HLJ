package com.hlj.common.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by hanlaijin@xiaomi.com on 17-9-30.
 */
@Slf4j
public class IPUtail {

    public static String getIpAddress(HttpServletRequest request) {
        final String[] keyList = new String[]{
                "X-Real-IP", "X-Forwarded-For", "Proxy-Client-IP", "WL-Proxy-Client-IP"
        };
        for (int i = 0; i < keyList.length; ++i) {
            String ips = request.getHeader(keyList[i]);
            if (StringUtils.isBlank(ips)) {
                continue;
            }
            String[] ipList = StringUtils.split(ips, ",");
            for (int j = 0; j < ipList.length; ++j) {
                String ip = ipList[j].trim();
                if (!"unknown".equalsIgnoreCase(ip)) {
                    return ip;
                }
            }
        }
        log.info("ip = {}", request.getRemoteAddr());
        return request.getRemoteAddr();
    }
}
