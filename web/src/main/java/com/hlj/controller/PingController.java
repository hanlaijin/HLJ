package com.hlj.controller;

import com.hlj.common.annotation.NeedAOP;
import com.hlj.common.dtos.PingRequest;
import com.hlj.common.dtos.response.Response;
import com.hlj.common.utils.ResponseUtil;
import com.hlj.service.PingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;


@Slf4j
@RestController
public class PingController {

    @Value("${com.hlj.properties}")
    private String name;

    @Resource
    private PingService pingService;

    static {
        log.info("********************");
    }

    @PostConstruct
    public void init() {
        log.info("-------------------********************");
    }

    @NeedAOP
    @GetMapping(value = "/ping", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Response ping() throws Exception {
        return ResponseUtil.success(name + " " + pingService.rpc());
    }

    //    @NeedAOP
    @GetMapping(value = "/asyncping", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public DeferredResult<Response> asyncping() {
        DeferredResult<Response> result = new DeferredResult<Response>();
        new Thread(() -> {
            try {
//                log.info("----------------------------[asyncping sleep]");
                Thread.sleep(3000);
                result.setResult(ResponseUtil.success(name + ",中文,"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        return result;
    }

    @RequestMapping(value = "/get", method = {RequestMethod.GET})
    public Response<String> get(PingRequest ping) {
        log.info("ping request = {}", ping);
//        pingService.call();

        return ResponseUtil.success();
    }

    @RequestMapping("/test")
    public DeferredResult<String> test() {
        DeferredResult<String> result = new DeferredResult();

        return result;
    }

}