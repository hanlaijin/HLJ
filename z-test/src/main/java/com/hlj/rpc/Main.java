package com.hlj.rpc;

import com.hlj.rpc.client.RpcClient;
import com.hlj.rpc.provider.EchoService;
import com.hlj.rpc.provider.EchoServiceImpl;
import com.hlj.rpc.server.RpcSever;

/**
 * Created by hanlaijin@xiaomi.com on 18-9-10.
 */
public class Main {
    public static void main(String[] args) {
        new Thread(()->{
            RpcSever sever = new RpcSever();
            sever.start();
        }).start();
        RpcClient<EchoService> client = new RpcClient();
        EchoService service =  client.getRpcClient(new EchoServiceImpl().getClass());
        System.out.println(service.echo());
    }
}
