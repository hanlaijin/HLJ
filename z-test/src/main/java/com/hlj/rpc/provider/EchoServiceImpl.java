package com.hlj.rpc.provider;

/**
 * Created by hanlaijin@xiaomi.com on 18-9-5.
 */
public class EchoServiceImpl implements EchoService {
    @Override
    public String echo() {
        return "hello rpc";
    }
}
