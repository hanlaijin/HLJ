//package com.hlj.common.z.toutiao;
//
//import com.xiaomi.xiaoqiang.api.biz.yyb.YybConfigBiz;
//import com.xiaomi.xiaoqiang.api.service.TouTiaoService;
//import com.xiaomi.xiaoqiang.api.service.WifiRentService;
//import com.xiaomi.xiaoqiang.common.guestwifi.WifiRentConstant;
//import com.xiaomi.xiaoqiang.common.perf.annotation.PerfLogable;
//import com.xiaomi.xiaoqiang.common.utils.XQConstants;
//import com.xiaomi.xiaoqiang.common.utils.basic.ResponseUtils;
//import org.apache.commons.lang3.StringUtils;
//import org.json.JSONObject;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import javax.servlet.http.HttpServletRequest;
//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.InputStreamReader;
//
///**
// * Created by hanlaijin@xiaomi.com on 18-5-23.
// */
//@Controller
//@RequestMapping("wifirent")
public class TouTiaoController {
//
//    private static Logger logger = LoggerFactory.getLogger(TouTiaoController.class);
//
//    @Autowired
//    private TouTiaoService touTiaoService;
//    @Autowired
//    private WifiRentService wifiRentService;
//
//    @Autowired
//    private YybConfigBiz yybConfigBiz;
//
//    @RequestMapping(value = "/toutiao/test", method = {RequestMethod.GET}, produces = "text/plain; charset=UTF-8")
//    @ResponseBody
//    @PerfLogable
//    public String test() {
//        try {
//            int count = 0;
//            int success = 0;
//            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File("/home/work/soft/nginx/mac"))));
//            String line = br.readLine();
//            while ((line = br.readLine()) != null) {
//                count++;
//                if (yybConfigBiz.isProtectedMac(line)) {
//                    success++;
//                }
//                if (count%100000==0) {
//                    logger.info("toutiao-------------------- now = {}", count);
//                }
//            }
//            logger.info("toutiao-------------------- count={}, success={}, ratio={}", count, success, success*1.0/count);
//            return ResponseUtils.successResponse();
//        } catch (Exception e) {
//            logger.error("getHostAccount error : {}", e);
//            return ResponseUtils.errorResponse(XQConstants.XQ_EXCEPTION.INTERNAL_ERROR);
//        }
//    }
//
//
//    @RequestMapping(value = "/toutiao/get_news", method = {RequestMethod.GET}, produces = "text/plain; charset=UTF-8")
//    @ResponseBody
//    @PerfLogable
//    public String getNews(@RequestParam("router_id") String routerId, @RequestParam("client_info") String clientInfo) {
//        try {
//            String guestMac = wifiRentService.extractGuestMac(routerId, clientInfo);
//            if (StringUtils.isBlank(guestMac)) {
//                return ResponseUtils.errorResponse(XQConstants.XQ_EXCEPTION.INVALID_PARAMETER);
//            }
//            JSONObject news = touTiaoService.getNews(guestMac);
//            touTiaoService.report(guestMac, WifiRentConstant.TOUTIAO_SHOW, "key");
//            return ResponseUtils.successResponse(news);
//        } catch (Exception e) {
//            logger.error("getHostAccount error : {}", e);
//            return ResponseUtils.errorResponse(XQConstants.XQ_EXCEPTION.INTERNAL_ERROR);
//        }
//    }
//
//    @RequestMapping(value = "/toutiao/report_click", method = {RequestMethod.POST}, produces = "text/plain; charset=UTF-8")
//    @ResponseBody
//    @PerfLogable
//    public String reportClick(@RequestParam("router_id") String routerId, @RequestParam("client_info") String clientInfo, HttpServletRequest httpRequest) {
//        try {
//            String guestMac = wifiRentService.extractGuestMac(routerId, clientInfo);
//            if (StringUtils.isBlank(guestMac)) {
//                return ResponseUtils.errorResponse(XQConstants.XQ_EXCEPTION.INVALID_PARAMETER);
//            }
//            touTiaoService.report(guestMac, WifiRentConstant.TOUTIAO_CLICK, "key");
//            return ResponseUtils.successResponse();
//        } catch (Exception e) {
//            logger.error("getHostAccount error : {}", e);
//            return ResponseUtils.errorResponse(XQConstants.XQ_EXCEPTION.INTERNAL_ERROR);
//        }
//    }
//
}
