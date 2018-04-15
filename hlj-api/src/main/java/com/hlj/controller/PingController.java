package com.hlj.controller;

import com.hlj.common.dto.ResponseDto;
import com.hlj.common.utils.ResponseUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PingController {

    @GetMapping(value = "/ping")
    @ResponseBody
    public ResponseDto ping() {
        return ResponseUtil.success();
    }
}