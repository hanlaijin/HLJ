package com.hlj.common.z.toutiao;

import com.hlj.common.z.toutiao.dto.TouTiaoTokenResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;

/**
 * Created by hanlaijin@xiaomi.com on 18-5-23.
 */
public class WifiRentTouTiaoUtil {
//    private static Logger logger = LoggerFactory.getLogger(WifiRentTouTiaoUtil.class);
//
//    public static final String SECURE_KEY = "";
//    public static final String BUSINESS_KEY = "";
//    private static String TOUTIAO_HOST = "";
//    private static final String ACCESS_TOKEN = "/access_token/register/wap/v1/";
//    private static final String NEWS = "/data/stream/v3/";
//    private static final String REPORT = "/log/app_log_for_partner/v3/";
//
//    static {
//        try {
//            Properties props = PropertiesLoaderUtils.loadAllProperties("service.properties");
//            TOUTIAO_HOST = props.getProperty("wifi.rent.toutiao.host");
//            logger.info("wifi rent toutiao host: {}", TOUTIAO_HOST);
//        } catch (IOException e) {
//            logger.error("Hit an error.", e);
//        }
//    }
//
//    static public TouTiaoAPI getTouTiaoAPI() {
//        final Logger logger = LoggerFactory.getLogger(WifiRentTouTiaoUtil.class);
//        TouTiaoAPI api = new RestAdapter.Builder()
//                .setEndpoint("http://open.snssdk.com")
//                .setLogLevel(RestAdapter.LogLevel.FULL)
//                .setLog(new RestAdapter.Log() {
//                    @Override
//                    public void log(String message) {
//                        logger.info(message);
//                    }
//                })
//                .build().create(TouTiaoAPI.class);
//        return api;
//    }
//
//    public static TouTiaoTokenResponse getAccessToken(String uuid) throws Exception {
//        Map<String, String> params = getCommonParam();
//        params.put("uuid", uuid);
//        return getTouTiaoAPI().getToken(
//                params.get("secure_key"),
//                params.get("timestamp"),
//                params.get("nonce"),
//                params.get("signature"),
//                params.get("partner"),
//                params.get("uuid"));
////        XQHttpClient httpClient = new XQHttpClient();
////        String result = httpClient.post(TOUTIAO_HOST + ACCESS_TOKEN, XQUtils.buildParam(params));
////        return new Gson().fromJson(result, TouTiaoTokenResponse.class);
//    }
//
//    public static JSONObject getNews() throws Exception {
//        XQHttpClient httpClient = new XQHttpClient();
//        Map<String, String> params = getCommonParam();
//        String result = httpClient.post(TOUTIAO_HOST + NEWS, XQUtils.buildParam(params));
//        JSONObject object = new JSONObject(result);
//        return object;
//    }
//
//    public static JSONObject report() throws Exception {
//        XQHttpClient httpClient = new XQHttpClient();
//        Map<String, String> params = getCommonParam();
//        String result = httpClient.post(TOUTIAO_HOST + REPORT, XQUtils.buildParam(params));
//        JSONObject object = new JSONObject(result);
//        return object;
//    }
//
//    public static Map<String, String> getCommonParam() {
//        Map<String, String> params = new TreeMap<String, String>();
//        params.put("secure_key", SECURE_KEY);
//        params.put("timestamp", String.valueOf(System.currentTimeMillis()));
//        params.put("nonce", NonceFactory.generateNonce());
//        String signature = SecurityUtils.sha1(XQUtils.getStringParam(params));
//        params.put("signature", signature);
//        params.put("partner", BUSINESS_KEY);
//        return params;
//    }
}
