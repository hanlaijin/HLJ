package com.hlj.service;

import com.hlj.common.utils.ThriftClientFactory;
import com.hlj.controller.PingController;
import com.hlj.thrift.HljService;
import org.apache.thrift.TException;
import org.springframework.stereotype.Service;

@Service
public class PingService {

    public static HljService service = ThriftClientFactory.createThriftClient(HljService.class);

    public String ping() throws TException {
        return service.ping();
    }

    public String get(String key) throws TException {
        return service.getFromQueue(key);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new PingService().ping());
    }
}