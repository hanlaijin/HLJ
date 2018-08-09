package com.hlj.common.utils;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by hanlaijin@xiaomi.com on 17-9-27.
 */
public class ScheduleThread {

    private CallBack callBack = null;

    static ScheduledExecutorService service = Executors.newScheduledThreadPool(1);

    public void setCallBack(CallBack callBack) {
        this.callBack = callBack;
    }

    public void start(long initialDelay, long period, TimeUnit timeUnit) {
        service.scheduleAtFixedRate(() -> callBack.onCall(), initialDelay, period, timeUnit);
    }
}