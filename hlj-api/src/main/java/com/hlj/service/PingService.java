package com.hlj.service;

import com.hlj.common.utils.ThriftClientFactory;
import com.hlj.thrift.HljService;
import org.apache.thrift.TException;
import org.springframework.stereotype.Service;

@Service
public class PingService {

    public static HljService service = ThriftClientFactory.createThriftClient(HljService.class);

    public String ping() throws TException {
        return service.ping();
    }
}