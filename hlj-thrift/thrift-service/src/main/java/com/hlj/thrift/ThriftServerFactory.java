package com.hlj.thrift;

import com.facebook.nifty.core.NettyServerConfig;
import com.facebook.nifty.core.ThriftServerDef;
import com.facebook.swift.codec.ThriftCodecManager;
import com.facebook.swift.service.ThriftServer;
import com.facebook.swift.service.ThriftServiceProcessor;
import com.google.common.collect.ImmutableList;
import org.springframework.boot.CommandLineRunner;

public class ThriftServerFactory implements CommandLineRunner {
    @Override
    public void run(String... strings) throws Exception {
        try {
            ThriftServiceProcessor processor = new ThriftServiceProcessor(new ThriftCodecManager(), ImmutableList.of(), new HljThriftService());
            ThriftServerDef serverDef = ThriftServerDef.newBuilder().listen(12345).withProcessor(processor).build();
            NettyServerConfig serverConfig = NettyServerConfig.newBuilder().build();
            ThriftServer server = new ThriftServer(serverConfig, serverDef);
            server.start();
            System.out.println("thrift 服务已启动");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }

    }
}