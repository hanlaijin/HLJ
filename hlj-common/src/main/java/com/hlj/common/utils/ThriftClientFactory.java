package com.hlj.common.utils;

import com.facebook.nifty.client.FramedClientConnector;
import com.facebook.nifty.client.NiftyClientConnector;
import com.facebook.swift.service.ThriftClientManager;
import com.hlj.thrift.HljService;
import lombok.extern.slf4j.Slf4j;
import org.apache.thrift.TException;

import static com.google.common.net.HostAndPort.fromParts;

@Slf4j
public class ThriftClientFactory {
    public static <T> T createThriftClient(Class<T> type) {
        ThriftClientManager clientManager = new ThriftClientManager();
        NiftyClientConnector connector = new FramedClientConnector(fromParts("localhost", 12345));
        T t = null;
        try {
            t = (T) clientManager.createClient(connector, type).get();
        } catch (Exception e) {
            e.printStackTrace();
            log.error("create thrift client failed.", e);
        }
        return t;
    }

    public static void main(String[] args) throws TException {
        HljService service = ThriftClientFactory.createThriftClient(HljService.class);
        System.out.print(service);
        System.out.println(service.ping());
    }
}