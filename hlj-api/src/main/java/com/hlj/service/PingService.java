package com.hlj.service;

import com.hlj.common.utils.ThriftClientFactory;
import com.hlj.thrift.HljService;
import com.hlj.thrift.HljThriftService;
import org.apache.thrift.TException;
import org.springframework.stereotype.Service;

@Service
public class PingService {

    HljService service = ThriftClientFactory.createThriftClient(HljThriftService.class);

    public String ping() throws TException {
        return service.ping();
    }
}