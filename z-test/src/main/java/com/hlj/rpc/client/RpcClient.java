package com.hlj.rpc.client;

import java.lang.reflect.Proxy;

/**
 * Created by hanlaijin@xiaomi.com on 18-9-5.
 */
public class RpcClient<T> {

    public T getRpcClient(Class<?> clazz) {
        return (T) Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), new RpcHandler(clazz));
    }
}
