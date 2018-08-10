package com.hlj.controller;

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

import javax.annotation.Resource;


@Slf4j
@RestController
public class PingController {

    @Value("${com.hlj.properties}")
    private String name;

    @Resource
    private PingService pingService;

    @GetMapping(value = "/ping", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Response ping() {
        return ResponseUtil.success(name + "中文");
    }

    @RequestMapping(value = "/get", method = {RequestMethod.GET})
    public Response<String> get(PingRequest ping){
        log.info("ping request = {}", ping);
        pingService.call();
        return ResponseUtil.success();
    }
}