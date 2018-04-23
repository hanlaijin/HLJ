package com.hlj.common.utils;

import com.facebook.nifty.client.FramedClientConnector;
import com.facebook.nifty.client.NiftyClientConnector;
import com.facebook.swift.service.ThriftClientManager;
import lombok.extern.slf4j.Slf4j;

import static com.google.common.net.HostAndPort.fromParts;

/**
 * Created by hanlaijin@xiaomi.com on 17-10-20.
 */
@Slf4j
public class ThriftFactory {

    public static <T> T getClient(Class<T> type) {
        ThriftClientManager clientManager = new ThriftClientManager();
        NiftyClientConnector connector = new FramedClientConnector(fromParts("localhost", 12345));
        T t = null;
        try {
            t = (T) clientManager.createClient(connector, type).get();
        } catch (Exception e) {
            log.error("create thrift client failed.", e);
        }
        return t;
    }
}
