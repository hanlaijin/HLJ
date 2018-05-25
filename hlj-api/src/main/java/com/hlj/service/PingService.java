package com.hlj.service;

import com.hlj.aop.AN;
import com.hlj.common.utils.ThriftClientFactory;
import com.hlj.controller.PingController;
import com.hlj.thrift.HljService;
import org.apache.thrift.TException;
import org.springframework.stereotype.Service;

@Service
public class PingService {

    public static HljService service = ThriftClientFactory.createThriftClient(HljService.class);

    @AN
    public String ping(String mac) throws TException {
        return mac;
    }

    public String get(String key) throws TException {
        return service.getFromQueue(key);
    }
}