package com.hlj.thrift.common;

import com.facebook.nifty.client.FramedClientConnector;
import com.facebook.nifty.client.NiftyClientConnector;
import com.facebook.swift.service.ThriftClientManager;
import com.hlj.thrift.HljService;
import org.apache.thrift.TException;

import java.lang.reflect.Method;

import static com.google.common.net.HostAndPort.fromParts;

public class ThriftClientFactory {
    public static <T> T createThriftClient(Class<T> type) {
        ThriftClientManager clientManager = new ThriftClientManager();
        NiftyClientConnector connector = new FramedClientConnector(fromParts("localhost", 12345));
        T t = null;
        try {
            t = (T) clientManager.createClient(connector, type).get();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return t;
    }

    public static void main(String[] args) throws TException {
        HljService service = ThriftClientFactory.createThriftClient(HljService.class);
        System.out.println(service);
        System.out.println(service.getClass());
        for (Method method : service.getClass().getDeclaredMethods()) {
            System.out.println(method.getName());
        }
        service.ping();
    }
}