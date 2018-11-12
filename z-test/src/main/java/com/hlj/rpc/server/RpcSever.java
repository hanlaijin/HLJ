package com.hlj.rpc.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by hanlaijin@xiaomi.com on 18-9-5.
 */
public class RpcSever {
    ExecutorService pool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    public void start() {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket();
            serverSocket.bind(new InetSocketAddress("localhost", 13345));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("server start... pool size = " + Runtime.getRuntime().availableProcessors());
        while (true) {
            pool.execute(new RpcTask(serverSocket));
        }
    }
}
