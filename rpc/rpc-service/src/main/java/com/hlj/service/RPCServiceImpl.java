package com.hlj.service;

import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

/**
 * Created by hanlaijin@xiaomi.com on 18-8-14.
 */
@Component
@Service(timeout = 5000)
public class RPCServiceImpl implements RPCService {
    @Override
    public String ping() {
        return "dubbo rpc 呵呵";
    }
}
