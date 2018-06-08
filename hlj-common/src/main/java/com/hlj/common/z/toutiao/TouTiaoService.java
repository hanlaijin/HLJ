package com.hlj.common.z.toutiao;

/**
 * Created by hanlaijin@xiaomi.com on 18-5-23.
 */
//@Service
public class TouTiaoService {
//    private static Logger logger = LoggerFactory.getLogger(TouTiaoService.class);
//
//    public static ExecutorService threadPool = Executors.newFixedThreadPool(16);
//
//
//    @AccessTokenRequired
//    public JSONObject getNews(String guestMac) {
//        try {
//            JSONObject object = WifiRentTouTiaoUtil.getNews();
//            String toReport = cacheToReportInfo(object);
//            String key = XQUtils.md5(toReport);
//            XCacheHelper.setCache(key, toReport, (int) TimeUnit.MINUTES.toSeconds(10));
//            object.put("key", key);
//            return object;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    private String cacheToReportInfo(JSONObject object) {
//        return null;
//    }
//
//    @AccessTokenRequired
//    public void report(String guestMac, String type, String key) {
//        threadPool.execute(() -> {
//            String cacheValue = XCacheHelper.getCache(key);
//            JSONObject cacheJson = XQJsonUtils.optParseJson(cacheValue);
//            TouTiaoReportDto dto = buildReportDto(key);
//
//        });
//    }
//
//    public TouTiaoReportDto buildReportDto(String key) {
//        return null;
//    }

}
